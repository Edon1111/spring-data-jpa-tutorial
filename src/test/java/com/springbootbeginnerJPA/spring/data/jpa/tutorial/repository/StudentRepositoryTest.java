package com.springbootbeginnerJPA.spring.data.jpa.tutorial.repository;

import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Guardian;
import com.springbootbeginnerJPA.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("edon@gmail.com")
                .firstName("Edon")
                .lastName("Terstena")
//                .guardianName("Doni")
//                .guardianEmail("doni@gmail.com")
//                .guardianMobile("045-887-373")
                .build();

        studentRepository.save(student);
    }


    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("06@gmail.com")
                .name("06")
                .mobile("040050300432")
                .build();

        Student student = Student.builder()
                .firstName("DOni06")
                .emailId("06@gmail.com")
                .lastName("")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
            List<Student> studentList=
                    studentRepository.findAll();

            System.out.println("studentList= " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student>students=
                studentRepository.findByFirstName("Filan");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student>students =
                studentRepository.findByFirstNameContaining("f");
        System.out.println("Students = "+ students);
    }

    @Test
    public void printStudentByLastNameNotNull(){
        List<Student> students =
                studentRepository.findByLastNameNotNull();
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student>students =
                studentRepository.findByGuardianName("nik");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        Student student =
                studentRepository.findByFirstNameAndLastName("Filan","Fisteku");
        System.out.println("Student = " + student.getFirstName() + " " + student.getLastName());
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("edon@gmail.com");

        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("edon@gmail.com");

        System.out.println("FirstName = " +firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("Filan@gmail.com");

        System.out.println("student = " + student);
    }
    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){

        Student student =
                studentRepository.getStudentByEmailAddressNative("06@gmail.com");

        System.out.println("student = " + student.getEmailId());

    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("DoniTest","edon@gmail.com");



    }
}