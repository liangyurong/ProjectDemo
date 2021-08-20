package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *  月经史（已经建表）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_MENSTRUAL_HISTORY")
public class MenstrualHistory {

    /** 患者编号 */
    @Column(name="PATIENT_ID")
    private String patientId;

    /** 访问id */
    @Column(name="VISIT_ID")
    private String visitId;

    /** 特殊说明 */
    @Column(name="NOTE")
    private String note;

    /** 是否绝经（是Or否 */
    @Column(name="MENOPAUSE_YES_OR_NOT")
    private String menopauseYesOrNot;

    /** 绝经年龄 */
    @Column(name="MENOPAUSE_AGE")
    private String menopauseAge;

    /** 初潮年龄 */
    @Column(name="MENARCHE_AGE")
    private String menarcheAge;

    /** 月经周期 */
    @Column(name="MENSTRUAL_CYCLE")
    private String menstrualCycle;

    /** 月经经期 */
    @Column(name="MENSTRUAL_PERIOD")
    private String MenstrualPeriod;

    /** 经量（少，中，多） */
    @Column(name="MENSTRUATION")
    private String menstruation;

}
