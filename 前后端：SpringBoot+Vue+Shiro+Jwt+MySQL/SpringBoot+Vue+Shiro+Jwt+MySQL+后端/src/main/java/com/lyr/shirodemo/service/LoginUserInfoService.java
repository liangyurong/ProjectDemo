package com.lyr.shirodemo.service;

import com.lyr.shirodemo.entity.User;

public interface LoginUserInfoService {

   /** 根据账户密码获取用户的角色和权限信息 */
   User getLoginUserInfoByUsernameAndPassword(String username, String password);

   /** 根据用户id获取用户的角色和权限信息 */
   User getLoginUserInfoById(Long id);
}
