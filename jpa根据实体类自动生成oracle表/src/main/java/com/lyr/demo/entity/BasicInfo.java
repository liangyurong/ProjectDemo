package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BASIC_INFO1")
public class BasicInfo {
    /** 患者编号 */
    @Id
    @Column(name="PATIENT_ID")
    private String id;

    /** 住院号 */
    @Column(name="HOSP_ID")
    private String hospId;

    /** 身份证号 */
    @Column(name="ID_NUM")
    private String idNum;  //

    /** 性别 */
    @Column(name="GENDER")
    private String gender;

    /** 年龄 */
    @Column(name="AGE")
    private String age;

    /** 联系电话 */
    @Column(name="PHONE")
    private String phone;

    /** 婚姻状况 */
    @Column(name="MARRIAGE")
    private String marriage;

    /** 职业（选项） */
    @Column(name="JOB")
    private String job;

    /** 收入 */
    @Column(name="INCOME")
    private String income;

    /** 受教育程度（小学，初中，中专，大专，大学） */
    @Column(name="EDUCATION")
    private String education;

    /** 医保（选项） */
    @Column(name="MEDICAL_INSURANCE")
    private String medicalInsurance;

    /** 身高（m） */
    @Column(name="HEIGHT")
    private String height;

    /** 体重(kg) */
    @Column(name="WEIGHT")
    private String weight;

    /** BMI（公式计算） */
    @Column(name="BMI")
    private String bmi;

    /** 臀围 */
    @Column(name="HIPS")
    private String hips;

    /** 腰围 */
    @Column(name="WAIST_CIRCUMFERENCE")
    private String waistCircumference;

    /** 腰臀比 */
    @Column(name="WAIST_TO_HIP_RATIO")
    private String waistToHipRatio;

    /** 抽烟（无、有（一日?支）） */
    @Column(name="SMOKE")
    private String smoke;

    /** 饮酒（无、有（……）） */
    @Column(name="DRINK")
    private String drink;

    /** 避孕方式（无，有（避孕套，避孕药，节育环，结扎）） */
    @Column(name="CONTRACEPTIVE_METHOD")
    private String contraceptiveMethod;

    /** 体检（无、有（一年?次）） */
    @Column(name="PHYSICAL_TEST")
    private String physicalTest;

    /** 性伴侣数量 */
    @Column(name="SEX_PARTNER_NUM")
    private String sexPartnerNum;

    /** 初次性生活年龄 */
    @Column(name="FIRST_SEX_AGE")
    private String firstSexAge;

    /** 运动（无、有（运动名称，一周时长）） */
    @Column(name="SPORT")
    private String sport;

}

