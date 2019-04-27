package com.onlineShop.dao;

import com.onlineShop.model.Administrator;

public interface AdministratorDao {
    void editAdmin(Administrator administrator);
    Administrator getAdminByUserId(int userId);
}
