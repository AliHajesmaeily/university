package org.example.university.repository;

import org.example.university.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;                      //یعنی نمیخوام اینو بین کنی

import java.util.Optional;


public interface UserRepository <T extends User> extends JpaRepository<T, Long> {


}
