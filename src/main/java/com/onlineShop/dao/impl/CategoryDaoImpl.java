package com.onlineShop.dao.impl;

/*
 *  Created by Solomon 10/13/2018
 *  Online Shopping
 * */
import com.onlineShop.dao.CategoryDao;
import com.onlineShop.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@DynamicUpdate
@Transactional
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void editCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
        session.flush();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category where ");
        return null;
    }
    @Override
    public List<Category> categoryList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category");
        List<Category> categories = query.list();
        System.out.println("returnning---------------------------------------------------++++++++++++++++---------- list of categories");
        return categories;
    }

    @Override
    public Category findById(Integer categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category where categoryId = ?");
        query.setInteger(0,categoryId);
        Category category = (Category) query.uniqueResult();
        return category;
    }
}
