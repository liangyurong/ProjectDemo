package com.sdyb.gdydwechatpush.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdyb.gdydwechatpush.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
   List<Student> selectAllByName(String name); //根据身份证号进行查询
}
