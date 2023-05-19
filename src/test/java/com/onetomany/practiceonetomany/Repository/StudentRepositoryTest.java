package com.onetomany.practiceonetomany.Repository;

import com.onetomany.practiceonetomany.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void whenFindById_thenReturnStudent() {
        // given
        Student student = new Student();
        student.setName("Test Student");
        entityManager.persist(student);
        entityManager.flush();

        // when
        Student found = studentRepository.findById(student.getId()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(student.getName());
    }

    // Add more tests...
}