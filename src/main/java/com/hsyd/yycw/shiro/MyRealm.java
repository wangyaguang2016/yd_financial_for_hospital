package com.hsyd.yycw.shiro;

import com.hsyd.yycw.model.Permission;
import com.hsyd.yycw.model.Role;
import com.hsyd.yycw.model.User;
import com.hsyd.yycw.service.PermissionService;
import com.hsyd.yycw.service.RoleService;
import com.hsyd.yycw.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xisowang on 14/08/2017.
 */
public class MyRealm extends AuthorizingRealm {
    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Autowired
    public MyRealm(UserService userService, RoleService roleService, PermissionService permissionService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获得认证实体
        User loginUser = (User) principals.getPrimaryPrincipal();
        // 保存用户角色权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 用来保存角色权限集合
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissionNames = new HashSet<String>();
        // 从数据库中获得用户角色和权限
        Role role = new Role();
        role.setUserId(loginUser.getUserId());
        Permission permission = new Permission();
        for (Role roles : roleService.selectRole(role)) {
            roleNames.add(roles.getRoleName());
            permission.setRoleId(roles.getId());
            for (Permission permissions : permissionService.selectPermission(permission)) {
                permissionNames.add(permissions.getPermissionName());
            }
        }
        // 保存角色和权限
        info.addRoles(roleNames);
        info.addStringPermissions(permissionNames);
        return info;
    }

    /**
     * 认证回调函数, 登录时调用
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenToken;
        String username = token.getUsername();
        char[] password = token.getPassword();

        List<User> loginUser = userService.login(username, new String(password));
        // 验证非空
        if (username == null || password == null || username.equals("") || password.length <= 0) {
            throw new AccountException("Null usernames are not allowed by this realm.");
            // 用户不存在
        } else if (loginUser == null) {
            throw new UnknownAccountException("Account not found.");
            // 用户被禁用
        } else if (loginUser.get(1).getDelStatus() != 0) {
            throw new DisabledAccountException("Account has been disabled");
        }
        // principal：认证的实体信息，可以是name，也可以是数据表对应的用户的实体类对象
        Object principal = loginUser.get(1);
        // credentials：数据库密码
        Object credentials = loginUser.get(1).getPassword();
        // credentialsSalt：盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        // realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();
        SimpleAuthenticationInfo info = null;
        try {
            info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        } catch (Exception e) {
            throw new AuthenticationException();
        }
        return info;
    }

    public static void main(String args[]) {
        System.out.println(new SimpleHash("MD5", "123", "123", 1024));
    }


}

