package com.onetomany.practiceonetomany;

import com.onetomany.practiceonetomany.Entity.Professor;
import com.onetomany.practiceonetomany.Entity.Student;
import com.onetomany.practiceonetomany.Service.ProfessorService;
import com.onetomany.practiceonetomany.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final ProfessorService professorService;
    private final StudentService studentService;

    @Autowired
    public DatabaseSeeder(ProfessorService professorService, StudentService studentService) {
        this.professorService = professorService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create professors
        Professor professor1 = new Professor();
        professor1.setName("Professor A");

        Professor professor2 = new Professor();
        professor2.setName("Professor B");

        professorService.createProfessor(professor1);
        professorService.createProfessor(professor2);

        // Create students
        Student student1 = new Student();
        student1.setName("Student 1");
        student1.setProfessor(professor1);

        Student student2 = new Student();
        student2.setName("Student 2");
        student2.setProfessor(professor1);

        Student student3 = new Student();
        student3.setName("Student 3");
        student3.setProfessor(professor2);

        studentService.createStudent(student1);
        studentService.createStudent(student2);
        studentService.createStudent(student3);
    }
}