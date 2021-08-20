package com.sdyb.gdydwechatpush.controller;

import com.sdyb.gdydwechatpush.entity.Student;
import com.sdyb.gdydwechatpush.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private studentService studentService;

    @ResponseBody
    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.findAllByName("1");
    }

    @ResponseBody
    @GetMapping("/getB")
    public List<Student> getAllB(){
        return studentService.findAllByName("2");
    }

    @ResponseBody
    @GetMapping("/getC")
    public Student getC(){
        return studentService.findById(1);
    }


}
