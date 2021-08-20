package com.lyr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyr.entity.Customer;
import com.lyr.entity.People;

import java.util.List;
import java.util.Optional;

public interface CustomerService extends IService<Customer> {

    List<Customer> getPersonByEmail();

    Optional<Customer> findCustomerById(String id);

}
