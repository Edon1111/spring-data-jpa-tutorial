package com.springbootbeginnerJPA.spring.data.jpa.tutorial.repository;

import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

     List<Student>findByFirstName(String firstName);
     List<Student>findByFirstNameContaining(String name);
     List<Student>findByLastNameNotNull();
     List<Student>findByGuardianName(String guardianName);
     Student findByFirstNameAndLastName(String firstName, String lastName);


     //custom methods based on query
     //JPQL query select based on class name not table name that is setted by annotation, in this p.ex Student not tbl_student!
     //JPQL
     @Query("select s from Student s where s.emailId = ?1 ")
     Student getStudentByEmailAddress(String emailId);

     //JPQL
     @Query("select s.firstName from Student s where s.emailId = ?1 ")
     String getStudentFirstNameByEmailAddress(String emailId);


     //Native query used for complex queries
     //Native query names are defined same as they're shown on db schema or as we named them with annotations ex: email_address as emailId, tbl_student as Student
     //in other words the query should be exactly the same as you write on sql apps
     @Query(
             value="select * from tbl_student s where s.email_address = ?1",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNative(String emailId);



     //Native Named Param
     @Query(
             value="select * from tbl_student s where s.email_address = :emailId",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNativeNamedParam(@Param("emailId")String emailId);



     ///---update query example
     @Modifying
     @Transactional
     @Query(
             value="update tbl_student set first_name = ?1 where email_address= ?2",
             nativeQuery = true
     )
     int updateStudentNameByEmailId(String firstName,String emailId);
}
