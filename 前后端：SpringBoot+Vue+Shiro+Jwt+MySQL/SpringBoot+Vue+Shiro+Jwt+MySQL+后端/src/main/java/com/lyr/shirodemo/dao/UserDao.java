package com.lyr.shirodemo.dao;

import com.lyr.shirodemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    /**
     * 通过用户名和密码查询用户信息
     */
    @Query(value = "select * from user where username = ?1 and password = ?2",nativeQuery = true)
    User findByUsernameAndPassword(String username,String password);

    @Query(value = "select * from user where id = ?1 ",nativeQuery = true)
    User findUserById(Long id);

}
