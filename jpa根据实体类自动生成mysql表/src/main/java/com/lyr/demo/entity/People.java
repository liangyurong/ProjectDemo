package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * JPA的注解
 *  @Entity
 *  @Table(name = "people")
 *  @Id
 *  @GenericGenerator(name = "idGenerator", strategy = "uuid")
 *  @GeneratedValue(generator = "idGenerator")
 *  @Column
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class People {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column
    private String name;

    @Column
    private String myEmail;

    @Column
    private String address;
}
