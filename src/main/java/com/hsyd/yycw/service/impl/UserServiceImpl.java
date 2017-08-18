package com.hsyd.yycw.service.impl;

import com.hsyd.yycw.dao.UserDao;
import com.hsyd.yycw.model.User;
import com.hsyd.yycw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xisowang on 15/08/2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> login(String username, String password) {
        return userDao.login(username, password);
    }
}
