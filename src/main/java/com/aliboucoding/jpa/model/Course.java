package com.aliboucoding.jpa.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)  // it is used with the @Data when class is inheriting other class
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Course extends BaseEntity {

    private String title;
    private String description;

    @ManyToMany
    @JoinTable(
            name="authors-courses",
            joinColumns = {
                 @JoinColumn(name= "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name= "author_id")
            }
    )

    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
