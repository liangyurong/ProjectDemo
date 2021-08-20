package com.lyr.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@ApiModel("问卷")
@Entity
@Data
@Table(name = "t_survey")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}) //防止转换json数据的时候出现无限制循环
public class Survey {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    private String title;

    /**
     * orphanRemoval=true配置表明删除无关联的数据。级联更新子结果集时此配置最关键
     */
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<Question> questions = new LinkedList<>();

    /**
     * 手动添加问题
     */
    public void addQuestion(Question q) {
        if (null != q) {
            questions.add(q);
        }
    }

}
