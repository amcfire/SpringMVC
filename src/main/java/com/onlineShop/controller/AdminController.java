package com.onlineShop.controller;

import com.onlineShop.model.Administrator;
import com.onlineShop.model.Customer;
import com.onlineShop.model.Result;
import com.onlineShop.service.AdminService;
import com.onlineShop.service.EmailService;
import com.onlineShop.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *   User: krish
 *   Date: 10/14/2018
 *   Time: 8:29 AM
 */

@Controller
@RequestMapping(value = "/myadmin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String registerCustomer(Model model){
        System.out.println("******************************");
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/template/shop/adminview/customer-form";
    }

    @RequestMapping(value = "/admin-view", method = RequestMethod.GET)
    public String adminview(){
        return "/template/shop/adminview/admin-view";
    }


    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
                               Model model){

        if (result.hasErrors()) {
            return "/template/shop/adminview/customer-form";
        }

        List<Customer> customerList = adminService.getAllCustomer();
        for(int i = 0; i< customerList.size(); i++){
            if (customer.getUser().getUserName().equals(customerList.get(i).getUser().getUserName())){
                model.addAttribute("emailMsg", "Email Already Exist");

                return "/template/shop/adminview/customer-form";
            }
        }

        adminService.addCustomer(customer);

      /*  //MailMail mm = new MailMail();
        MailMail mm =  (MailMail) context.getBean("mailMail");
        mm.sendMail("demoemail2018oct@gmail.com",
                "krishna.k.kc@gmail.com",
                "purai naya mail testing",
                "Testing only \n\n Hello Spring Email Sender");*/

//        System.out.println(customer.getUser().getUserName().toString() + "=====================");
//
//        EmailService emailService = new EmailServiceImpl();
//
//        Result result1 = emailService.sendEmail(customer.getUser().getUserName(), "Registration Success", "You are successfully registered User Name : "+ customer.getUser().getUserName()+ "Password :" + customer.getUser().getPassword());
//        if(result1.getId() ==0){
//            System.out.println("Success=========================");
//        }
        return "/template/shop/adminview/customer-registration-success";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
    public String registerAdmin(Model model){
        System.out.println("******************************");
        Administrator administrator = new Administrator();
        model.addAttribute("administrator", administrator);
        return "/template/shop/adminview/admin-form";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public String saveAdmin(@Valid @ModelAttribute("administrator") Administrator administrator, BindingResult result,
                            Model model){

        if (result.hasErrors()) {
            return "/template/shop/adminview/admin-form";
        }

        List<Administrator> administratorList = adminService.getAllAdmin();

        for(int i = 0; i< administratorList.size(); i++){
            if (administrator.getUser().getUserName().equals(administratorList.get(i).getUser().getUserName())){
                model.addAttribute("emailMsg", "Email Already Exist");

                return "/template/shop/adminview/admin-form";
            }
        }

        adminService.addAdmin(administrator);

      /*  //MailMail mm = new MailMail();
        MailMail mm =  (MailMail) context.getBean("mailMail");
        mm.sendMail("demoemail2018oct@gmail.com",
                "krishna.k.kc@gmail.com",
                "purai naya mail testing",
                "Testing only \n\n Hello Spring Email Sender");*/

        return "/template/shop/adminview/admin-registration-success";
    }
}
