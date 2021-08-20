package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 医疗检查
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_MEDICAL_TEST")
public class MedicalTest {

    /** 病人id */
    @Column(name="PATIENT_ID")
    private String patientId;

    /** 血常规检验时间 */
    @Column(name="")
    private Date routineBloodTestTime;

    /** 血常规-白细胞 ()*10^9/L*/
    @Column(name="")
    private String leukocyte;

    /** 血常规-中性粒 ()*10^9/L*/
    @Column(name="")
    private String neutrophils;

    /** 血常规-淋巴细胞 ()*10^9/L */
    @Column(name="")
    private String lymphocytes;

    /** 血常规-血小板 ()*10^9/L*/
    @Column(name="")
    private String platelet;

    /** 血常规-红细胞分布宽度 */
    @Column(name="")
    private String redBloodCellWidth;

    /** 血常规-血红蛋白g/L */
    @Column(name="")
    private String hemoglobin;

    /** 血常规-NLR（公式生成） */
    @Column(name="NLR")
    private String nlr;

    /** 血常规-PLR（公式生成） */
    @Column(name="PLR")
    private String plr;

    /** 凝血-检验时间 */
    @Column(name="")
    private Date bloodClottingTestTime;

    /** 凝血-纤维蛋白原 */
    @Column(name="")
    private String fibrinogen;

    /** 凝血-D二聚体 */
    @Column(name="")
    private String dimer;

    /** 肝功能-检验时间 */
    @Column(name="")
    private Date liverTestTime;

    /** 肝功能-白蛋白 */
    @Column(name="")
    private String albumin;

    /** 肝功能-ALT*/
    @Column(name="ALT")
    private String alt;

    /** 肝功能-AST*/
    @Column(name="AST")
    private String ast;

    /** 肾功能-检验时间 */
    @Column(name="")
    private Date kidneyTestTime;

    /** 肾功能-尿素氮 */
    @Column(name="")
    private String ureaNitrogen;

    /** 肾功能-肌酐 */
    @Column(name="")
    private String creatinine;

    /** 肾功能-肌酐清除率 */
    @Column(name="")
    private String creatinineClearance;

    /** 血脂-检验时间 */
    @Column(name="")
    private Date bloodLipidsTestTime;

    /** 血脂 */
    @Column(name="")
    private String bloodLipids;

    /** 血糖-检验时间 */
    @Column(name="")
    private Date bloodSugarTestTime;

    /** 血糖 */
    @Column(name="")
    private String bloodSugar;

    /** 是否合并传染病-检验时间 */
    @Column(name="")
    private Date isCombinedInfectiousDiseaseTestTime;

    /** 是否合并传染病（乙肝 ，丙肝，梅毒，艾滋 */
    @Column(name="")
    private String isCombinedInfectiousDisease;

    /** 肿瘤标记物-检验时间 */
    @Column(name="")
    private Date tumorMarkersTestTime;

    /** 肿瘤标记物名称 */
    @Column(name="")
    private String tumorMarkersName;

    /** 肿瘤标记物ROMA指数(公式) */
    @Column(name="")
    private String tumorMarkersRoma;

    /** HPV-检验时间 */
    @Column(name="")
    private Date hpvTestTime;

    /** HPV感染类型 */
    @Column(name="")
    private String hpvInfectionType;

    /** HPV-初次感染时间 */
    @Column(name="")
    private Date timeToFirstInfection;

    /** HPV-持续感染时间，填写时间长度 */
    @Column(name="")
    private String durationOfInfection;

    /** 血红蛋白电泳-检验时间 */
    @Column(name="")
    private Date hemoglobinTestTime;

    /** 血红蛋白电泳 */
    @Column(name="")
    private String hemoglobinElectrophoresis;

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
