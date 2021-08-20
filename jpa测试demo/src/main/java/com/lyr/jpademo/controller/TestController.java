package com.lyr.jpademo.controller;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
public class TestController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/get")
    public List get() {
        String sql = "select * from student where name =  ?";
        Query query = entityManager.createNativeQuery(sql); // 执行sql原生语句
        query.setParameter(1,"1"); // sql语句的第1个参数
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); // 设置查询结果返回map对象
        return query.getResultList(); // 返回的是一个List<Object[]>。也就是说每行的数据被作为一个对象数组返回
    }


}
