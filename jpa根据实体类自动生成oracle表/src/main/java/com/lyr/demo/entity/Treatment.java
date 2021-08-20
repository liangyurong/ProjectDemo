package com.lyr.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 *  还没写完
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_TREATMENT")
public class Treatment {

    /** 病人id */
    @Column(name="PATIENT_ID")
    private String patientId;

    /** 访问id */
    @Column(name="VISIT_ID")
    private String visitId;

    /** 治疗前诊断 */
    @Column(name="")
    private String diagBeforeTreatment;

    /** 术者 */
    @Column(name="")
    private String surgeryDoctor;

    /** 化疗医生 */
    @Column(name="")
    private String chemotherapyDoctor;

    /** 放疗医生 */
    @Column(name="")
    private String radiotherapist;

    /** 治疗方式（手术、放疗、化疗、介入……） */
    @Column(name="")
    private String treatmentType;

    /** 手术时间 */
    @Column(name="")
    private Date operationTime;

    /** 手术时长 */
    @Column(name="")
    private String operationLength;

    /**  */
    @Column(name="")
    private String ;

    /**  */
    @Column(name="")
    private String ;

    /**  */
    @Column(name="")
    private String ;

    /**  */
    @Column(name="")
    private String ;

}
