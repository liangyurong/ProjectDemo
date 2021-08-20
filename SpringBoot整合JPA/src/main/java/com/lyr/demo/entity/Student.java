package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student") //需要写上对应的数据库表名称
public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) //类型是Integer才这么设置自增。如果是String类型就不用这个注解
//    @Column(name="id")
//    private Integer id;

    @Id
    @Column(name="id")
    private String id; //类型是String

    @Column(name="name")
    private String name;

    @Column(name="my_email")
    private String myEmail;

}
