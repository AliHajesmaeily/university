package org.example.university.repository;
import org.example.university.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long>,UserRepository<Professor> {
    Optional<Professor> findByCode(int code);
    Optional<Professor> findByUserName(String userName);
}
