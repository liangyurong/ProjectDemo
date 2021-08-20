package com.lyr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyr.entity.People;

import java.util.List;
import java.util.Optional;

public interface PeopleService extends IService<People> {

    List<People> getPersonByEmail();

    Optional<People> findPersonById(String id);

}
