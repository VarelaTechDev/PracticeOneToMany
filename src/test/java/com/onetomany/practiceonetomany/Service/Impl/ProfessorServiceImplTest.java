package com.onetomany.practiceonetomany.Service.Impl;

import com.onetomany.practiceonetomany.Entity.Professor;
import com.onetomany.practiceonetomany.Repository.ProfessorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfessorServiceImplTest {

    @Mock
    private ProfessorRepository professorRepository;

    @InjectMocks
    private ProfessorServiceImpl professorService;

    @Test
    public void whenValidId_thenProfessorShouldBeFound() {
        // given
        Professor professor = new Professor();
        professor.setName("Test Professor");
        when(professorRepository.findById(any())).thenReturn(Optional.of(professor));

        // when
        Professor found = professorService.getProfessor(1L);

        // then
        assertEquals(found.getName(), professor.getName());
    }
}