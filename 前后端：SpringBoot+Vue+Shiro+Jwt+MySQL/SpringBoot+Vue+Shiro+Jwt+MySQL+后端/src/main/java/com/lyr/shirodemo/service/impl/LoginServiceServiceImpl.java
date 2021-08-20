package com.lyr.shirodemo.service.impl;

import com.lyr.shirodemo.dao.PermissionDao;
import com.lyr.shirodemo.dao.RoleDao;
import com.lyr.shirodemo.dao.UserDao;
import com.lyr.shirodemo.entity.Role;
import com.lyr.shirodemo.entity.User;
import com.lyr.shirodemo.service.LoginUserInfoService;
import com.lyr.shirodemo.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LoginServiceServiceImpl implements LoginUserInfoService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public User getLoginUserInfoByUsernameAndPassword(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5.encrypt(password,"salt",1024));
        return getUserInfo(user);
    }

    @Override
    public User getLoginUserInfoById(Long id) {
        User user = userDao.findUserById(id);
        return getUserInfo(user);
    }

    /**
     * 获取user的角色和权限
     */
    private User getUserInfo(User user){
        if(null!=user){
            List<Role> roleList = roleDao.findRolesByUserId(user.getId());
            Set<String> roleSet = new HashSet<>();
            List<Long> roleIds = new ArrayList<>();

            // 获取角色信息集合和角色id集合
            for (Role role : roleList){
                roleSet.add(role.getRoleName());
                roleIds.add(role.getId());
            }
            // 放入角色信息
            user.setRoles(roleSet);

            // 放入权限信息
            LinkedHashSet<String> permissionsNameSet = permissionDao.findPermissionsByRoleId(roleIds);
            user.setPermissions(permissionsNameSet);
            return user;
        }else {
            return null;
        }
    }

}
