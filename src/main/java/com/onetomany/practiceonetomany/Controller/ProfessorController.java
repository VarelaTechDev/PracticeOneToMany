package com.onetomany.practiceonetomany.Controller;

import com.onetomany.practiceonetomany.Entity.Professor;
import com.onetomany.practiceonetomany.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public Professor getProfessor(@PathVariable Long id) {
        return professorService.getProfessor(id);
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professorDetails) {
        return professorService.updateProfessor(id, professorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }
}

