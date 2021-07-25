package com.test.service;

import com.test.dao.UserDAO;
import com.test.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kalana on 25/07/2021
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public Users getUser(String userName) {
        return userDAO.getUser(userName);
    }
}
