package com.lyr.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyr.demo.entity.Student;
import com.lyr.demo.mapper.StudentMapper;
import com.lyr.demo.service.StudentService;
import com.lyr.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * updateWrapper用于给update方法传条件参数
 *
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService  {

    @Autowired
    private StudentMapper mp;

    @Override
    public Result selectStudentById(String id) {
        Result result = new Result();

        if(null==id || "".equals(id)){
            return result.putCode(1).putMsg("查询失败，id为空").putData(null);
        }

        Student student = mp.selectById(id); //仅仅存储有一条数据

        if(null==student || "".equals(student)){
            return result.putCode(1).putMsg("查询失败，根据id查询不到您的记录").putData(null);
        }else {
            return result.putCode(0).putMsg("查询成功").putData(student);
        }
    }

    @Override
    public Result saveStudent(Student student) {
        Result result = new Result();

        //保存的时候，前端只需要传入name和myEmail
        if(null==student || "".equals(student)){
            return result.putCode(1).putMsg("保存失败，传递的实体类为空").putData(null);
        }

        // name唯一。拦截反复保存
        String name=student.getName();
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        Student entity = mp.selectOne(wrapper);
        if(null!=entity){
            return result.putCode(1).putMsg("保存失败，已存在相同的姓名，请更改您的姓名").putData(null);
        }

        // myEmail唯一。拦截反复保存myEmail
        QueryWrapper<Student> wrapper1 = new QueryWrapper<>();
        String myEmail = student.getMyEmail();
        wrapper1.eq("my_email",myEmail); // 放入的colum的变量要对应数据库的字段，也就是下划线命名
        Student entity1 = mp.selectOne(wrapper1);
        if(null!=entity1){
            return result.putCode(1).putMsg("保存失败，已存在相同的邮箱，请更改您的邮箱").putData(null);
        }

        int insert = mp.insert(student); //保存成功返回1
        if(1!=insert){
            return result.putCode(1).putMsg("保存失败，保存过程发生错误，请重试").putData(null);
        }else {
            entity = mp.selectOne(wrapper);
            return result.putCode(0).putMsg("保存成功").putData(entity);
        }


    }

    @Override
    public Result updateStudentById(Student student) {
        Result result = new Result();

        if(null==student || "".equals(student)
                || null==student.getId() || "".equals(student.getId())
                || null==student.getName() || "".equals(student.getName())
                || null==student.getMyEmail() || "".equals(student.getMyEmail())){
            return result.putCode(1).putMsg("更新失败，传递的实体类为空 或id为空 或name为空 或myEmail为空").putData(null);
        }

        int i = mp.updateById(student); //更新成功返回1

        if(1!=i){
            return result.putCode(1).putMsg("更新失败，保存过程发生错误，请重试").putData(null);
        }else {
            Student entity = mp.selectById(student.getId());
            return result.putCode(0).putMsg("更新成功").putData(entity);
        }

    }


}
