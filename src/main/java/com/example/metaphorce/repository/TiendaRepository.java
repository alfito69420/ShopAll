package com.example.metaphorce.repository;


import com.example.metaphorce.model.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TiendaRepository extends JpaRepository<Tienda,Long> {
    //void deleteTiendaBy(Long id);
}
