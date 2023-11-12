package com.example.metaphorce.service;

import com.example.metaphorce.domain.NotificacionPedidoResponse;
import com.example.metaphorce.model.EstadoPedido;
import com.example.metaphorce.model.NotificacionPedido;
import com.example.metaphorce.model.Pedido;
import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.repository.EstadoPedidoRepository;
import com.example.metaphorce.repository.NotificacionPedidoRepository;
import com.example.metaphorce.repository.PedidoRepository;
import com.example.metaphorce.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionPedidoService {
    private final NotificacionPedidoRepository notificacionPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final EstadoPedidoRepository estadoPedidoRepository;
    private final UserRepository userRepository;
    private NotificacionPedidoResponse response;

    public NotificacionPedidoService(NotificacionPedidoRepository notificacionPedidoRepository, PedidoRepository pedidoRepository, EstadoPedidoRepository estadoPedidoRepository, UserRepository userRepository) {
        this.notificacionPedidoRepository = notificacionPedidoRepository;
        this.pedidoRepository = pedidoRepository;
        this.estadoPedidoRepository = estadoPedidoRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> getNotificacionesPedidos() {
        List<NotificacionPedido> notificacionesPedidos = notificacionPedidoRepository.findAll();
        if (!notificacionesPedidos.isEmpty()) {
            response = new NotificacionPedidoResponse(notificacionesPedidos, "Obtención de todas las NotificacionesPedidos", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new NotificacionPedidoResponse("No se encontraron NotificacionesPedidos", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> newNotificacionPedido(NotificacionPedido notificacionPedido) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(notificacionPedido.getPedido().getPedido_id());
        Optional<EstadoPedido> optionalEstadoPedido = estadoPedidoRepository.findById(notificacionPedido.getEstadoPedido().getEstado_pedido_id());
        Optional<UserEntity> optionalUsuario = userRepository.findById(notificacionPedido.getUser().getUsuario_id());

        if (optionalPedido.isPresent() && optionalEstadoPedido.isPresent() && optionalUsuario.isPresent()) {
            notificacionPedido.setPedido(optionalPedido.get());
            notificacionPedido.setEstadoPedido(optionalEstadoPedido.get());
            notificacionPedido.setUser(optionalUsuario.get());
            this.notificacionPedidoRepository.save(notificacionPedido);
            response = new NotificacionPedidoResponse(notificacionPedido, "Se pudo crear la Notificación de Pedido", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            // Manejar el caso en el que no se encuentren una o más de las entidades relacionadas
            response = new NotificacionPedidoResponse("No se encontró una o más entidades relacionadas", 404, false);
            return new ResponseEntity<>(response.response(), HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Object> updateNotificacionPedido(Long id, NotificacionPedido notificacionPedido) {
        Optional<NotificacionPedido> optionalExistingNotificacion = notificacionPedidoRepository.findById(id);
        if (optionalExistingNotificacion.isPresent()) {
            NotificacionPedido existingNotificacionPedido = optionalExistingNotificacion.get();
            existingNotificacionPedido.setMensaje(notificacionPedido.getMensaje());
            existingNotificacionPedido.setFecha_hora_creacion(notificacionPedido.getFecha_hora_creacion());
            existingNotificacionPedido.setEstadoPedido(notificacionPedido.getEstadoPedido());
            existingNotificacionPedido.setUser(notificacionPedido.getUser());
            notificacionPedidoRepository.save(existingNotificacionPedido);
            response = new NotificacionPedidoResponse(existingNotificacionPedido, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new NotificacionPedidoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST); // Cambiado a BAD_REQUEST para reflejar un error de cliente
        }
    }


    public ResponseEntity<Object> eliminar(Long id) {
        if (!this.notificacionPedidoRepository.findById(id).isEmpty()) {
            this.notificacionPedidoRepository.deleteById(id);
            response = new NotificacionPedidoResponse("Si se pudo eliminar el ID :" + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new NotificacionPedidoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);

        }
    }

    ;

    public ResponseEntity<Object> getOne(Long id) {
        if (notificacionPedidoRepository.findById(id).isPresent()) {
            NotificacionPedido notizacionPedidocacion = notificacionPedidoRepository.findById(id).get();
            response = new NotificacionPedidoResponse(notizacionPedidocacion, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new NotificacionPedidoResponse("No existe la Notificación de Pedido con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
