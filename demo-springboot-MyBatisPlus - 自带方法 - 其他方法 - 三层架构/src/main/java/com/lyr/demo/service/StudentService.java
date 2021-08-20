package com.lyr.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyr.demo.entity.Student;
import com.lyr.demo.util.Result;

public interface StudentService extends IService<Student> {

    Result saveStudent(Student student);

    Result updateStudentById(Student student);

    Result selectStudentById(String id);

}
