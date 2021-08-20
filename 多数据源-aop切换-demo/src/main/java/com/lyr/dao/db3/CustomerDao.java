package com.lyr.dao.db3;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyr.entity.Customer;
import com.lyr.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CustomerDao extends BaseMapper<Customer> {

    List<Customer> selectByEmail();

    Customer findCustomerById(String id);

}

