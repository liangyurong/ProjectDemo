package com.lyr.shirodemo.dao;

import com.lyr.shirodemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {

    /**
     * 根据用户id查询角色信息
     */
    @Query(value =  "select role.id ,role.role_name,role.role_desc " +
                    "from user,role,user_role ur " +
                    "where user.id = ?1 and user.id=ur.user_id and role.id=ur.role_id",
            nativeQuery = true)
    List<Role> findRolesByUserId(Long userId);


}
