package com.sdyb.gdydwechatpush.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdyb.gdydwechatpush.entity.Student;
import com.sdyb.gdydwechatpush.mapper.StudentMapper;
import com.sdyb.gdydwechatpush.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements studentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllByName(String name) {
        return studentMapper.selectAllByName(name);
    }

    @Override
    public Student findById(int id) {
        return studentMapper.selectById(id); //MP自带的查询，使我们能够避免写sql语句
    }
}
