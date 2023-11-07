package com.example.metaphorce.repository;

import com.example.metaphorce.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    //Optional<Rol> findByName(String name);
}
