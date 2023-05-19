package com.onetomany.practiceonetomany.Service.Impl;

import com.onetomany.practiceonetomany.Entity.Professor;
import com.onetomany.practiceonetomany.Entity.Student;
import com.onetomany.practiceonetomany.Repository.ProfessorRepository;
import com.onetomany.practiceonetomany.Repository.StudentRepository;
import com.onetomany.practiceonetomany.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessor(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
    }

    @Override
    @Transactional
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    @Transactional
    public Professor updateProfessor(Long id, Professor professorDetails) {
        Professor professor = getProfessor(id);
        professor.setName(professorDetails.getName());
        professor.setStudents(professorDetails.getStudents());
        return professorRepository.save(professor);
    }

    @Override
    @Transactional
    public void deleteProfessor(Long id) {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();

            // Dereference all students of this professor before deletion
            List<Student> students = professor.getStudents();
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                student.setProfessor(null);
                studentRepository.save(student);
            }

            professorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Professor not found with ID: " + id);
        }
    }

}

