package com.hsyd.yycw.service;

import com.hsyd.yycw.model.Permission;

import java.util.List;

/**
 * Created by xisowang on 14/08/2017.
 */
public interface PermissionService {
    List<Permission> selectPermission(Permission permission);
}
