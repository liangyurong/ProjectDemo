package com.lyr.shirodemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 在页面输入的用户名和密码(数据库存储的密码是经过加密的信息)
 *  1 1
 *  2 2
 *  3 3
 *  4 4
 */

/**
 * 用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 55)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    /** 描述用户级别，admin用户，vip用户，普通用户 */
    @Column(name="user_desc")
    private String userDesc;

    @Transient
    private Set<String> roles = new HashSet<>();

    @Transient
    private Set<String> permissions = new HashSet<>();

}
