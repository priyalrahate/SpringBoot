package com.aliboucoding.jpa.model;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
////@Getter      // helps to generate getter and setter for all the attribute in the class .
////@Setter
////@AllArgsConstructor
//@Data  // can be used in place of above three
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
////@Table(name="AUTHOR_TBL")  // this way we can change the name of the table
//
//public class Author {
//    @Id
//    @GeneratedValue
//            /*(



////            strategy = GenerationType.SEQUENCE,
//             strategy = GenerationType.TABLE,
//             generator = "author-sequence"
//                  )*/   ///  here strategy=auto  the hibernate will try to connect to the database and try to determine which is the best strategy to use
//
//  /*  @SequenceGenerator(
//            name="author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize=1
//    )*/
//    // instead of using sequenceGenerator you can use
//   /* @TableGenerator(
//            name="author_id_gen",
//            table="id_generator",
//            pkColumnName = "id_name",
//            valueColumnName = "id_value",
//            allocationSize = 1
//    )*/
//
//    private Integer id;   // here we re using Integer because int default value is 0 while integer default value is null
//
//    @Column(
//            name="f_name",
//            length=35   // maxlength
//
//    )
//    private String firstname;
//     private String lastname;
//
//     @Column(
//             unique = true,
//             nullable = false
//     )
//     private String email;
//
//     private Integer age;
//
//     @Column(
//        updatable = false,
//        nullable = false
//     )
//     private LocalDateTime createdAt;
//
//     @Column(
//             insertable = false
//     )
//     private LocalDateTime lastModified;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//}



import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import com.aliboucoding.jpa.model.BaseEntity;
import java.util.List;



@EqualsAndHashCode(callSuper = true)  // it is used with the @Data when class is inheriting other class
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQuery(
        name = "Author.findByNameQuery",
        query= "select a from Author a where a.age >= :age"
)

@NamedQuery(
        name = "Author.updateByNameQuery",
        query="update Author a set a.age= :age "
)
public class Author extends BaseEntity {


    private String firstname ;
    private String lastname ;

    @Column(
            unique=true,
            nullable = false
    )
    private String email;
    private int age ;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}

