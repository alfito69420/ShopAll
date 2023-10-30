package com.example.metaphorce.service;

import com.example.metaphorce.domain.PedidoResponse;
import com.example.metaphorce.exceptions.DataException;
import com.example.metaphorce.model.Pedido;
import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.model.User;
import com.example.metaphorce.model.Venta;
import com.example.metaphorce.repository.PedidoRepository;
import com.example.metaphorce.repository.TiendaRepository;
import com.example.metaphorce.repository.UserRepository;
import com.example.metaphorce.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final UserRepository userRepository;
    private final VentaRepository ventaRepository;
    private  final TiendaRepository tiendaRepository;
    private PedidoResponse pedidoResponse;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, UserRepository userRepository, VentaRepository ventaRepository, TiendaRepository tiendaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.userRepository = userRepository;
        this.ventaRepository = ventaRepository;
        this.tiendaRepository = tiendaRepository;

    }

    //  GET ALL PEDIDO RECORDS

    public ResponseEntity<Object> getPedido(){

        List<Pedido> pedidoList = pedidoRepository.findAll();
        if (!pedidoList.isEmpty()) {
            pedidoResponse = new PedidoResponse(pedidoList, "Obtención de todos los pedidos", 200, true);
            return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.OK);
        } else {
            System.out.println(new DataException("No se encontraron registros del pedido"));
            //throw new DataException(""); para crear excepciones
            pedidoResponse = new PedidoResponse("No se encontraron registros del pedido", 400, false);
            return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.BAD_REQUEST);
        }
    } //close method

    //  INSERT A NEW PEDIDO RECORD
    public ResponseEntity<Object> insertPedido(Pedido pedido) {
        Optional<User> usuarioOptional = userRepository.findById(pedido.getUser().getUsuario_id());
        Optional<Tienda> tiendaOptional = tiendaRepository.findById(pedido.getTienda().getTienda_id());
        Optional<Venta> ventaOptional = ventaRepository.findById(pedido.getVenta().getVenta_id());
        if (usuarioOptional.isPresent() && tiendaOptional.isPresent() && ventaOptional.isPresent()) {

            User usuario = usuarioOptional.get();
            Tienda tienda = tiendaOptional.get();
            Venta venta = ventaOptional.get();
            pedido.setUser(usuario);
            pedido.setTienda(tienda);
            pedido.setVenta(venta);
            Pedido nuevoPedido = pedidoRepository.save(pedido);
            pedidoResponse = new PedidoResponse(nuevoPedido, "Pedido Creado", 200, true);
            return new ResponseEntity<>(pedidoResponse, HttpStatus.CREATED);
        } else {
            if (!usuarioOptional.isPresent()) {
                pedidoResponse = new PedidoResponse("No existe el Usuario con el ID: " + pedido.getUser().getUsuario_id(), 400, false);
                return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.BAD_REQUEST);
            } else {
                if (!tiendaOptional.isPresent()) {
                    pedidoResponse = new PedidoResponse("No existe la Tienda con el ID: " + pedido.getTienda().getTienda_id(), 400, false);
                    return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.BAD_REQUEST);
                } else {
                    if(!ventaOptional.isPresent()){
                        pedidoResponse = new PedidoResponse("No existe la ventacon el ID: " + pedido.getVenta().getVenta_id(), 400, false);
                        return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.BAD_REQUEST);
                    }else {
                        pedidoResponse = new PedidoResponse("ERROR al crear el Pedido", 400, false);
                        return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
            }
        }



    }// close method

    //  DELETE A SPECIFIC PEDIDO RECORD
    public ResponseEntity<Object> deletePedido(final Long id) {
        if (!this.pedidoRepository.findById(id).isEmpty()) {
            this.pedidoRepository.deleteById(id);
            pedidoResponse = new PedidoResponse("Se ha eliminado el registro con el ID: " + id, 200, true);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No existe el registro con el ID: " + id, 400, false);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.BAD_REQUEST);
        }
    } //close method

    //  GET JUST ONE PEDIDO RECORD
    public ResponseEntity<Object> getOnePedido(final Long id) {
        if (pedidoRepository.findById(id).isPresent()) {
            Pedido pedido = pedidoRepository.findById(id).get();
            pedidoResponse = new PedidoResponse(pedido, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No existe el detalle de la venta con el ID: " + id, 400, false);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.BAD_REQUEST);
        }
    } //close method

    //  UPDATE A SPECIFIC PEDIDO RECORD
    public ResponseEntity<Object> updatePedido(Long id, Pedido pedido) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            Pedido existingPedido = pedidoOptional.get();
            if (pedido.getUser() != null) {
                Optional<User> usuarioOptional = userRepository.findById(pedido.getUser().getUsuario_id());
                if (usuarioOptional.isPresent()) {
                    existingPedido.setUser(pedido.getUser());
                } else {
                    pedidoResponse = new PedidoResponse("No existe el Usuario con el ID: " + pedido.getUser().getUsuario_id(), 400, false);
                    return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.BAD_REQUEST);
                }
            }

            if (pedido.getTienda() != null) {
                Optional<Tienda> tiendaOptional = tiendaRepository.findById(pedido.getTienda().getTienda_id());
                if (tiendaOptional.isPresent()) {
                    existingPedido.setTienda(pedido.getTienda());
                } else {
                    pedidoResponse = new PedidoResponse("No existe la Tienda con el ID: " + pedido.getTienda().getTienda_id(), 400, false);
                    return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.BAD_REQUEST);
                }
            }

            if (pedido.getVenta() != null) {
                Optional<Venta> ventaOptional = ventaRepository.findById(pedido.getVenta().getVenta_id());
                if (ventaOptional.isPresent()) {
                    existingPedido.setVenta(pedido.getVenta());
                } else {
                    pedidoResponse = new PedidoResponse("No existe la Venta con el ID: " + pedido.getVenta().getVenta_id() ,400, false);
                    return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.BAD_REQUEST);
                }
            }

            if (pedido.getFecha_pedido() != null) {
                existingPedido.setFecha_pedido(pedido.getFecha_pedido());
            }
            pedidoRepository.save(existingPedido);
            pedidoResponse = new PedidoResponse(existingPedido, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No existe el ID: " + id, 404, false);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.NOT_FOUND);
        }
    }

} //close class
