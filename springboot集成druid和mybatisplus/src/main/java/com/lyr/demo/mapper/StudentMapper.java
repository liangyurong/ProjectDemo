package com.lyr.demo.mapper;

import com.lyr.demo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yurong333
 * @since 2021-04-13
 */
@Mapper
@Component
public interface StudentMapper extends BaseMapper<Student> {

}
