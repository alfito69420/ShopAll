package com.example.metaphorce.repository;

import com.example.metaphorce.model.UserImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserImpl,Long> {
    Optional<UserImpl> findOneByEmail(String email);
}
