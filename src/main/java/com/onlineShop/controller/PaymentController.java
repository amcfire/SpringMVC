package com.onlineShop.controller;

import com.onlineShop.SessionUtil;
import com.onlineShop.model.*;
import com.onlineShop.service.*;
import com.onlineShop.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class PaymentController {

    @Autowired
    private CardService cardService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping("/payment")
    public String payment(Model model)
    {
        //int customerId = 1;
        User user = SessionUtil.getUser();
        if(user==null)
        {
            return "redirect:/loginpage";
        }
        int customerId = user.getCustomer().getCustomerId();
        Subscription subscription = subscriptionService.getSubscription();
        if(subscription==null)
        {
            model.addAttribute("ERROR_MESSAGE", "Please configure subscription.");
            return "template/shop/paymentpage";
        }
        List<CardDetail> cardDetailList = cardService.getCardList(customerId);
        if(cardDetailList==null||cardDetailList.size()==0)
        {
            model.addAttribute("ERROR_MESSAGE", "Please add card.");
        }
        model.addAttribute("cards", cardDetailList);

        OrderPayment orderPayment = paymentService.getOrderPayment(customerId);
        model.addAttribute("orderPayment", orderPayment);
        if(orderPayment==null)
        {
            model.addAttribute("ERROR_MESSAGE", "No pending cart is registered.");
            return "template/shop/paymentpage";
        }
        if(orderPayment.getOrderDetailList().isEmpty())
        {
            model.addAttribute("ERROR_MESSAGE", "No pending available cart details.");
            return "template/shop/paymentpage";
        }

        double total = 0;
        for(int i=0;i<orderPayment.getOrderDetailList().size();i++)
        {
            OrderDetail orderDetail = orderPayment.getOrderDetailList().get(i);
            total = total + orderDetail.getProduct().getProductPrice() * orderDetail.getQuantity();
        }
        double taxAmount = total*subscription.getTaxPercentage()/100;
        orderPayment.setTotal(total);
        orderPayment.setTaxAmount(taxAmount);
        orderPayment.setTotalAmount(orderPayment.getTotal()+taxAmount);
        model.addAttribute("orderPayment", orderPayment);
        return "template/shop/paymentpage";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String doPayment(@ModelAttribute("orderPayment") @Valid OrderPayment orderPayment,
                                BindingResult result, Model model, String selCard, boolean newaddress) {
        //int customerId = 1;
        User user = SessionUtil.getUser();
        if(user==null)
        {
            return "redirect:/loginpage";
        }
        int customerId = user.getCustomer().getCustomerId();
        model.addAttribute("orderPayment", orderPayment);
        List<CardDetail> cardDetailList = cardService.getCardList(customerId);
        if(cardDetailList==null||cardDetailList.size()==0)
        {
            model.addAttribute("ERROR_MESSAGE", "Please add card.");
        }
        model.addAttribute("cards", cardDetailList);

        if (result.hasErrors()) {
            return "template/shop/paymentpage";
        }

        if(selCard==null||selCard.isEmpty())
        {
            model.addAttribute("ERROR_MESSAGE","Please select a card.");
            return "template/shop/paymentpage";
        }

        CardDetail cardDetail = cardService.getCardById(Integer.parseInt(selCard));
        orderPayment.setCard(cardDetail);
        orderPayment.setCustomer(cardDetail.getCustomer());
        if(!cardDetail.getZipCode().equals(orderPayment.getZipCode()))
        {
            model.addAttribute("ERROR_MESSAGE","Wrong zip code.");
            return "template/shop/paymentpage";
        }
        Result result1 = paymentService.doPayment(orderPayment, newaddress);
        if(result1.getId()==0)
        {
            model.addAttribute("SUCCESS_MESSAGE",result1.getMessage());
        }
        else
        {
            model.addAttribute("ERROR_MESSAGE",result1.getMessage());
        }

        return "template/shop/paymentpage";
    }
}

