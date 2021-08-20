package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 婚育史(已经建表)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_HISTORY_MARRIAGE_CHILDBIRTH")
public class HistoryMarriageChildbirth {

    /** 患者编号 */
    @Column(name="PATIENT_ID")
    private String patientId;

    /** 访问id */
    @Column(name="VISIT_ID")
    private String visitId;

    /** 孕次（数值） */
    @Column(name="PREGNANCY_NUM")
    private String pregnancyNum;

    /** 产次（数值） */
    @Column(name="CHILDBIRTH_NUM")
    private String childbirthNum;

    /** 人流次（数值）*/
    @Column(name="ABORTION_NUM")
    private String abortionNum;

    /** 顺产次（数值）*/
    @Column(name="NORMALDELIVERY_NUM")
    private String normalDeliveryNum;

    /** 剖宫产次（数值） */
    @Column(name="CAESAREANSECTION_NUM")
    private String caesareanSectionNum;

    /** 生育要求（有Or无）*/
    @Column(name="THE_REQUEST")
    private String theRequest;


}
