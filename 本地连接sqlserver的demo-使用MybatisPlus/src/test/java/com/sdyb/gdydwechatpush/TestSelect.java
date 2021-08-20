package com.sdyb.gdydwechatpush;

import com.sdyb.gdydwechatpush.entity.Student;
import com.sdyb.gdydwechatpush.mapper.StudentMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单元测试的返回值必须是void
 *
 * 作用：测试查询
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSelect {

    @Autowired
    private StudentMapper studentMapper;

    //单个查询
    @org.junit.Test
    @ResponseBody
    public void testA(){
        System.out.println(studentMapper.selectById(1));
    }

    //批量查询。根据id批量查询
    @org.junit.Test
    @ResponseBody
    public void testB(){
        List<Student> studentList = studentMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        studentList.forEach(System.out::println);
    }

    //条件查询。根据map，可以自定义多个条件。
    @org.junit.Test
    @ResponseBody
    public void testC(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","1");
        map.put("my_email","1"); //这里的字段需要对应的是数据库的字段，然后MP自动帮我们拼接sql语句
        List<Student> studentList = studentMapper.selectByMap(map);
        studentList.forEach(System.out::println);
    }








}
