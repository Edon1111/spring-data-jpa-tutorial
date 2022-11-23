package com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {


    @Id
    @SequenceGenerator(
            name="teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

//    @OneToMany(
//            cascade=CascadeType.ALL
//    )
//    //foreign key teacherId as teacher_id on course table - @JoinColumn explained
//    @JoinColumn(
//            name="teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Course> courses;
}
