package com.hsyd.yycw.service.impl;

import com.hsyd.yycw.dao.RoleDao;
import com.hsyd.yycw.model.Role;
import com.hsyd.yycw.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xisowang on 15/08/2017.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> selectRole(Role role) {
        return roleDao.selectRole();
    }
}
