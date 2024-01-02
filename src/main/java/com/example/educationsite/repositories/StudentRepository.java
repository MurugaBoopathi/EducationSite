package com.example.educationsite.repositories;

import com.example.educationsite.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Boopathi
 * @Date 1/2/2024
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
