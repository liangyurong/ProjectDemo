package com.lyr.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ApiModel("选项")
@Entity
@Data
@Table(name = "t_option")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Option {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String title;

    /**
     * 建立外键quid.外键不能为空
     */
    @ManyToOne
    @JoinColumn(name = "quid",nullable = false)
    @JsonManagedReference
    @ToString.Exclude
    private Question question;

}
