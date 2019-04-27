package com.onlineShop.controller.validation;

import com.onlineShop.model.User;
import com.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

/**
 * Created by Mingwei on 10/21/2018
 */
@Repository
public class UserValidator {
    @Autowired
    UserService userService;
    private static final String O = "oldPassword";
    private static final String N = "newPassword";
    private static final String R = "reEnterPassword";
    private static final String OO = "Old password";
    private static final String NN = "New password";
    private static final String RR = "Re-enter password";
    private static final String U = "error.user";
    private static final String N_E = " may not be empty.";
    private static final String I_I = " is incorrect.";
    private static final String N_S = " may not be same as ";
    private static final String S_S = " should be same as ";

    /**
     * Password validation
     * Created by Mingwei on 10/21/2018
     * @param res
     * @param user
     * @param truePassword
     * @return
     */
    public User validate(BindingResult res, User user, String truePassword){
        // duplicated username(email) check
        String oldUserName = userService.getUserByUserId(user.getUserId()).getUserName();
        String newUserName = user.getUserName();
        if(!StringUtils.isEmpty(newUserName) && !newUserName.equals(oldUserName)){
            User userForCheck = userService.getUserByEmail(newUserName);
            if(userForCheck!=null) res.rejectValue("userName", U,"This username(email) has been registered.");
        }
        // password check
        String o,n,r;
        o = user.getOldPassword();
        n = user.getNewPassword();
        r = user.getReEnterPassword();
        if(!StringUtils.isEmpty(o) || !StringUtils.isEmpty(n) || !StringUtils.isEmpty(r)){
            // Old password check
            if(!o.equals(truePassword)){
                res.rejectValue(O, U, OO + I_I);
                return user;
            }
            // empty check
            if(StringUtils.isEmpty(o)){
                res.rejectValue(O, U, OO + N_E);
                return user;
            }
            if(StringUtils.isEmpty(n)){
                res.rejectValue(N, U, NN + N_E);
                return user;
            }
            if(StringUtils.isEmpty(r)){
                res.rejectValue(R, U, RR + N_E);
                return user;
            }
            // New password check
            if(n.equals(o)){
                res.rejectValue(N, U, NN + N_S + OO);
                return user;
            }
            // Re-entry password check
            if(!r.equals(n)){
                res.rejectValue(R, U, RR + S_S + NN);
                return user;
            }
            user.setPassword(n);
        }
        return user;
    }
}
