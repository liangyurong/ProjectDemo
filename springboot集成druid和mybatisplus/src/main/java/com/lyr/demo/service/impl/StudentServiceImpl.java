package com.lyr.demo.service.impl;

import com.lyr.demo.entity.Student;
import com.lyr.demo.mapper.StudentMapper;
import com.lyr.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yurong333
 * @since 2021-04-13
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
