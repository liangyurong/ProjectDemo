package com.lyr.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 针对Survey，Question是多的一方，因此在与Survey的关系中，属于维护关系的一方。Survey属于被维护关系的一方。
 *
 */

@ApiModel("问题")
@Entity
@Data
@Table(name = "t_question")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Question {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String title;

    /**
     * （针对survey）建立外键 belong_survey_id.外键不能为空
     */
    @ManyToOne
    @JoinColumn(name = "belong_survey_id",nullable = false)
    @JsonManagedReference
    @ToString.Exclude
    private Survey survey;

    /**
     * （针对Option）
     * orphanRemoval=true配置表明删除无关联的数据。级联更新子结果集时此配置最关键
     */
    @OneToMany(mappedBy = "question",cascade=CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<Option> options=new LinkedList<>();

    /** 手动添加选项 */
    public void addOption(Option option){
        if(null!=option){
            options.add(option);
        }
    }

}
