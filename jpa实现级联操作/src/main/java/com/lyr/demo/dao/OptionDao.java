package com.lyr.demo.dao;

import com.lyr.demo.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionDao extends JpaRepository<Option,String> {
}
