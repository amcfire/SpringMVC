package com.onlineShop.controller;

import com.onlineShop.model.OrderPayment;
import com.onlineShop.service.CustomerService;
import com.onlineShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerService customerService;

//    @RequestMapping(value = "/addItemToShoppingCart", method = RequestMethod.POST)
//    public String addProdToShoppingCart(HttpServletRequest request, Model model){
//        System.out.println("Hello");
//
//        OrderPayment orderPayment = (OrderPayment) request.getSession().setAttribute("shoppingCart", new OrderPayment());
//        HashMap<Product,Integer> cartDetail = new HashMap<>();
//
//
//        Product product = new Product();
//        product.setProductName("Book");
//        product.setProductPrice(10);
//        product.setFlag(2);
//        product.setUnitInStock(10);
//
//        OrderDetail orderDetail = new OrderDetail();
//        orderDetail.setProduct(product);
//        orderDetail.setQuantity(1);
//
//        Customer customer = customerService.getCustomerById(1);
//        OrderPayment orderPayment = new OrderPayment();
//
////        if(){
////
////        }
//
//        List<OrderDetail> orderDetailList = new ArrayList<>();
//        orderDetailList.add(orderDetail);
//
//
//        orderPayment.setCustomer(customer);
//        orderPayment.setOrderDate(new Date());
//        orderPayment.setOrderDetailList(orderDetailList);
//
////        shoppingCartService.add(orderPayment);
//        return "/addProdtoShoppingCart";
//    }

    private void addProdToSession(){

    }


//    @RequestMapping(value = "/deleteShoppingCart", method = RequestMethod.POST)
//    public String deleteShoppingCard(){
//        System.out.println("delete");
//        OrderPayment orderPayment = shoppingCartService.findById(1);
//        shoppingCartService.remove(orderPayment);
//        return "/";
//    }
}
