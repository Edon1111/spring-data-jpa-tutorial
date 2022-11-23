package com.springbootbeginnerJPA.spring.data.jpa.tutorial.repository;

import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Course;
import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Student;
import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("Courses= " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Bob")
                .lastName("Smith")
                .build();

        Course course = Course.builder()
                .courseTitle("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);


        List<Course> course
                = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages=" + totalPages);
        System.out.println("courses= " + course);
    }


    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("courseTitle"));
        Pageable sortByCreditDesc =
                PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2,Sort.by("courseTitle").descending().and(Sort.by("credit")));


        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }


    @Test
    public void printfindByCourseTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByCourseTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);


    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Jack")
                .lastName("Henston")
                .build();

        Student student = Student.builder()
                .firstName("Edon")
                .lastName("Terstena")
                .emailId("EDONTERSTENA@GMAIL.com")
                .build();
        Course course = Course.builder()
                .courseTitle("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }


}