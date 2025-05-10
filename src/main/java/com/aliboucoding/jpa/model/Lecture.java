package com.aliboucoding.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)  // it is used with the @Data when class is inheriting other class
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name="section_id")
    private Section sections ;

    @OneToOne
    @JoinColumn(name="resource_id")
    private Resource resource;

}
