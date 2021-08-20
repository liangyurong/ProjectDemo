package com.lyr.demo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author yurong333
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String myEmail;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", myEmail='" + myEmail + '\'' +
                '}';
    }
}
