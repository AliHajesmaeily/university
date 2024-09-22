package org.example.university.repository;

import org.example.university.entity.Professor;
import org.example.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository   extends JpaRepository<Student,Long> ,UserRepository<Student>{

    Optional<Student> stdNumber(long code);
    Optional<Student> findByUserName(String userName);
}
