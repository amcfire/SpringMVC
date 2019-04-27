package com.onlineShop;

/**
 * Created by Mingwei on 10/12/2018
 */
public class Constant {
    public static final class Role{
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String VENDOR = "ROLE_VENDOR";
        public static final String CUSTOMER = "ROLE_USER";
    }

    public static final class Active {
        public static final Boolean YES = true;
        public static final Boolean NO = false;
    }

    public static final String MSG = "msg";
    public static final String MSG_DETAIL = "msg_detail";
    public static final String EMPTY = "";
    public static final class Message{
        public static final String SUCCESS = "Success.";
        public static final String FAILURE = "Failure.";
        public static final String USER_UPDATE_SUCCESS = "User info update success!";
        public static final String ADDRESS_UPDATE_SUCCESS = "Address update success!";
        public static final String USER_NOT_EXIST = "User doesn't exist.";
        public static final String SYSTEM_EXCEPTION = "Server is busy now, please try again later.";
    }

}
