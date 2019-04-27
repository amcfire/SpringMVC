package com.onlineShop.controller;

import com.onlineShop.Constant;
import com.onlineShop.SessionUtil;
import com.onlineShop.controller.validation.UserValidator;
import com.onlineShop.model.User;
import com.onlineShop.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * User Controller
 * Created by Mingwei on 10/12/2018
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    /**
     * Retrieve user info by user id
     * @Author Mingwei
     * @Date 10/12/2018
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getUser(Model model, HttpServletRequest request) {
        String retPage = Constant.EMPTY;
        try{
            String msg = request.getParameter(Constant.MSG);
            if(!StringUtils.isEmpty(msg)) model.addAttribute(Constant.MSG, msg);
            User user = SessionUtil.getUser();
            retPage = getReturnPage(user);
            if(user == null) return retPage;
            model.addAttribute("user", user);
        }catch(Exception e){
            model.addAttribute(Constant.MSG, Constant.Message.FAILURE);
            model.addAttribute(Constant.MSG_DETAIL, Constant.Message.SYSTEM_EXCEPTION);
            Logger.getLogger(UserController.class).error(e);
        }
        return retPage;
    }

    /**
     * Edit User
     * @Author Mingwei
     * @Date 10/12/2018
     * @param user
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        String retPage = Constant.EMPTY;
        try{
            User userInDb = userService.getUserByUserId(user.getUserId());
            retPage = getReturnPage(userInDb);
            if(userInDb == null){
                model.addAttribute(Constant.MSG, Constant.Message.FAILURE);
                model.addAttribute(Constant.MSG_DETAIL, Constant.Message.USER_NOT_EXIST);
                return retPage;
            }
            // specific verification for duplicated username and password
            user = userValidator.validate(result, user, userInDb.getPassword());
            if(result.hasErrors()) return retPage;
            if(!StringUtils.isEmpty(user.getNewPassword())) user.setPassword(user.getNewPassword());
            else user.setPassword(userInDb.getPassword());
            user = userService.editUser(user);
            // Redirect to logout if username or password changing.
            if(!user.getPassword().equals(userInDb.getPassword()) || !user.getUserName().equals(userInDb.getUserName()))
                return "redirect:/j_spring_security_logout";
            model.addAttribute("user", user);
            model.addAttribute(Constant.MSG, Constant.Message.SUCCESS);
            model.addAttribute(Constant.MSG_DETAIL, Constant.Message.USER_UPDATE_SUCCESS);
        }catch(Exception e){
            model.addAttribute(Constant.MSG, Constant.Message.FAILURE);
            model.addAttribute(Constant.MSG_DETAIL, Constant.Message.SYSTEM_EXCEPTION);
            Logger.getLogger(UserController.class).error(e);
        }
        return retPage;

    }

    /**
     *
     * Delete User
     * @Author Mingwei
     * @Date 10/12/2018
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int userId, Model model ) {
        try{
            model.addAttribute(Constant.MSG, userService.delete(userId));
        }catch (Exception e){
            model.addAttribute(Constant.MSG, Constant.Message.FAILURE);
            model.addAttribute(Constant.MSG_DETAIL, Constant.Message.SYSTEM_EXCEPTION);
            Logger.getLogger(UserController.class).error(e);
        }
        return "redirect:/";
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
        if(user.getAdministrator() !=null) return "template/dashboard/profile";
        if(user.getVendor() != null) return "template/dashboard/vendor_profile";
        if(user.getCustomer() != null) return "template/shop/editCustomer";
        else return "redirect:/";
    }

}
