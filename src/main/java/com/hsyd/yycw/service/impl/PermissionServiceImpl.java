package com.hsyd.yycw.service.impl;

import com.hsyd.yycw.dao.PermissionDao;
import com.hsyd.yycw.model.Permission;
import com.hsyd.yycw.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xisowang on 15/08/2017.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> selectPermission(Permission permission) {
        return permissionDao.selectPermission(permission);
    }
}
