package com.onlineShop.dao.impl;


import com.onlineShop.dao.ProductDao;
import com.onlineShop.model.Product;
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
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Product findById(Integer prodId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productId = ? and flag = 2");
        query.setInteger(0, prodId);
        return (Product) query.uniqueResult();
    }

    @Override
    public List<Product> findByCategoryId(Integer categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where categoryID = ? and flag = 2");
        query.setInteger(0, categoryId);
        List<Product> prodList = query.list();
        return prodList;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where flag = 2");
        List<Product> prodList = query.list();
        return prodList;
    }

    @Override
    public List<Product> findPriceAndCategory(Integer categoryId, Double downPrice, Double upPrice) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where flag = 2 and categoryID = ? and productPrice between ? and ?");
        query.setInteger(0, categoryId);
        query.setDouble(1, downPrice);
        query.setDouble(2, upPrice);
        List<Product> prodList = query.list();
        return prodList;
    }
    @Override
    public List<Product> findSimilarProd(String productName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where flag = 2 and productName like CONCAT('%',?,'%')");
        query.setString(0, productName);
        List<Product> prodList = query.list();
        return prodList;
    }

    @Override
    public List<Product> findSimilarProdWithRange(String productName, Double downPrice, Double upPrice) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productName like CONCAT('%',?,'%') and flag = 2 and productPrice between ? and ?");
        query.setString(0, productName);
        query.setDouble(1, downPrice);
        query.setDouble(2, upPrice);
        List<Product> prodList = query.list();
        return prodList;
    }

    @Override
    public void Save(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        session.flush();
    }

    @Override
    public void update(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        session.flush();
    }

    @Override
    public Product getProductById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productId=? and flag = 2");
        query.setLong(0,id);
        return (Product) query.uniqueResult();
    }
}
