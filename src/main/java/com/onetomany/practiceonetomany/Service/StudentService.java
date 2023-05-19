package com.onetomany.practiceonetomany.Service;

import com.onetomany.practiceonetomany.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudent(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student studentDetails);
    void deleteStudent(Long id);
}
