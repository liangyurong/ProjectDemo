package com.lyr.demo.controller;


import com.lyr.demo.entity.Student;
import com.lyr.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yurong333
 * @since 2021-04-13
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/hi")
    public String hi(){
        Student student = studentMapper.selectById("1");
        return student.toString();
    }

}

