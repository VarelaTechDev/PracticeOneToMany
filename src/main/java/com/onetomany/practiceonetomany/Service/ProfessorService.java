package com.onetomany.practiceonetomany.Service;

import com.onetomany.practiceonetomany.Entity.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> getAllProfessors();
    Professor getProfessor(Long id);
    Professor createProfessor(Professor professor);
    Professor updateProfessor(Long id, Professor professorDetails);
    void deleteProfessor(Long id);
}
