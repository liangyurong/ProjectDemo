package com.lyr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.lyr.dao.db2.PeopleDao;
import com.lyr.entity.People;
import com.lyr.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleDao, People> implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    @Override
    public List<People> getPersonByEmail() {
        List<People> peopleList = peopleDao.selectByEmail();
        if(CollectionUtils.isEmpty(peopleList)){
            return Lists.newArrayList();
        }
        return peopleList;
    }

    @Override
    public Optional<People> findPersonById(String id) {
        People people = peopleDao.findPersonById(id);
        return Optional.ofNullable(people);
    }
}
