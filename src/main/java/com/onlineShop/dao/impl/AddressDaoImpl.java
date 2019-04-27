package com.onlineShop.dao.impl;

import com.onlineShop.dao.AddressDao;
import com.onlineShop.model.Address;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mingwei on 10/12/2018
 */
@Repository
@DynamicUpdate
@Transactional
public class AddressDaoImpl implements AddressDao {
    @Autowired
    SessionFactory sessionFactory;

    /**
     * Edit Address
     * @author Mingwei
     * @date 10/24/2018
     * @param address
     */
    public void editAddress(Address address){
        Session session = sessionFactory.getCurrentSession();
        session.update(address);
        session.flush();
    }

    /**
     * Get Address By AddressId
     * @author Mingwei
     * @date 10/12/2018
     * @param addressId
     * @return
     */
    public Address getAddressByAddressId(int addressId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Address where address_Id = ?");
        query.setInteger(0, addressId);
        return (Address) query.uniqueResult();
    }

}
