package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 系统评估（还没写完）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_SYSTEM_EVALUATION")
public class SystemEvaluation {

    /** 病人id */
    @Column(name="PATIENT_ID")
    private String patientId;

    /** 特殊说明 */
    @Column(name="NOTE")
    private String note;

    /** 入院时间 */
    @Column(name="HOSPITALIZATION_DATE")
    private Date hospitalizationDate;

    /** 入院性质（初治or复发） */
    @Column(name="HOSPITALIZATION_NATURE")
    private String hospitalizationNature;

    /** 入院诊断（术前,术后,第N程化疗后,第N程新辅助化疗后…是否合并肠根阻,静脉血栓骨髓抑制）*/
    @Column(name="DIAGNOSIS")
    private String diagnosis;

    /** 入院目的（手术，化疗，放疗，其他） */
    @Column(name="PURPOSE")
    private String purpose;

    /** 体力评估情况（体力状况评估体力状况评分Performance status ECOG-PS） */
    @Column(name="PHYSICAL_EVALUATION")
    private String physicalEvaluation;

    /** 营养状况评估（营养风险筛查量表NRS-2002） */
    @Column(name="NUTRITIONAL_EVALUATION")
    private String nutritionalEvaluation;

    /** 心理状态评估（医院焦虑抑郁量表(HADS) 研究围手术期心理干预对手术患者的影响） */
    @Column(name="PSYCHOLOGICAL_EVALUATION")
    private String psychologicalEvaluation;

    /** 生活质量评估（基本生活活动能力BADL评定量表:生活质量测评表（QOL） 在治疗前，治疗结束后 3 个月根据患者食欲、睡眠、精神状态、日常生活等 12 项内容对患者进行生活质量的评定。测评表由差到好采用 5 级分级评分法，满分为 60 分) */
    @Column(name="LIFE_QUALITY_EVALUATION")
    private String  lifeQualityEvaluation;

    /** 手术患者Caprini风险评估 */
    @Column(name="RISK_EVALUATION")
    private String riskEvaluation;

}
