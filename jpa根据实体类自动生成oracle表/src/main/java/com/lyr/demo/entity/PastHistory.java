package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 既往史（已经建表）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_PAST_HISTORY")
public class PastHistory {

    @Column(name="PATIENT_ID")
    private String patientId;

    /** 访问id */
    @Column(name="VISIT_ID")
    private String visitId;

    /** 合并症（高血压/糖尿病/其他肿瘤） */
    @Column(name="COMPLICATIONS")
    private String complications;

    /** 服药情况 */
    @Column(name="MEDICATION")
    private String medication;

    /** 手术史 */
    @Column(name="HISTORY_OF_SURGERY")
    private String historyOfSurgery;

    /** 药物过敏史 */
    @Column(name="HISTORY_OF_DRUG_ALLERGY")
    private String historyOfDrugAllergy;

    /** 严重不良反应（IV度骨髓抑制/放射性肠炎） */
    @Column(name="SERIOUS_ADVERSE_REACTIONS")
    private String seriousAdverseReactions;

    /** 其他特殊情况 */
    @Column(name="OTHER_SPECIAL_SITUATION")
    private String  otherSpecialSituation;

}
