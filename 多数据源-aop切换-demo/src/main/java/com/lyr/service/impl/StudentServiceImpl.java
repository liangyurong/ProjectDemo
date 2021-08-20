package com.lyr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.lyr.dao.db1.StudentDao;
import com.lyr.entity.Student;
import com.lyr.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService  {

    @Autowired
    private StudentDao studentDao;

    /**
     * 对于接口 List<Student> getStudentByEmail(),它一定会返回List（即使查询不到任何数据）
     * 通过以下代码，我们能够成功避免有可能发生的空指针异常。写法也更加安全。
     */
    @Override
    public List<Student> getStudentByEmail() {
        List<Student> studentList=studentDao.selectByEmail();
        if(CollectionUtils.isEmpty(studentList)){
            return Lists.newArrayList();
        }
        return studentList;
    }

    @Override
    public Optional<Student> findStudentById(String id) {
        Student student = studentDao.findStudentById(id);
        return Optional.ofNullable(student);
    }
}
