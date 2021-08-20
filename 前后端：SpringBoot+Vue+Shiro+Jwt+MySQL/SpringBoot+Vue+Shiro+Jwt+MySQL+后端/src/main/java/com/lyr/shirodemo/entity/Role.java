package com.lyr.shirodemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 55)
    private Long id;

    @Column(name="role_name")
    private String roleName;

    @Column(name="role_desc")
    private String roleDesc;

}
