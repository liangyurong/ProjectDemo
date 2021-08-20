package com.lyr.demo.controller;


import com.lyr.demo.dao.StudentDao;
import com.lyr.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/findAll")
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return studentDao.findById(id).get();
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentDao.save(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        studentDao.save(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        studentDao.deleteById(id);
    }

}
