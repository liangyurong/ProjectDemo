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

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDelete {

    @Autowired
    private StudentMapper studentMapper;

    //单个删除
    @org.junit.Test
    @ResponseBody
    public void testA(){
        System.out.println(studentMapper.deleteById(6));
    }

    //批量删除。根据id批量删除
    @org.junit.Test
    @ResponseBody
    public void testB(){
        int i = studentMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(i);
    }

    //条件删除。根据map，可以自定义多个条件。
    @org.junit.Test
    @ResponseBody
    public void testC(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","1");
        int i = studentMapper.deleteByMap(map);
        System.out.println(i);
    }


}
