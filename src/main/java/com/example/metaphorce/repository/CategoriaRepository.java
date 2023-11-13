package com.example.metaphorce.repository;

import com.example.metaphorce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
