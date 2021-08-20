package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 家族史(还没写完)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_FAMILY_HISTORY")
public class FamilyHistory {

    /** 病人id */
    @Column(name="PATIENT_ID")
    private String patientId;

    /** 是否有家族史: 无/有 */
    @Column(name="HAS_FAMILY_HISTORY")
    private String hasFamilyHistory;

    /** 疾病名称 */
    @Column(name="DISEASE_NAME")
    private String diseaseName;

    /** 与患者关系（一级、二级亲属） */
    @Column(name="RELATIONSHIP")
    private String relationship;

}
