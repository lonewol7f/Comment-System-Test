package com.test.dao;

import com.test.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Kalana on 25/07/2021
 */

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Users getUser(String userName) {

        Session session = sessionFactory.getCurrentSession();

        Query<Users> usersQuery = session.createQuery("from Users where username =: userName", Users.class);
        usersQuery.setParameter("userName", userName);
        Users user = usersQuery.getSingleResult();

        return user;

    }
}
