package com.sdyb.gdydwechatpush;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdyb.gdydwechatpush.entity.Student;
import com.sdyb.gdydwechatpush.mapper.StudentMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 分页测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPagination {

    @Autowired
    private StudentMapper studentMapper;

    //分页
    @org.junit.Test
    @ResponseBody
    public void testA(){
        Page<Student> page = new Page<>(2, 4); //第二页，每页显示4条记录。如果n<=4,显示n条。如果n>4，显示4条。

        Page<Student> page1 = studentMapper.selectPage(page, null);
        System.out.println(page1.getTotal()); //总的记录数量
        System.out.println(page1.getSize()); //当前页的记录数量

        List<Student> records = page1.getRecords();
        records.forEach(System.out::println); //分别打印出当前页的记录
    }

}
