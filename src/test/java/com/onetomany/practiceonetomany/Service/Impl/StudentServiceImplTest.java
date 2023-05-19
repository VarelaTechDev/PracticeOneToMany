package com.onetomany.practiceonetomany.Service.Impl;

import com.onetomany.practiceonetomany.Entity.Student;
import com.onetomany.practiceonetomany.Repository.StudentRepository;
import com.onetomany.practiceonetomany.Service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;


    @Test
    @Transactional
    public void whenValidId_thenStudentShouldBeFound() {
        // given
        Student student = new Student();
        student.setName("Test Student");
        student = studentService.createStudent(student); // persist via service

        // when
        Student found = studentService.getStudent(student.getId());

        // then
        assertEquals(found.getName(), student.getName());
    }

}