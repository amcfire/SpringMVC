package com.onlineShop.controller;

import com.onlineShop.model.Category;
import com.onlineShop.model.Product;
import com.onlineShop.service.CategoryService;
import com.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andres
 */

@Controller
public class AndreasController {
    @RequestMapping("/adminlogin")
    public String loginadmin() {
        return "template/dashboard/login";
    }


    @RequestMapping("/vendorlogin")
    public String vendorlogin() {
        return "template/dashboard/vendorlogin";
    }
}