package com.hsyd.yycw.dao;

import com.hsyd.yycw.model.Permission;

import java.util.List;

/**
 * Created by xisowang on 17/08/2017.
 */
public interface PermissionDao {
    List<Permission> selectPermission(Permission permission);
}
