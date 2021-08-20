package com.lyr.demo.测试语法糖的用法;

import com.lyr.demo.entity.Student;
import com.lyr.demo.mapper.StudentMapper;
import com.lyr.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 语法糖使用
 */
@Controller
public class Sugar {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 返回所有的数据
     */
    @GetMapping("/getAllStudent")
    @ResponseBody
    public Result getS(){
        Result result = new Result();
        List<Student> students = studentMapper.selectList(null);
        return result.putData(students);
    }

}
