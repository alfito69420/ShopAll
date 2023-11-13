package com.example.metaphorce.service;

import com.example.metaphorce.domain.NotificacionPedidoResponse;
import com.example.metaphorce.model.*;
import com.example.metaphorce.repository.EstadoPedidoRepository;
import com.example.metaphorce.repository.NotificacionPedidoRepository;
import com.example.metaphorce.repository.PedidoRepository;
import com.example.metaphorce.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class NotificacionPedidoServiceTest {
    @Mock
    private NotificacionPedidoRepository notificacionPedidoRepository;

    @InjectMocks
    NotificacionPedidoService notificacionPedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private EstadoPedidoRepository estadoPedidoRepository;

    @Mock
    private UserRepository userRepository;

    private NotificacionPedido notificacionPedido;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        notificacionPedido = new NotificacionPedido();

        notificacionPedido.setEstadoPedido(new EstadoPedido());
    }

    @Test
    void getNotificacionesPedidos() {
        when(notificacionPedidoRepository.findAll()).thenReturn(Collections.singletonList(new NotificacionPedido()));

        // Ejecutar el método a probar
        ResponseEntity<Object> responseEntity = notificacionPedidoService.getNotificacionesPedidos();

        // Verificar el resultado
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void newNotificacionPedido() {
        Pedido pedido = new Pedido();
        pedido.setPedido_id(1L);
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setEstado_pedido_id(1L);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsuario_id(1L);

        NotificacionPedido notificacionPedido = new NotificacionPedido();
        notificacionPedido.setPedido(pedido);
        notificacionPedido.setEstadoPedido(estadoPedido);
        notificacionPedido.setUser(userEntity);

        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
        when(estadoPedidoRepository.findById(1L)).thenReturn(Optional.of(estadoPedido));
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        // Ejecutar el método a probar
        ResponseEntity<Object> responseEntity = notificacionPedidoService.newNotificacionPedido(notificacionPedido);

        // Verificar el resultado
        assertEquals(200, responseEntity.getStatusCodeValue());

        // Esto era para probar, lo dejo porque puede servir para registrar en otros test
        // Configurar valores de prueba
        /*notificacionPedido.setNotificacion_pedido_id(1L);

        // Usuario con valores ficticios para el test
        UserEntity usuario = new UserEntity();
        usuario.setUsuario_id(1L);
        usuario.setNombre("Nombre de Prueba");
        usuario.setEmail("prueba@example.com");
        usuario.setEmail_verificado(false);
        usuario.setContrasena("contrasena123");
        usuario.setDireccion("Calle de Prueba, Ciudad de Prueba");
        usuario.setTelefono("123456789");
        usuario.setToken(null);
        usuario.setCiudad("Ciudad de Prueba");
        // Crear roles y agregarlos al usuario
        Rol rol1 = new Rol();
        rol1.setRol_id(1L);
        rol1.setRol("ROL1");

        Rol rol2 = new Rol();
        rol2.setRol_id(2L);
        rol2.setRol("ROL2");

        Set<Rol> roles = new HashSet<>();
        roles.add(rol1);
        roles.add(rol2);

        usuario.setRoles(roles);

        Pedido pedido = new Pedido();
        pedido.setPedido_id(1L);
        pedido.setFecha_pedido("2023-11-13");
        pedido.setUser(usuario);

        Tienda tienda = new Tienda();
        pedido.setTienda(tienda);
        tienda.setTienda_id(1);
        tienda.setNombre("Tienda prueba");
        tienda.setDescripcion("PRUEBA DE TIENDA");

        Venta venta = new Venta();
        venta.setVenta_id(1L);
        pedido.setVenta(venta);
        venta.setUser(usuario);
        TipoPago tipoPago = new TipoPago();
        tipoPago.setTipo_pago_id(1);
        tipoPago.setNombre("Prueba tipo pago");
        tipoPago.setDescripcion("Prueba para el tipo de pago");
        venta.setTipoPago(tipoPago);

        // EstadoPedido con nombre ficticio para el test
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setEstado_pedido_id(1L);
        estadoPedido.setNombre("Estado de Prueba");

        NotificacionPedido notificacionPedido = new NotificacionPedido();
        notificacionPedido.setPedido(pedido);
        notificacionPedido.setEstadoPedido(estadoPedido);
        notificacionPedido.setUser(usuario);
        notificacionPedido.setMensaje("Nuevo mensaje de prueba");

        // Configurar fecha actual
        Date fechaActual = new Date();
        notificacionPedido.setFecha_hora_creacion(fechaActual);

        // Imprimir información de depuración
        System.out.println("notificacionPedido antes de llamar al servicio: " + notificacionPedido);

        // Llamar a la función del servicio
        ResponseEntity<Object> responseEntity = notificacionPedidoService.newNotificacionPedido(notificacionPedido);

        // Verificar el resultado
        System.out.println("Respuesta del servicio: " + responseEntity);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

         */
    }



    @Test
    void updateNotificacionPedido() {
        // Simular el comportamiento del repositorio
        NotificacionPedido existingNotificacionPedido = new NotificacionPedido();
        existingNotificacionPedido.setNotificacion_pedido_id(1L);

        when(notificacionPedidoRepository.findById(1L)).thenReturn(Optional.of(existingNotificacionPedido));

        // Datos para la actualización
        NotificacionPedido updatedNotificacionPedido = new NotificacionPedido();
        updatedNotificacionPedido.setMensaje("Nuevo mensaje");

        // Ejecutar el método a probar
        ResponseEntity<Object> responseEntity = notificacionPedidoService.updateNotificacionPedido(1L, updatedNotificacionPedido);

        // Verificar el resultado
        assertEquals(200, responseEntity.getStatusCodeValue());
        // Puedes agregar más aserciones según la estructura de tu respuesta
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void eliminar() {
        // Simular el comportamiento del repositorio
        when(notificacionPedidoRepository.findById(1L)).thenReturn(Optional.of(new NotificacionPedido()));

        // Ejecutar el método a probar
        ResponseEntity<Object> responseEntity = notificacionPedidoService.eliminar(1L);

        // Verificar el resultado
        assertEquals(200, responseEntity.getStatusCodeValue());
        // Puedes agregar más aserciones según la estructura de tu respuesta
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void getOne() {
        Long id = 1L;

        // Simular el comportamiento del repositorio al devolver un Optional con un valor
        NotificacionPedido notificacionPedido = new NotificacionPedido();
        notificacionPedido.setNotificacion_pedido_id(id);
        Optional<NotificacionPedido> optionalNotificacionPedido = Optional.of(notificacionPedido);

        // Configurar el comportamiento esperado del repositorio
        when(notificacionPedidoRepository.findById(id)).thenReturn(optionalNotificacionPedido);

        // Llamar a la función del servicio
        ResponseEntity<Object> responseEntity = notificacionPedidoService.getOne(id);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}