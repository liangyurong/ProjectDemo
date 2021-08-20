package com.lyr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyr.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService extends IService<Student> {

    List<Student> getStudentByEmail();

    Optional<Student> findStudentById(String id);

}
