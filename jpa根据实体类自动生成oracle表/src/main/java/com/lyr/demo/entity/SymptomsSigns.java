package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 症状体征(没写完)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "V_SYMPTOMS_SIGNS")
public class SymptomsSigns {


    public static void main(String[] args) {
        getWorld("hello");
        getWorld("world");
    }

    private static void getWorld(String world) {
        System.out.println(world);
    }

    /** 病人id */
    @Column(name="PATIENT_ID")
    private String patientId;

    /** 发病时间 */
    @Column(name="")
    private String onsetTime;

    /** 初发症状 */
    @Column(name="")
    private String firstSymptoms;

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
