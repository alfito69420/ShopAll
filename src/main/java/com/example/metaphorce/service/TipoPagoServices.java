package com.example.metaphorce.service;

import com.example.metaphorce.domain.TipoPagoResponse;
import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.repository.TipoPagoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagoServices {
    private final TipoPagoRepository tipoPagoRepository;

    private TipoPagoResponse response;

    public TipoPagoServices(TipoPagoRepository tipoPagoRepository) {
        this.tipoPagoRepository = tipoPagoRepository;
    }

    public ResponseEntity<Object> getTipoPago() {
        List<TipoPago> tipoPagos = tipoPagoRepository.findAll();
        if (!tipoPagos.isEmpty()) {
            response = new TipoPagoResponse(tipoPagos, "Obtención de todas los TipoPagos", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new TipoPagoResponse("No se encontraron TipoPagos", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> newTipoPago(TipoPago tipoPago) {
        this.tipoPagoRepository.save(tipoPago);
        response = new TipoPagoResponse(tipoPago, "Se pudo crear la TipoPago", 200, true);
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    } //close method

    public ResponseEntity<Object> updateTipoPago(Long id, TipoPago tipoPago) {
        if (tipoPagoRepository.findById(id).isPresent()) {
            TipoPago existingTipoPago = tipoPagoRepository.findById(id).get();
            existingTipoPago.setNombre(tipoPago.getNombre());
            existingTipoPago.setDescripcion(tipoPago.getDescripcion());
            tipoPagoRepository.save(existingTipoPago);
            response = new TipoPagoResponse(existingTipoPago, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new TipoPagoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> eliminar(Long id) {
        //Verificar si esta vacio
        if (!this.tipoPagoRepository.findById(id).isEmpty()) {
            this.tipoPagoRepository.deleteById(id);
            response = new TipoPagoResponse("Si se pudo eliminar el ID :" + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new TipoPagoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);

        }
    } //close method

    public ResponseEntity<Object> getOne(Long id) {
        if (tipoPagoRepository.findById(id).isPresent()) {
            TipoPago tipoPago = tipoPagoRepository.findById(id).get();
            response = new TipoPagoResponse(tipoPago, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new TipoPagoResponse("No existe la TipoPago con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method
} //close method
