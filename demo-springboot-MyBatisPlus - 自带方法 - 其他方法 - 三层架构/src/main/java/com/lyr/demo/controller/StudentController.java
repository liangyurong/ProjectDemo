package com.lyr.demo.controller;

import com.lyr.demo.entity.Student;
import com.lyr.demo.mapper.StudentMapper;
import com.lyr.demo.service.StudentService;
import com.lyr.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentMapper mp;
    @GetMapping("/save")
    @ResponseBody
    public int save(){
        Student s = new Student();
        s.setName("as");
        s.setMyEmail("as@qq.com");
        int insert = mp.insert(s);
        return insert;
    }


    @Autowired
    private StudentService studentService;

    @GetMapping("/getStu/{id}")
    @ResponseBody
    public Result getStuById(@PathVariable("id") String id){
       Result result = studentService.selectStudentById(id);
       return result;
    }

    @PostMapping("/saveStu")
    @ResponseBody
    public Result saveStu(@RequestBody Student student){
        Result result = studentService.saveStudent(student);
        return result;
    }

    @PostMapping("/updateStu")
    @ResponseBody
    public Result updateStu(@RequestBody Student student){
        Result result = studentService.updateStudentById(student);
        return result;
    }

}
