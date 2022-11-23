package com.springbootbeginnerJPA.spring.data.jpa.tutorial.repository;

import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Course;
import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository ;


    @Test
    public void saveTeacher(){

        Course course = Course.builder()
                .courseTitle("English")
                .credit(5)
                .build();

        Course courseNodejs = Course.builder()
                .courseTitle("NodeJs")
                .credit(5)
                .build();

        Course courseReactjs = Course.builder()
                .courseTitle("Reactjs")
                .credit(5)
                .build();




        Teacher teacher = Teacher.builder()
                .firstName("John ")
                .lastName("Blank")
                //.courses(List.of(course,courseNodejs,courseReactjs))
                .build();

        teacherRepository.save(teacher);
    }
}