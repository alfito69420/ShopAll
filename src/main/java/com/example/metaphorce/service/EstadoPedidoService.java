package com.example.metaphorce.service;

import com.example.metaphorce.domain.EstadoPedidoResponse;
import com.example.metaphorce.model.EstadoPedido;
import com.example.metaphorce.repository.EstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPedidoService {

    private final EstadoPedidoRepository estadoPedidoRepository;

    private EstadoPedidoResponse estadoPedidoResponse;

    @Autowired
    public EstadoPedidoService(EstadoPedidoRepository estadoPedidoRepository) {
        this.estadoPedidoRepository = estadoPedidoRepository;
    }

    //  GET ALL ESTADO PEDIDO RECORDS
    public ResponseEntity<Object> getEstadoPedido() {
        List<EstadoPedido> estadoPedidoList = estadoPedidoRepository.findAll();
        if (!estadoPedidoList.isEmpty()) {
            estadoPedidoResponse = new EstadoPedidoResponse(estadoPedidoList,
                    "Obtención de todas los registros de estado pedido", 200, true);
            return new ResponseEntity<>(estadoPedidoResponse.response2(), HttpStatus.OK);
        } else {
            estadoPedidoResponse = new EstadoPedidoResponse("No se encontraron registros de estado pedido",
                    400, false);
            return new ResponseEntity<>(estadoPedidoResponse.response2(), HttpStatus.OK);
        }
    } //close method

    //  INSERT A NEW ESTADO PEDIDO RECORD
    public ResponseEntity<Object> insertEstadoPedido(final EstadoPedido estadoPedido) {
        this.estadoPedidoRepository.save(estadoPedido);
        estadoPedidoResponse = new EstadoPedidoResponse(estadoPedido, "Se pudo crear el estado pedido", 200, true);
        return new ResponseEntity<>(estadoPedidoResponse.response(), HttpStatus.OK);
    } // close method

    //  UPDATE A SPECIFIC ESTADO PEDIDO RECORD
    public ResponseEntity<Object> updateEstadoPedido(final Long id, final EstadoPedido estadoPedido) {
        if (estadoPedidoRepository.findById(id).isPresent()) {
            EstadoPedido existingEstadoPedido = estadoPedidoRepository.findById(id).get();
            existingEstadoPedido.setNombre(estadoPedido.getNombre());
            estadoPedidoRepository.save(existingEstadoPedido);
            estadoPedidoResponse = new EstadoPedidoResponse(existingEstadoPedido, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(estadoPedidoResponse.response(), HttpStatus.OK);
        } else {
            estadoPedidoResponse = new EstadoPedidoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(estadoPedidoResponse.response(), HttpStatus.OK);
        }
    } //close method

    //  DELETE A SPECIFIC ESTADO PEDIDO RECORD
    public ResponseEntity<Object> deleteEstadoPedido(final Long id) {
        if (!this.estadoPedidoRepository.findById(id).isEmpty()) {
            this.estadoPedidoRepository.deleteById(id);
            estadoPedidoResponse = new EstadoPedidoResponse("Se ha eliminado el registro con el ID: " + id, 200, true);
            return new ResponseEntity<>(estadoPedidoResponse.response(), HttpStatus.OK);
        } else {
            estadoPedidoResponse = new EstadoPedidoResponse("No existe el registro con el ID: " + id, 400, false);
            return new ResponseEntity<>(estadoPedidoResponse.response(), HttpStatus.OK);
        }
    } //close method

    //  GET JUST ONE ESTADO PEDIDO RECORD
    public ResponseEntity<Object> getOneEstadoPedido(final Long id) {
        if (estadoPedidoRepository.findById(id).isPresent()) {
            EstadoPedido estadoPedido = estadoPedidoRepository.findById(id).get();
            estadoPedidoResponse = new EstadoPedidoResponse(estadoPedido, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(estadoPedidoResponse.response(), HttpStatus.OK);
        } else {
            estadoPedidoResponse = new EstadoPedidoResponse("No existe el detalle de la venta con el ID: " + id, 400, false);
            return new ResponseEntity<>(estadoPedidoResponse.response(), HttpStatus.OK);
        }
    } //close method
} //close class
