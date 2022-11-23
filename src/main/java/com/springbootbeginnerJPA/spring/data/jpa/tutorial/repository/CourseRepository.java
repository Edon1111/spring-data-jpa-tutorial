package com.springbootbeginnerJPA.spring.data.jpa.tutorial.repository;

import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    //custom method for sorting
    Page<Course> findByCourseTitleContaining(String title, Pageable pageRequest);
}
