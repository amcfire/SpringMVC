package com.onlineShop.controller;

import com.onlineShop.SessionUtil;
import com.onlineShop.model.*;
import com.onlineShop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Le on 1/24/2016.
 */

@Controller
public class HomeController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("products", productService.findAll());
        return "template/shop/home";
//        return "redirect:/vendor/product/new";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
            required = false) String logout, Model model) {
        if (error!=null) {
            model.addAttribute("error", "Invalid username and password!!!");
        }

        if(logout!=null) {
            model.addAttribute("msg", "You have been logged out correctly!!!!!!!!!!! test12");
        }
        return "template/shop/loginpage";
    }

    @RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
    public String getShippingCartItems(Model model, HttpSession session) {

        List<Product> products = new ArrayList<>();
        model.addAttribute("categories", categoryService.findAllCategories());

        if (session.getAttribute("shoppingCart") == null) {
            return "template/shop/shoppingcart";
        }

        HashMap<Long, Integer> cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
        int total = 0;
        for (Long productId : cartItems.keySet()) {
            Product p = productService.findById(productId.intValue());
            total+=p.getProductPrice()*cartItems.get(productId);
            products.add(p);
        }

//        System.out.println(products.get(0) + "=================");

        model.addAttribute("products", products);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);



        return "template/shop/shoppingcart";
    }

    @RequestMapping(value = "/addItemToShoppingCart", method = RequestMethod.POST)
    public String addItemToShoppingCart(@ModelAttribute("shoppingCartItems") ShoppingCartItems shoppingCartItems, HttpSession session) {
        HashMap<Long, Integer> cartItems;

        Long cartItemId = shoppingCartItems.getProductId();
        int cartItemQuantity = shoppingCartItems.getQuantity();

        if (session.getAttribute("shoppingCart") == null) {
            System.out.println("Add New Prod");
            cartItems = new HashMap<>();
            cartItems.put(cartItemId, cartItemQuantity);
            session.setAttribute("shoppingCart", cartItems);
        } else {
            System.out.println("old session");
            cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
            if (cartItems.containsKey(cartItemId)) {
                cartItems.put(cartItemId, cartItems.get(cartItemId) + cartItemQuantity);
                for (Long name : cartItems.keySet()) {
                    String key = name.toString();
                    String value = cartItems.get(name).toString();
                    System.out.println("key = " + key + " value = " + value);
                }
            } else {
                cartItems.put(cartItemId, cartItemQuantity);
            }
        }
        return "redirect:/viewProd";
    }

    @RequestMapping(value = "/ajaxAddItemToShoppingCart", method = RequestMethod.POST)
    public @ResponseBody
    int ajaxAddItemToShoppingCart(@RequestBody ShoppingCartItems shoppingCartItems, HttpSession session) {
        HashMap<Long, Integer> cartItems;
        System.out.println(shoppingCartItems.getProductId() + "------------------------------------");

        Long cartItemId = shoppingCartItems.getProductId();
        int cartItemQuantity = shoppingCartItems.getQuantity();


        Integer unitStock = productService.getProductById(shoppingCartItems.getProductId()).getUnitInStock();
        if(unitStock < cartItemQuantity){
            return -1;
        }

        if (session.getAttribute("shoppingCart") == null) {
            System.out.println("Add New Prod");
            cartItems = new HashMap<>();
            cartItems.put(cartItemId, cartItemQuantity);
            session.setAttribute("shoppingCart", cartItems);
        } else {
            System.out.println("old session");
            cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
            if (cartItems.containsKey(cartItemId)) {
                cartItems.put(cartItemId, cartItemQuantity);
                for (Long name : cartItems.keySet()) {
                    String key = name.toString();
                    String value = cartItems.get(name).toString();
                    System.out.println("key = " + key + " value = " + value);
                }
            } else {
                cartItems.put(cartItemId, cartItemQuantity);
            }
        }

        return cartItems.keySet().size();
    }


    @RequestMapping(value = "/ajaxDeleteItemToShoppingCart", method = RequestMethod.POST)
    public @ResponseBody
    int ajaxDeleteItemToShoppingCart(@RequestBody ShoppingCartItems shoppingCartItems, HttpSession session) {
        HashMap<Long, Integer> cartItems;
        Long cartItemId = shoppingCartItems.getProductId();
        int cartItemQuantity = shoppingCartItems.getQuantity();

        if (session.getAttribute("shoppingCart") == null) {
            return -1;
        } else {
            cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
            if (cartItems.containsKey(cartItemId)) {
                cartItems.remove(cartItemId);

            } else {
                return -1;
            }
        }
        return cartItemId.intValue();
    }

    @RequestMapping(value = "/ajaxGetShoppingCartItemCount", method = RequestMethod.POST)
    public @ResponseBody
    int ajaxGetShoppingCartItemCount(HttpSession session) {
        HashMap<Long, Integer> cartItems;

        if (session.getAttribute("shoppingCart") == null) {
            return 0;
        }

        cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");

        return cartItems.keySet().size();
    }

    @RequestMapping(value = "/viewProd", method = RequestMethod.GET)
    public ModelAndView viewProd() {
        return new ModelAndView("addProdToShoppingCart", "shoppingCartItems", new ShoppingCartItems());
    }

    @RequestMapping(value = "/deleteShoppingCart", method = RequestMethod.POST)
    public String deleteShoppingCard(@ModelAttribute("shoppingCartItems") ShoppingCartItems shoppingCartItems, HttpSession session) {
        System.out.println("delete");
        Long cartItemId = shoppingCartItems.getProductId();
        int cartItemQuantity = shoppingCartItems.getQuantity();
        HashMap<Long, Integer> cartItems;
        if (session.getAttribute("shoppingCart") != null) {
            cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
            if (cartItems.containsKey(cartItemId)) {
                int quantity = cartItems.get(cartItemId).intValue() - cartItemQuantity < 0 ? 0 : cartItems.get(cartItemId).intValue() - cartItemQuantity;
                if (quantity == 0) {
                    cartItems.remove(cartItems.remove(cartItemId));
                    System.out.println("Item remover from shopping cart");
                } else {
                    cartItems.put(cartItemId, quantity);
                    for (Long name : cartItems.keySet()) {
                        String key = name.toString();
                        String value = cartItems.get(name).toString();
                        System.out.println("key = " + key + " value = " + value);
                    }
                }
            }
        }
        return "redirect:/viewProd";
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String purchase(HttpSession session) {
//        test();
//        User user = (User)session.getAttribute("user");
//        System.out.println(user.getCustomer().getCustomerId()+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        User user = SessionUtil.getUser();
//        session.setAttribute("user", 1);

        if (user == null) {
            return "redirect:/loginpage";
        }
        Integer userId = user.getCustomer().getCustomerId();

        if (session.getAttribute("shoppingCart") == null) {
            return "redirect:/viewProd";
        }

        OrderPayment check_orderPayment = shoppingCartService.findByState("PENDING", userId);
        System.out.println("----------------------------------------------------8888888888888------------------------------");
        if (check_orderPayment != null) {
            System.out.println(check_orderPayment.getOrderDetailList().size() + "777777777777777777777777777777777777777");
            List<OrderDetail> odList = check_orderPayment.getOrderDetailList();//orderDetailService.findByOrderPaymentId(check_orderPayment.getOrderPaymentId());
//                    check_orderPayment.getOrderDetailList();
            System.out.println(odList.size() + " = 09999999999999999------------------------------------------------------------------------------");
//            System.out.println(odList.get(0) + " = 33333333333333333333333333333333333333333333333");
//            odList.forEach(od -> System.out.println(od.getOrderDetailId()+ "11[11111111111111111111111111111111"));
            //odList.forEach(od -> orderDetailService.deleteOrderDetail(od));
            shoppingCartService.remove(check_orderPayment);
        }

        HashMap<Long, Integer> hashMap = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (Long prodId : hashMap.keySet()) {
            OrderDetail orderDetail = new OrderDetail();
            int quantity = hashMap.get(prodId);
            orderDetail.setProduct(productService.findById(prodId.intValue()));//retrieve product information
            orderDetail.setQuantity(quantity);
            orderDetailService.addOrderDetail(orderDetail);
            orderDetailList.add(orderDetail);
        }

//        Integer userID = (Integer) session.getAttribute("user");
        System.out.println(userId + "--------------------------------------------------++++++++++++++++++++++++++");
        Customer customer = customerService.getCustomerById(userId);
        System.out.println(customer.getFirstName() + "   = llllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setCustomer(customer);
        orderPayment.setOrderDetailList(orderDetailList);
        orderPayment.setOrderStatus("PENDING");
        shoppingCartService.add(orderPayment);
        return "redirect:/paymentpage";
    }

    @RequestMapping(value = "/searchCategory", method = RequestMethod.GET)
    public String searchCategory(HttpServletRequest request, Model model) {
        Integer categoryId = (Integer) request.getAttribute("category");
        List<Product> products = productService.findByCategoryId(categoryId);
        model.addAttribute("products", products);
        return "redirect:/";
    }
    @RequestMapping(value = "/searchPriceAndCategory", method = RequestMethod.GET)
    public String searchPriceAndCategory(HttpServletRequest request, Model model) {
//        Integer categoryId = (Integer) request.getAttribute("category");
//        Double downPrice = (Double) request.getAttribute("downPrice");
//        Double upPrice = (Double) request.getAttribute("upPrice");
        Integer categoryId = 1;
        Double downPrice = 20d;
        Double upPrice = 100d;

        List<Product> products = productService.findPriceAndCategory(categoryId, downPrice, upPrice);

        products.forEach(product -> System.out.println(product.getProductName()));
        model.addAttribute("products", products);
        return "redirect:/";
    }

    @RequestMapping(value = "/searchSimilarProduct", method = RequestMethod.GET)
    public String searchSimilarProduct(HttpServletRequest request, Model model) {
        String productName = (String) request.getParameter("Product");
        String downPrice = request.getParameter("downPrice");
        String upPrice = request.getParameter("upPrice");

        System.out.println(productName + "99999999999999999999999999999999999");

        List<Product> products;
        if(productName == null){
            return "redirect:/";
        }
        if(downPrice == null || upPrice == null){
            products = productService.findSimilarProd(productName);
        }else {
            products = productService.findSimilarProdWithRange(productName, Double.valueOf(downPrice), Double.valueOf(upPrice));
        }
        products.forEach(product -> System.out.println(product.getProductName()));
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "/template/shop/productlist";
    }
    public String test(){
        System.out.println("Start Testing @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        String productName = "rey";
        Double downPrice = 10d;
        Double upPrice = 500d;
        List<Product> products;
        if(productName == null){
            return "redirect:/";
        }
        if(downPrice == null || upPrice == null){
            products = productService.findSimilarProd(productName);
        }else {
            products = productService.findSimilarProdWithRange(productName, downPrice, upPrice);
        }
        System.out.println(products.size());
        products.forEach(product -> System.out.println(product.getProductName()));
        return "redirect:/";
    }
}
