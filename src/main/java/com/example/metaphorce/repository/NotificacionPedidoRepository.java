package com.example.metaphorce.repository;

import com.example.metaphorce.model.NotificacionPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionPedidoRepository extends JpaRepository<NotificacionPedido,Long> {
}
