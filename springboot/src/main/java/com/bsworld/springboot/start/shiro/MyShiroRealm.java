package com.bsworld.springboot.start.shiro;
/*
*author: xieziyang
*date: 2018/7/30
*time: 17:59
*description:
*/

import com.bsworld.springboot.start.dao.entity.TPermission;
import com.bsworld.springboot.start.dao.entity.TRole;
import com.bsworld.springboot.start.dao.entity.TUser;
import com.bsworld.springboot.start.dao.entity.TUserRole;
import com.bsworld.springboot.start.service.TPermissionService;
import com.bsworld.springboot.start.service.TRoleService;
import com.bsworld.springboot.start.service.TUserRoleService;
import com.bsworld.springboot.start.service.TUserService;
import com.mysql.cj.util.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    TUserService tUserService;
    @Autowired
    TUserRoleService tUserRoleService;
    @Autowired
    TRoleService tRoleService;
    @Autowired
    TPermissionService tPermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String loginName = (String) super.getAvailablePrincipal(principalCollection);
        TUser tUser = tUserService.queryTUserBuLoginName(loginName);
        if (tUser != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<TUserRole> tUserRoles = tUserRoleService.queryRoleByUserId(tUser.getId());
            List<Integer> roleIdList = tUserRoles.stream().filter(m -> m.getRoleId() != null).map(m -> m.getRoleId()).collect(Collectors.toList());
            List<TRole> tRoles = tRoleService.queryTRoleByRoleIdList(roleIdList);
            Set<String> roleNames = tRoles.stream().filter(m -> !StringUtils.isNullOrEmpty(m.getRolename())).map(m -> m.getRolename()).collect(Collectors.toSet());
            List<Integer> roleIds = tRoles.stream().filter(m -> m.getId() != null).map(m -> m.getId()).collect(Collectors.toList());
            info.setRoles(roleNames);
            List<TPermission> tPermissions = tPermissionService.queryTPermissionByRoleIds(roleIds);
            List<String> permissionNames = tPermissions.stream().map(m -> m.getPermissionname()).collect(Collectors.toList());
            info.setStringPermissions(permissionNames.stream().collect(Collectors.toSet()));
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        TUser tUser = tUserService.queryTUserBuLoginName(token.getUsername());
        if (tUser != null) {
            return new SimpleAuthenticationInfo(tUser.getUsername(), tUser.getPassword(), getName());
        }
        return null;
    }
}
