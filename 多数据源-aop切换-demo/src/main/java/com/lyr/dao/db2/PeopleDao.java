package com.lyr.dao.db2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyr.entity.People;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Mapper
public interface PeopleDao extends BaseMapper<People> {

    List<People> selectByEmail();

    People findPersonById(String id);

}

