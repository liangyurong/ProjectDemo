package com.lyr.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyr.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentMapper extends BaseMapper<Student> {
}
