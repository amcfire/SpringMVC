package com.onlineShop.dao.impl;

import com.onlineShop.dao.AdministratorDao;
import com.onlineShop.model.Administrator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mingwei on 10/14/2018.
 */
@Repository
@DynamicUpdate
@Transactional
public class AdministratorDaoImpl implements AdministratorDao {

    @Autowired
    SessionFactory sessionFactory;

    public void editAdmin(Administrator administrator) {
        Session session = sessionFactory.getCurrentSession();
        session.update(administrator);
        session.flush();
    }

    /**
     *
     * Get Admin By UserId
     * @Note please don't change this method.
     * please create your own method.
     * @author Mingwei
     * @date 10/12/2018
     * @param userId
     * @return
     */
    public Administrator getAdminByUserId(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Administrator where userId = ?");
        query.setInteger(0, userId);
        return (Administrator) query.uniqueResult();
    }
}
