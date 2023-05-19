package com.onetomany.practiceonetomany.Service.Impl;

import com.onetomany.practiceonetomany.Entity.Student;
import com.onetomany.practiceonetomany.Repository.StudentRepository;
import com.onetomany.practiceonetomany.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudent(id);
        student.setName(studentDetails.getName());
        student.setProfessor(studentDetails.getProfessor());
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
