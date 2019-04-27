package com.onlineShop.dao.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.dao.PaymentDao;
import com.onlineShop.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
@Transactional
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public OrderPayment getOrderPayment(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderPayment where customerId = ? and orderStatus='PENDING'");
        query.setInteger(0, customerId);
        OrderPayment orderPayment = (OrderPayment)query.uniqueResult();
        if(orderPayment==null)
            return null;
        Customer customer = (Customer) session.get(Customer.class, customerId);
        orderPayment.setCustomer(customer);
        orderPayment.setAddress(customer.getAddress());
        return orderPayment;
    }

    @Override
    public List<OrderDetail> getOrderDetail(int orderPaymentId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetail where orderPaymentId = ? ");
        query.setInteger(0, orderPaymentId);
        List<OrderDetail> orderDetailList = query.list();
        return orderDetailList;
    }

    @Override
    public Subscription getSubscription() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Subscription where status='A'");
        return (Subscription)query.uniqueResult();
    }

    @Override
    public Product blockProduct(OrderPayment orderPayment){
        Session session = sessionFactory.getCurrentSession();
        for(int i=0;i<orderPayment.getOrderDetailList().size();i++) {
            OrderDetail orderDetail = orderPayment.getOrderDetailList().get(i);
            OrderDetail dbOrderDetail = (OrderDetail) session.get(OrderDetail.class, orderDetail.getOrderDetailId());
            if(dbOrderDetail.getProduct().getUnitInStock()<dbOrderDetail.getQuantity()){
                return  dbOrderDetail.getProduct();
            }
            else {
                dbOrderDetail.getProduct().setUnitInStock(dbOrderDetail.getProduct().getUnitInStock()-dbOrderDetail.getQuantity());
                session.saveOrUpdate(dbOrderDetail);
            }
        }
        session.flush();
        return null;
    }

    @Override
    public boolean checkOut(OrderPayment orderPayment) {
        Session session = sessionFactory.getCurrentSession();
        OrderPayment orderPaymentTmp = (OrderPayment) session.get(OrderPayment.class, orderPayment.getOrderPaymentId());
        orderPaymentTmp.setPaidDate(new Date());
        orderPaymentTmp.setOrderStatus("PAYED");
        session.saveOrUpdate(orderPaymentTmp);
        session.flush();
        return true;
    }

    @Override
    public Messages getMsg(int msgId) {
        Session session = sessionFactory.getCurrentSession();
        return (Messages) session.get(Messages.class, msgId);
    }

    @Override
    public boolean writeToFinTxns(OrderPayment orderPayment, Subscription subscription) {
        Session session = sessionFactory.getCurrentSession();
        List<OrderDetail> orderDetailList = orderPayment.getOrderDetailList();
        for (OrderDetail orderDetail : orderDetailList) {
            CompanyFinTxn companyFinTxn = new CompanyFinTxn();
            companyFinTxn.setPaidDate(new Date());
            companyFinTxn.setAmount((orderDetail.getQuantity() * orderDetail.getProduct().getProductPrice()) * subscription.getCompPercentage() / 100);
            companyFinTxn.setProductId(orderDetail.getProduct().getProductId());
            companyFinTxn.setStatus("Payed");

            VendorFinTxn vendorFinTxn = new VendorFinTxn();
            vendorFinTxn.setPaidDate(new Date());
            vendorFinTxn.setAmount(orderDetail.getQuantity() * orderDetail.getProduct().getProductPrice() * subscription.getVendorPercentage() / 100);
            vendorFinTxn.setProductId(orderDetail.getProduct().getProductId());
            vendorFinTxn.setStatus("Payed");

            TaxFinTxn taxFinTxn = new TaxFinTxn();
            taxFinTxn.setPaidDate(new Date());
            taxFinTxn.setAmount(orderDetail.getQuantity() * orderDetail.getProduct().getProductPrice() * subscription.getTaxPercentage() / 100);
            taxFinTxn.setProductId(orderDetail.getProduct().getProductId());
            taxFinTxn.setStatus("Payed");

            session.saveOrUpdate(companyFinTxn);
            session.saveOrUpdate(vendorFinTxn);
            session.saveOrUpdate(taxFinTxn);
        }
        session.flush();
        return true;
    }
}
