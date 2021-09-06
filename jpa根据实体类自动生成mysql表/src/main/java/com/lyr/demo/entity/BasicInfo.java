package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

/** 基本信息 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BASIC_INFO")
@org.hibernate.annotations.Table(appliesTo = "basic_info") // 里面的basic_info必须对应@Table的BASIC_INFO
public class BasicInfo {

    /** 主键里面不能写default null */
    @Id
    @Column(name = "PATIENT_ID",columnDefinition = "varchar(255)  COMMENT '患者编号'")
    private String patientId;

    @Column(name = "NAME",columnDefinition = "varchar(255) default NULL COMMENT '姓名'")
    private String name;

    @Column(name = "AGE",columnDefinition = "int(11) default 0 COMMENT '年龄'")
    private Integer age;

    @Column(name = "IN_HOSP_DATE",columnDefinition = "DATE DEFAULT NULL COMMENT '住院日期'")
    private Date inHospDate;

    @Column(name = "HEIGHT",columnDefinition = "DOUBLE default NULL COMMENT '身高(cm)'")
    private Double height;

}

