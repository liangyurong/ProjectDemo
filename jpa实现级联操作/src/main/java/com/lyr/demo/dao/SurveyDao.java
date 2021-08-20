package com.lyr.demo.dao;

import com.lyr.demo.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyDao extends JpaRepository<Survey,String> {
}
