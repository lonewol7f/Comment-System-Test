package com.test.dao;

import com.test.entity.Users;

/**
 * Created by Kalana on 25/07/2021
 */

public interface UserDAO {
    Users getUser(String userName);
}
