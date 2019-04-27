package com.onlineShop.controller;

import com.onlineShop.Constant;
import com.onlineShop.SessionUtil;
import com.onlineShop.model.Address;
import com.onlineShop.model.User;
import com.onlineShop.service.AddressService;
import com.onlineShop.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * User Controller
 * Created by Mingwei on 10/24/2018
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    /**
     * Retrieve Address
     * @Author Mingwei
     * @Date 10/24/2018
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getAddress(Model model, HttpServletRequest request) {
        String retPage = Constant.EMPTY;
        try{
            String msg = request.getParameter(Constant.MSG);
            if(!StringUtils.isEmpty(msg)) model.addAttribute(Constant.MSG, msg);
            User user = SessionUtil.getUser();
            retPage = getReturnPage(user);
            if(user == null) return retPage;
            Address address = new Address();
            if(user.getCustomer() != null) address = user.getCustomer().getAddress();
            else if(user.getVendor() != null) address = user.getVendor().getAddress();
            model.addAttribute("address", address);
        }catch(Exception e){
            model.addAttribute(Constant.MSG, Constant.Message.FAILURE);
            model.addAttribute(Constant.MSG_DETAIL, Constant.Message.SYSTEM_EXCEPTION);
            Logger.getLogger(AddressController.class).error(e);
        }
        return retPage;
    }

    /**
     * Edit User
     * @Author Mingwei
     * @Date 10/24/2018
     * @param address
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid @ModelAttribute("address") Address address, BindingResult result, Model model) {
        String retPage = Constant.EMPTY;
        try{
            User user = SessionUtil.getUser();
            retPage = getReturnPage(user);
            if(user == null) return retPage;
            if(result.hasErrors()) return retPage;
            addressService.editAddress(address);
            model.addAttribute("address", address);
            model.addAttribute(Constant.MSG, Constant.Message.SUCCESS);
            model.addAttribute(Constant.MSG_DETAIL, Constant.Message.ADDRESS_UPDATE_SUCCESS);
        }catch(Exception e){
            model.addAttribute(Constant.MSG, Constant.Message.FAILURE);
            model.addAttribute(Constant.MSG_DETAIL, Constant.Message.SYSTEM_EXCEPTION);
            Logger.getLogger(AddressController.class).error(e);
        }
        return retPage;

    }

    /**
     * Get returned page
     * @Author Mingwei
     * @Date 10/24/2018
     * @param user
     * @return
     */
    private String getReturnPage(User user){
        if(user == null) return "redirect:/";
        if(user.getCustomer() != null) return "template/shop/profileaddress";
        if(user.getVendor() != null) return "template/dashboard/vendor_address";
        else return "redirect:/";
    }
}
