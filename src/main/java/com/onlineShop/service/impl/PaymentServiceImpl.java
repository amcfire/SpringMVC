package com.onlineShop.service.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.dao.PaymentDao;
import com.onlineShop.model.*;
import com.onlineShop.service.BankAPIService;
import com.onlineShop.service.EmailService;
import com.onlineShop.service.PaymentService;
import com.onlineShop.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private SubscriptionService subscriptionService;

    @Override
    public OrderPayment getOrderPayment(int customerId) {
        return paymentDao.getOrderPayment(customerId);
    }

    @Override
    public Result doPayment(OrderPayment orderPayment, boolean newAddress) {
        Subscription subscription = subscriptionService.getSubscription();
        if(subscription==null)
        {
            return new Result(41, "Please configure subscription.");
        }
        List<OrderDetail> orderDetailList = paymentDao.getOrderDetail(orderPayment.getOrderPaymentId());
        orderPayment.setOrderDetailList(orderDetailList);
        Product product = paymentDao.blockProduct(orderPayment);
        if(product!=null)
        {
            return new Result(42, "We are sorry, We have only "+product.getUnitInStock()+ " "+product.getProductName()+".");
        }
        LocalDate localDate = orderPayment.getCard().getCardExp().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        BankAPIService bankAPIService = new BankAPIServiceImpl();
        try {
            int bankResult = bankAPIService.callBankAPI(String.valueOf(orderPayment.getCard().getCardNumber()),
                    String.valueOf(localDate.getMonthValue()),
                    String.valueOf(localDate.getYear()),
                    String.valueOf(orderPayment.getCard().getSecurityNumber()),
                    String.valueOf(orderPayment.getCard().getCardHolderName()), String.valueOf(orderPayment.getCard().getZipCode()),
                    String.valueOf(orderPayment.getTotalAmount()));
            if (bankResult != 200) {
                Messages messages = paymentDao.getMsg(bankResult);
                if (messages == null)
                    return new Result(43, "Unknown bank error: " + String.valueOf(messages.getMsgId()));
                else
                    return new Result(bankResult, messages.getMsgValue());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        if(!paymentDao.checkOut(orderPayment))
        {
            return new Result(44, "Error occurred on check out.");
        }
        if(!paymentDao.writeToFinTxns(orderPayment, subscription))
        {
            return new Result(44, "Error occurred on financial transaction.");
        }
        EmailService emailService = new EmailServiceImpl();
        String receipt = "Transaction Successful. \r\nPurchase total: "+ orderPayment.getTotal()+"\r\n Tax:"+orderPayment.getTaxAmount()+"\r\nOverall amount:"+
                orderPayment.getTotalAmount()+"\r\n"+
                "Products:\r\n";
        for(OrderDetail orderDetail: orderPayment.getOrderDetailList())
        {
            receipt+="\r\n"+"Product: "+orderDetail.getProduct().getProductName()+"\r\nPrice:"+orderDetail.getProduct().getProductPrice()+"$\r\nQuantity:"+orderDetail.getQuantity()+"\r\n";
        }
        //Result result = emailService.sendEmail(orderPayment.getCustomer().getUser().getUserName(),"Purchase receipt",receipt);
        // if(result.getId()!=0)
        //    return result;

        return new Result(0,receipt);
    }
}
