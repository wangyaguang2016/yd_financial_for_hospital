package com.hsyd.yycw.dao;

import com.hsyd.yycw.base.BaseMapper;
import com.hsyd.yycw.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xisowang on 16/08/2017.
 */
public interface UserDao extends BaseMapper<User, String> {
    /**
     * 登录查询
     * @param username
     * @param password
     * @return
     */
    List<User> login(String username, String password);
}
