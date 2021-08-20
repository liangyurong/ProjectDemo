package com.lyr.dao;

import com.lyr.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Component
public interface StudentDao {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void update(Student student);
    void deleteById(Integer id);
}
