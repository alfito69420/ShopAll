package com.example.metaphorce.service;

import com.example.metaphorce.domain.VentaDetalleResponse;
import com.example.metaphorce.model.VentaDetalle;
import com.example.metaphorce.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class VentaDetalleService {

    private final VentaDetalleRepository ventaDetalleRepository;
    private VentaDetalleResponse ventaDetalleResponse;
    private static final Logger logger = LoggerFactory.getLogger(VentaDetalleService.class);


    @Autowired
    public VentaDetalleService(final VentaDetalleRepository ventaDetalleRepository) {
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    //  GET ALL VENTA DETALLE RECORDS
    public ResponseEntity<Object> getVentaDetalle() {
        List<VentaDetalle> ventaDetalleList = ventaDetalleRepository.findAll();
        if (!ventaDetalleList.isEmpty()) {
            ventaDetalleResponse = new VentaDetalleResponse(ventaDetalleList,
                    "Obtención de todas los registros del detalle de la venta", 200, true);
            return new ResponseEntity<>(ventaDetalleResponse.response2(), HttpStatus.OK);
        } else {
            ventaDetalleResponse = new VentaDetalleResponse("No se encontraron registros del detalle de todas las ventas", 400, false);
            return new ResponseEntity<>(ventaDetalleResponse.response2(), HttpStatus.OK);
        }
    } //close method

    //  INSERT A NEW VENTA DETALLE RECORD
    public ResponseEntity<Object> insertVentaDetalle(final VentaDetalle ventaDetalle) {
        logger.debug("====================="+ventaDetalle.toString());
        this.ventaDetalleRepository.save(ventaDetalle);
        ventaDetalleResponse = new VentaDetalleResponse(ventaDetalle,
                "Se pudo crear el detalle de la venta", 200, true);
        return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
    } // close method

    //  UPDATE A SPECIFIC VENTA DETALLE RECORD
    public ResponseEntity<Object> updateVentaDetalle(final Long id, final VentaDetalle ventaDetalle) {
        if (ventaDetalleRepository.findById(id).isPresent()) {
            VentaDetalle existingVentaDetalle = ventaDetalleRepository.findById(id).get();
            existingVentaDetalle.setVenta_id(ventaDetalle.getVenta_id());
            existingVentaDetalle.setProducto_id(ventaDetalle.getProducto_id());
            existingVentaDetalle.setCantidad(ventaDetalle.getCantidad());
            existingVentaDetalle.setPrecio(ventaDetalle.getPrecio());
            existingVentaDetalle.setSub_total(ventaDetalle.getSub_total());
            ventaDetalleRepository.save(existingVentaDetalle);
            ventaDetalleResponse = new VentaDetalleResponse(existingVentaDetalle,
                    "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        } else {
            ventaDetalleResponse = new VentaDetalleResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        }
    } //close method

    //  DELETE A SPECIFIC VENTA DETALLE RECORD
    public ResponseEntity<Object> deleteVentaDetalle(final Long id) {
        if (!this.ventaDetalleRepository.findById(id).isEmpty()) {
            this.ventaDetalleRepository.deleteById(id);
            ventaDetalleResponse = new VentaDetalleResponse("Se ha eliminado el registro con el ID: " + id, 200, true);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        } else {
            ventaDetalleResponse = new VentaDetalleResponse("No existe el registro con el ID: " + id, 400, false);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        }
    } //close method

    //  GET JUST ONE VENTA DETALLE RECORD
    public ResponseEntity<Object> getOneVentaDetalle(final Long id) {
        if (ventaDetalleRepository.findById(id).isPresent()) {
            VentaDetalle ventaDetalle = ventaDetalleRepository.findById(id).get();
            ventaDetalleResponse = new VentaDetalleResponse(ventaDetalle, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        } else {
            ventaDetalleResponse = new VentaDetalleResponse("No existe el detalle de la venta con el ID: " + id, 400, false);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        }
    } //close method
} //close class
