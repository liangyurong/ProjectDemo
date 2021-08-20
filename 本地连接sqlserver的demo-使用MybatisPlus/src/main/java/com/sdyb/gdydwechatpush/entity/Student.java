package com.sdyb.gdydwechatpush.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 复检视图。同一个孕妇，可能有多条复检记录。字段注释看README.md
 * @author  lyr
 * @date  2021-05-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String myEmail;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", myEmail='" + myEmail + '\'' +
                '}';
    }
}
