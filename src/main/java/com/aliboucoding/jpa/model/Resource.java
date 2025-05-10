package com.aliboucoding.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  --> only with single table
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="resource_type")
public class Resource  {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int size;

    private String url ;


    @OneToOne
    @JoinColumn(name="lecture_id")
    private Lecture lecture;

}
