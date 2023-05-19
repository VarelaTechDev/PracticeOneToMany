package com.onetomany.practiceonetomany.Repository;

import com.onetomany.practiceonetomany.Entity.Professor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ProfessorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    public void whenFindById_thenReturnProfessor() {
        // given
        Professor professor = new Professor();
        professor.setName("Test Professor");
        entityManager.persist(professor);
        entityManager.flush();

        // when
        Professor found = professorRepository.findById(professor.getId()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(professor.getName());
    }
}