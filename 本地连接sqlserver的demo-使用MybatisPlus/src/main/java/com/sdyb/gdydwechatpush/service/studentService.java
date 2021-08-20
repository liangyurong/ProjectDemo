package com.sdyb.gdydwechatpush.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdyb.gdydwechatpush.entity.Student;

import java.util.List;

public interface studentService extends IService<Student> {
    List<Student> findAllByName(String name);

    Student findById(int id);

}
