package com.example.metaphorce.repository;

import com.example.metaphorce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
