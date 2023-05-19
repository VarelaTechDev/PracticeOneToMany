package com.onetomany.practiceonetomany.Repository;

import com.onetomany.practiceonetomany.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
