package com.lyr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.lyr.dao.db2.PeopleDao;
import com.lyr.dao.db3.CustomerDao;
import com.lyr.entity.Customer;
import com.lyr.entity.People;
import com.lyr.service.CustomerService;
import com.lyr.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, Customer> implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getPersonByEmail() {
        List<Customer> customerList = customerDao.selectByEmail();
        if(CollectionUtils.isEmpty(customerList)){
            return Lists.newArrayList();
        }
        return customerList;
    }

    @Override
    public Optional<Customer> findCustomerById(String id) {
        Customer customer = customerDao.findCustomerById(id);
        return Optional.ofNullable(customer);
    }
}
