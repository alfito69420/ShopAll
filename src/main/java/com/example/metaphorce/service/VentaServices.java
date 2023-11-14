package com.example.metaphorce.service;

import com.example.metaphorce.domain.VentaResponse;
import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.model.Venta;
import com.example.metaphorce.repository.TipoPagoRepository;
import com.example.metaphorce.repository.UserRepository;
import com.example.metaphorce.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VentaServices {
    private final VentaRepository ventaRepository;
    private final UserRepository userRepository;
    private final TipoPagoRepository tipoPagoRepository;
    private VentaResponse response;

    @Autowired
    public VentaServices(final VentaRepository pVentaRepository, final UserRepository pUserRepository, final TipoPagoRepository pTipoPagoRepository) {
        this.ventaRepository = pVentaRepository;
        this.userRepository = pUserRepository;
        this.tipoPagoRepository = pTipoPagoRepository;
    }

    public ResponseEntity<Object> getVenta() {
        List<Venta> ventas = ventaRepository.findAll();
        if (!ventas.isEmpty()) {
            response = new VentaResponse(ventas, "Obtención de todas las tiendas", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new VentaResponse("No se encontraron tiendas", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> getOne(final Long id) {
        if (ventaRepository.findById(id).isPresent()) {
            Venta venta = ventaRepository.findById(id).get();
            response = new VentaResponse(venta, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new VentaResponse("No existe la tienda con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> newVenta(final Venta venta) {
        Optional<UserEntity> usuarioOptional = userRepository.findById(venta.getUser().getUsuario_id());
        Optional<TipoPago> tipoPagoOptional = tipoPagoRepository.findById(venta.getTipoPago().getTipo_pago_id());

        if (usuarioOptional.isPresent() && tipoPagoOptional.isPresent()) {
            UserEntity usuario = usuarioOptional.get();
            TipoPago tipoPago = tipoPagoOptional.get();
            venta.setUser(usuario);
            venta.setTipoPago(tipoPago);
            ventaRepository.save(venta);

            response = new VentaResponse(venta, "Se pudo crear la venta", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            if (!usuarioOptional.isPresent()) {
                response = new VentaResponse("No existe el Usuario con el ID: " + venta.getUser().getUsuario_id(), 400, false);
                return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
            } else {
                if (!tipoPagoOptional.isPresent()) {
                    response = new VentaResponse("No existe el Tipo Pago con el ID: " + venta.getTipoPago().getTipo_pago_id(), 400, false);
                    return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
                } else {
                    response = new VentaResponse("ERROR al crear la venta", 500, false);
                    return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
                }
            }
        }
    } //close method

    public ResponseEntity<Object> updateVenta(final Long id, final Venta venta) {
        Optional<Venta> ventaOptional = ventaRepository.findById(id);

        if (ventaOptional.isPresent()) {
            Venta existingVenta = ventaOptional.get();

            if (venta.getTipoPago() != null) {
                existingVenta.setTipoPago(venta.getTipoPago());
            }
            if (venta.getUser() != null) {
                existingVenta.setUser(venta.getUser());
            }

            ventaRepository.save(existingVenta);

            Venta updatedVenta = ventaRepository.findById(id).orElse(null);

            if (updatedVenta != null) {
                response = new VentaResponse("Se pudo actualizar", 200, true);
                return new ResponseEntity<>(response.response(), HttpStatus.OK);
            } else {
                response = new VentaResponse("No se pudo obtener la venta actualizada", 500, false);
                return new ResponseEntity<>(response.response(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            response = new VentaResponse("No existe el ID: " + id, 404, false);
            return new ResponseEntity<>(response.response(), HttpStatus.NOT_FOUND);
        }
    } //close method

    public ResponseEntity<Object> eliminar(final Long id) {
        //Verificar si esta vacio
        if (!this.ventaRepository.findById(id).isEmpty()) {
            this.ventaRepository.deleteById(id);
            response = new VentaResponse("Si se pudo eliminar el ID:" + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new VentaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);

        }
    } //close method
} //close class
