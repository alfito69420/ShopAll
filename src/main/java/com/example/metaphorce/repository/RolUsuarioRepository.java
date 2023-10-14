package com.example.metaphorce.repository;

import com.example.metaphorce.model.Rol;
import com.example.metaphorce.model.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario,Long> {
}
