package com.lyr.shirodemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 55)
    private Long id;

    @Column(name="permission_name")
    private String permissionName;

    @Column(name="permission_desc")
    private String permissionDesc;


}
