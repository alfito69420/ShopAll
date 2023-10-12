package com.example.metaphorce.service;

import com.example.metaphorce.domain.PedidoResponse;
import com.example.metaphorce.model.Pedido;
import com.example.metaphorce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private PedidoResponse pedidoResponse;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    //  GET ALL PEDIDO RECORDS
    public ResponseEntity<Object> getPedido() {
        List<Pedido> pedidoList = pedidoRepository.findAll();
        if (!pedidoList.isEmpty()) {
            pedidoResponse = new PedidoResponse(pedidoList, "Obtención de todos los pedidos", 200, true);
            return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No se encontraron registros del pedido", 400, false);
            return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.OK);
        }
    } //close method

    //  INSERT A NEW PEDIDO RECORD
    public ResponseEntity<Object> insertPedido(final Pedido pedido) {
        this.pedidoRepository.save(pedido);
        pedidoResponse = new PedidoResponse(pedido, "Se pudo crear el pedido", 200, true);
        return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
    } // close method

    //  DELETE A SPECIFIC PEDIDO RECORD
    public ResponseEntity<Object> deletePedido(final Long id) {
        if (!this.pedidoRepository.findById(id).isEmpty()) {
            this.pedidoRepository.deleteById(id);
            pedidoResponse = new PedidoResponse("Se ha eliminado el registro con el ID: " + id, 200, true);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No existe el registro con el ID: " + id, 400, false);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
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
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        }
    } //close method

    //  UPDATE A SPECIFIC PEDIDO RECORD
    public ResponseEntity<Object> updatePedido(final Long id, final Pedido pedido) {
        if (pedidoRepository.findById(id).isPresent()) {
            Pedido existingPedido = pedidoRepository.findById(id).get();
            existingPedido.setFecha_pedido(pedido.getFecha_pedido());
            existingPedido.setTienda_id(pedido.getTienda_id());
            existingPedido.setUsuario_id(pedido.getUsuario_id());
            existingPedido.setVenta_id(pedido.getVenta_id());
            pedidoRepository.save(existingPedido);
            pedidoResponse = new PedidoResponse(existingPedido, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        }
    } //close method
} //close class
