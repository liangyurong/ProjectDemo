package com.lyr.controller;

import com.lyr.entity.Customer;
import com.lyr.entity.People;
import com.lyr.entity.Student;
import com.lyr.service.CustomerService;
import com.lyr.service.PeopleService;
import com.lyr.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private CustomerService customerService;

    /**
     * MYSQL
     */
    @GetMapping("/getp")
    @ResponseBody
    public Optional<People> getp(){
        Optional<People> personById = peopleService.findPersonById("1");
        return personById;
    }

    /**
     * sql server
     */
    @GetMapping("/gets")
    @ResponseBody
    public Optional<Student> gets(){
        Optional<Student> studentById = studentService.findStudentById("1");
        return studentById;
    }

    /**
     * MYSQL
     */
    @GetMapping("/getc")
    @ResponseBody
    public Optional<Customer> getc(){
        Optional<Customer> customer = customerService.findCustomerById("1");
        return customer;
    }

}
