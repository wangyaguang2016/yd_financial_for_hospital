package com.hsyd.yycw.service;

import com.hsyd.yycw.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xisowang on 14/08/2017.
 */
public interface UserService {
    /**
     * 登录查询
     * @param username
     * @param password
     * @return
     */
    List<User> login(String username, String password);
}
