package com.lyr.shirodemo.dao;

import com.lyr.shirodemo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
public interface PermissionDao extends JpaRepository<Permission,Long> {

    /**
     * 根据角色id集合查询权限信息的集合
     */
    @Query(value =  "select permission_name " +
                    "from permission,role_permission rp " +
                    "where rp.role_id  in (?1) "+
                    "and permission.id = rp.permission_id",
           nativeQuery = true)
    LinkedHashSet<String> findPermissionsByRoleId(List<Long> roleIds);
}
