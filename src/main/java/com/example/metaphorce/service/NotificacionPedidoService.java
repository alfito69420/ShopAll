package com.example.metaphorce.service;

        import com.example.metaphorce.domain.NotificacionPedidoResponse;
        import com.example.metaphorce.model.NotificacionPedido;
        import com.example.metaphorce.repository.NotificacionPedidoRepository;

        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class NotificacionPedidoService {
    private final NotificacionPedidoRepository notificacionPedidoRepository;
    NotificacionPedidoResponse response;

    public NotificacionPedidoService(NotificacionPedidoRepository notificacionPedidoRepository){
        this.notificacionPedidoRepository = notificacionPedidoRepository;
    }

    public ResponseEntity<Object> getNotificacionesPedidos(){
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
        this.notificacionPedidoRepository.save(notificacionPedido);
        response = new NotificacionPedidoResponse(notificacionPedido, "Se pudo crear la Notificación de Pedido",200,true );
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    };

    public ResponseEntity<Object> updateNotificacionPedido(Long id, NotificacionPedido notificacionPedido) {
        if (notificacionPedidoRepository.findById(id).isPresent()) {
            NotificacionPedido existingNotificacionPedido = notificacionPedidoRepository.findById(id).get();
            existingNotificacionPedido.setMensaje(notificacionPedido.getMensaje());
            existingNotificacionPedido.setFecha_hora_creacion(notificacionPedido.getFecha_hora_creacion());
            existingNotificacionPedido.setEstado_pedido_id(notificacionPedido.getEstado_pedido_id());
            existingNotificacionPedido.setUsuario_id(notificacionPedido.getUsuario_id());
            notificacionPedidoRepository.save(existingNotificacionPedido);
            response = new NotificacionPedidoResponse(existingNotificacionPedido, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new NotizacionPedidocacionResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    };

    public ResponseEntity<Object> eliminar(Long id){
        if(!this.notizacionPedidocacionRepository.findById(id).isEmpty()){
            this.notizacionPedidocacionRepository.deleteById(id);
            response = new NotizacionPedidocacionResponse("Si se pudo eliminar el ID :"+id,200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new NotizacionPedidocacionResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    public ResponseEntity<Object> getOne(Long id){
        if (notizacionPedidocacionRepository.findById(id).isPresent()) {
            NotizacionPedidocacion notizacionPedidocacion = notizacionPedidocacionRepository.findById(id).get();
            response = new NotizacionPedidocacionResponse(notizacionPedidocacion, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new NotizacionPedidocacionResponse("No existe la Notificación de Pedido con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
