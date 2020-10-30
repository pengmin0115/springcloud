package com.apple.service.impl;

import com.apple.dao.UserDao;
import com.apple.pojo.User;
import com.apple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pengmin
 * @date 2020/10/29 17:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(Integer id) {
        return userDao.findById(id).get();
    }
}
