package com.example.metaphorce.repository;

import com.example.metaphorce.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository  extends JpaRepository<Venta,Long> {
}
