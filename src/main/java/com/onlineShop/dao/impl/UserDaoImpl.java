package com.onlineShop.dao.impl;

import com.onlineShop.Constant;
import com.onlineShop.dao.UserDao;
import com.onlineShop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mingwei on 10/12/2018
 * Modified by Andres on 10/23/2018
 */
@Repository
@DynamicUpdate
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    /**
     * Edit User
     * @Author Mingwei
     * @Date 10/12/2018
     * @param user
     */
    public void editUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.flush();
    }

    /**
     * Get User By UserId
     * @Author Mingwei
     * @Date 10/12/2018
     * @param userId
     * @return
     */
    public User getUserByUserId(int userId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where userId = ? and isActive = ?");
        query.setInteger(0, userId);
        query.setBoolean(1, Constant.Active.YES);
        return (User) query.uniqueResult();
    }

    //Added by Andres
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();
    }

    //Added by Andres
    public User getUserById(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, userId);
    }

    //Added by Andres
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();
        return userList;
    }

    //Added by Andres
    public User getUserByEmail(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username = ?");
        query.setString(0, username);
        return (User) query.uniqueResult();
    }
}
