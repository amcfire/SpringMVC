package com.onlineShop.controller;

import com.onlineShop.model.Customer;
import com.onlineShop.model.Result;
import com.onlineShop.model.User;
import com.onlineShop.service.EmailService;
import com.onlineShop.service.EncryptionService;
import com.onlineShop.service.UserService;
import com.onlineShop.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */

@Controller
public class RegisterController {

//    @Autowired
//    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    private EncryptionService encryptionService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {

//        Customer customerBackup = new Customer();
//        BillingAddress billingAddress = new BillingAddress();
//        ShippingAddress shippingAddress = new ShippingAddress();
//        customerBackup.setBillingAddress(billingAddress);
//        customerBackup.setShippingAddress(shippingAddress);
//
//        model.addAttribute("customer", customerBackup);

        return "template/shop/registerCustomer";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customerBackup, BindingResult result,
                                       Model model) {

//        if (result.hasErrors()) {
//            return "template/shop/registerCustomer";
//        }
//
//        List<Customer> customerBackupList =customerService.getAllCustomers();
//
//        for (int i = 0; i< customerBackupList.size(); i++) {
//            if(customerBackup.getCustomerEmail().equals(customerBackupList.get(i).getCustomerEmail())) {
//                model.addAttribute("emailMsg", "Email already exists");
//
//                return "template/shop/registerCustomer";
//            }
//
//            if(customerBackup.getUsername().equals(customerBackupList.get(i).getUsername())) {
//                model.addAttribute("usernameMsg", "Username already exists");
//
//                return "template/shop/registerCustomer";
//            }
//        }
//
//        customerBackup.setEnabled(true);
//        customerService.addCustomer(customerBackup);

        return "template/shop/registerCustomerSuccess";

    }

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    public String ChangePassword(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "forgotpassword";
    }

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
    public String ChangePassword(@RequestParam("email") String email) {
        User realuser =this.userService.getUserByEmail(email);
        if  ( realuser != null )
        {
            List<User> userList=userService.getAllUsers();
            boolean validuser = false;
            for (int i=0; i< userList.size(); i++) {
                if(email.equals(userList.get(i).getUserName())) {
                    validuser = true;
                }
            }
            if(validuser) {
//                EncryptionService encryptionService = new EncryptionServiceImpl();
                String encryptedText = realuser.getPassword();
//                String DecryptedPass = encryptionService.DecryptPass(encryptedText);
                EmailService emailService = new EmailServiceImpl();
                String MesPass = ("Your password is: " + encryptedText + "   --- Please change your password on next login.");
                Result newmail = emailService.sendEmail(email,"Password Recovery",MesPass);
                return "/template/shop/loginpage";
            }else{
               // model.addAttribute("error", "Invalid Email!!!");
                return "/template/shop/home";
            }
        }
        //model.addAttribute("error", "Invalid Email!!!");
        return "/template/shop/home";
    }

}
