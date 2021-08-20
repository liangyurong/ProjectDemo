package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 随访（已经建表）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_FOLLOW_UP")
public class FollowUp {

    /** 患者编号 */
    @Column(name="PATIENT_ID")
    private String patientId;

    /** 访问id */
    @Column(name="VISIT_ID")
    private String visitId;

    /** 随访方式 ：门诊 微信 电话 */
    @Column(name="F_TYPE")
    private String fType;

    /** 随访时间 */
    @Column(name="F_DATE")
    private Date fDate;

    /** 随访内容：评估方式 */
    @Column(name="EVAL_METHOD")
    private String evalMethod;

    /** 随访内容：肿瘤标记物 */
    @Column(name="TUMOR_MARKERS")
    private String tumorMarkers;

    /** 随访内容：影像学*/
    @Column(name="VIDEOGRAPHY")
    private String videography;

    /** 随访内容：妇科检查*/
    @Column(name="GYN_EXAM")
    private String gynExam;

}
