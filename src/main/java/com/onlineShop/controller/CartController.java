package com.onlineShop.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Le on 1/25/2016.
 */

@Controller
@RequestMapping("/customer/cart")
public class CartController {

//hello
    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
//        CustomerBackup customerBackup = customerService.getCustomerByUsername (activeUser.getUsername());
//        int cartId = customerBackup.getCart().getCartId();

//        return "redirect:/customerBackup/cart/"+cartId;
        return "";
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "template/shop/cart";
    }

}
