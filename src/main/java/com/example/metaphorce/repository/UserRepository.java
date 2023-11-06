package com.example.metaphorce.repository;

import com.example.metaphorce.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findOneByEmail(String email);
}
