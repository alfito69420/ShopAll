package com.example.metaphorce.controller;

        import com.example.metaphorce.model.NotificacionPedido;
        import com.example.metaphorce.service.NotificacionPedidoService;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notificacionPedido")
public class NotificacionPedidoController {
    private final NotificacionPedidoService notificacionPedidoService;

    public NotificacionPedidoController(NotificacionPedidoService notificacionPedidoService){
        this.notificacionPedidoService = notificacionPedidoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getNotificacionesPedidos(){
        return notificacionPedidoService.getNotificacionesPedidos();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getNotificacionPedido(@PathVariable Long id){
        return this.notificacionPedidoService.getOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> registrarNotificacionPedido(@RequestBody NotificacionPedido notificacionPedido){
        return this.notificacionPedidoService.newNotificacionPedido(notificacionPedido);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarNotificacionPedido(@PathVariable Long id, @RequestBody NotificacionPedido notificacionPedido){
        return this.notificacionPedidoService.updateNotificacionPedido(id, notificacionPedido);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarNotificacionPedido(@PathVariable Long id) {
        return this.notificacionPedidoService.eliminar(id);
    }
}
