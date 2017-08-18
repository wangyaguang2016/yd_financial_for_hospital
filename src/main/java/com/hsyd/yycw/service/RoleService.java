package com.hsyd.yycw.service;

import com.hsyd.yycw.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xisowang on 14/08/2017.
 */
public interface RoleService {
    List<Role> selectRole(Role role);
}
