package com.example.metaphorce.service;

import com.example.metaphorce.domain.VentaDetalleResponse;
import com.example.metaphorce.model.Producto;
import com.example.metaphorce.model.Venta;
import com.example.metaphorce.model.VentaDetalle;
import com.example.metaphorce.repository.ProductoRepository;
import com.example.metaphorce.repository.VentaDetalleRepository;
import com.example.metaphorce.repository.VentaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaDetalleService {

    private final VentaDetalleRepository ventaDetalleRepository;
    private VentaDetalleResponse ventaDetalleResponse;

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaDetalleService.class);

    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public VentaDetalleService(final VentaDetalleRepository pVentaDetalleRepository, final VentaRepository pVentaRepository,
                               final ProductoRepository pProductoRepository) {
        this.ventaDetalleRepository = pVentaDetalleRepository;
        this.ventaRepository = pVentaRepository;
        this.productoRepository = pProductoRepository;
    }

    //  GET ALL VENTA DETALLE RECORDS
    public ResponseEntity<Object> getVentaDetalle() {
        List<VentaDetalle> ventaDetalleList = ventaDetalleRepository.findAll();

        //
        LOGGER.info(String.valueOf(ventaDetalleList));

        if (!ventaDetalleList.isEmpty()) {
            ventaDetalleResponse = new VentaDetalleResponse(ventaDetalleList,
                    "Obtención de todas los registros del detalle de la venta", 200, true);
            return new ResponseEntity<>(ventaDetalleResponse.response2(), HttpStatus.OK);
        } else {
            ventaDetalleResponse = new VentaDetalleResponse(
                    "No se encontraron registros del detalle de todas las ventas", 400, false);
            return new ResponseEntity<>(ventaDetalleResponse.response2(), HttpStatus.OK);
        }
    } //close method

    //  INSERT A NEW VENTA DETALLE RECORD
    public ResponseEntity<Object> insertVentaDetalle(final VentaDetalle ventaDetalle) {
        Optional<Venta> ventaOptional = ventaRepository.findById(ventaDetalle.getVenta().getVenta_id());
        Optional<Producto> productoOptional = productoRepository.findById(ventaDetalle.getProducto().getProducto_id());

        if (ventaOptional.isPresent() && productoOptional.isPresent()) {
            Venta venta = ventaOptional.get();
            Producto producto = productoOptional.get();
            ventaDetalle.setVenta(venta);
            ventaDetalle.setProducto(producto);
            ventaDetalleRepository.save(ventaDetalle);

            ventaDetalleResponse = new VentaDetalleResponse(ventaDetalle, "Se pudo crear el detalle de venta",
                    200, true);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        } else {
            if (!ventaOptional.isPresent()) {
                ventaDetalleResponse = new VentaDetalleResponse("No existe la Venta con el ID: "
                        + ventaDetalle.getVenta().getVenta_id(), 400, false);
                return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.BAD_REQUEST);
            } else {
                if (!productoOptional.isPresent()) {
                    ventaDetalleResponse = new VentaDetalleResponse("No existe el Producto con el ID: "
                            + ventaDetalle.getProducto().getProducto_id(), 400, false);
                    return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.BAD_REQUEST);
                } else {
                    ventaDetalleResponse = new VentaDetalleResponse("ERROR al crear el detalle de venta",
                            500, false);
                    return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
    } // close method

    //  UPDATE A SPECIFIC VENTA DETALLE RECORD
    public ResponseEntity<Object> updateVentaDetalle(final Long id, final VentaDetalle ventaDetalle) {
        Optional<VentaDetalle> existingVentaDetalleOptional = ventaDetalleRepository.findById(id);

        if (existingVentaDetalleOptional.isPresent()) {
            VentaDetalle existingVentaDetalle = existingVentaDetalleOptional.get();

            // Verificar si la venta y el producto existen antes de actualizar
            Optional<Venta> ventaOptional = ventaRepository.findById(ventaDetalle.getVenta().getVenta_id());
            Optional<Producto> productoOptional = productoRepository.findById(ventaDetalle.getProducto().getProducto_id());

            if (ventaOptional.isPresent() && productoOptional.isPresent()) {
                Venta venta = ventaOptional.get();
                Producto producto = productoOptional.get();

                // Actualizar las relaciones y otros campos en el registro existente
                existingVentaDetalle.setVenta(venta);
                existingVentaDetalle.setProducto(producto);
                existingVentaDetalle.setCantidad(ventaDetalle.getCantidad());
                existingVentaDetalle.setPrecio(ventaDetalle.getPrecio());
                existingVentaDetalle.setSub_total(ventaDetalle.getSub_total());

                ventaDetalleRepository.save(existingVentaDetalle);

                ventaDetalleResponse = new VentaDetalleResponse(existingVentaDetalle,
                        "Se pudo actualizar el detalle de venta", 200, true);
                return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
            } else {
                if (!ventaOptional.isPresent()) {
                    ventaDetalleResponse = new VentaDetalleResponse("No existe la Venta con el ID: "
                            + ventaDetalle.getVenta().getVenta_id(), 400, false);
                    return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.BAD_REQUEST);
                } else {
                    if (!productoOptional.isPresent()) {
                        ventaDetalleResponse = new VentaDetalleResponse("No existe el Producto con el ID: "
                                + ventaDetalle.getProducto().getProducto_id(), 400, false);
                        return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.BAD_REQUEST);
                    } else {
                        ventaDetalleResponse = new VentaDetalleResponse("ERROR al actualizar el detalle de venta",
                                500, false);
                        return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
            }
        } else {
            ventaDetalleResponse = new VentaDetalleResponse("No existe el detalle de venta con el ID: " + id,
                    400, false);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.BAD_REQUEST);
        }
    } //close method

    //  DELETE A SPECIFIC VENTA DETALLE RECORD
    public ResponseEntity<Object> deleteVentaDetalle(final Long id) {
        if (!this.ventaDetalleRepository.findById(id).isEmpty()) {
            this.ventaDetalleRepository.deleteById(id);
            ventaDetalleResponse = new VentaDetalleResponse("Se ha eliminado el registro con el ID: "
                    + id, 200, true);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        } else {
            ventaDetalleResponse = new VentaDetalleResponse("No existe el registro con el ID: "
                    + id, 400, false);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        }
    } //close method

    //  GET JUST ONE VENTA DETALLE RECORD
    public ResponseEntity<Object> getOneVentaDetalle(final Long id) {
        if (ventaDetalleRepository.findById(id).isPresent()) {
            VentaDetalle ventaDetalle = ventaDetalleRepository.findById(id).get();
            ventaDetalleResponse = new VentaDetalleResponse(ventaDetalle, "Si encontró el ID: " + id,
                    200, true);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        } else {
            ventaDetalleResponse = new VentaDetalleResponse("No existe el detalle de la venta con el ID: " + id,
                    400, false);
            return new ResponseEntity<>(ventaDetalleResponse.response(), HttpStatus.OK);
        }
    } //close method
} //close class
