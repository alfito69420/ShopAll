package com.example.metaphorce.service;

import com.example.metaphorce.domain.ProductoResponse;
import com.example.metaphorce.domain.TiendaResponse;
import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.model.Producto;
import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.model.TipoProducto;
import com.example.metaphorce.repository.CategoriaRepository;
import com.example.metaphorce.repository.ProductoRepository;
import com.example.metaphorce.repository.TiendaRepository;
import com.example.metaphorce.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Service
public class ProductoService   {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private  final TiendaRepository tiendaRepository;
    private  final TipoProductoRepository tipoProductoRepository;
    ProductoResponse response;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository, TipoProductoRepository tipoProductoRepository, TiendaRepository tiendaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository= categoriaRepository;
        this.tiendaRepository = tiendaRepository;
        this.tipoProductoRepository = tipoProductoRepository;
    }

    public ResponseEntity<Object> getProducto() {
        List<Producto> productos = productoRepository.findAll();
        if(!productos.isEmpty()){
            response = new ProductoResponse(productos,"Busqueda de todos los productos",200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }else {
            response = new ProductoResponse("No se encontraron registros de productos", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> newProducto(Producto producto) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(producto.getCategoria().getCategoria_id());
        Optional<TipoProducto> tipoOptional = tipoProductoRepository.findById(producto.getTipoProducto().getTipo_id());
        Optional<Tienda> tiendaOptional = tiendaRepository.findById(producto.getTienda().getTienda_id());

        if (categoriaOptional.isPresent() && tipoOptional.isPresent() && tiendaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            TipoProducto tipo = tipoOptional.get();
            Tienda tienda = tiendaOptional.get();

            producto.setCategoria(categoria);
            producto.setTipoProducto(tipo);
            producto.setTienda(tienda);

            productoRepository.save(producto);

            response = new ProductoResponse(producto, "Se creó con éxito", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            if (!categoriaOptional.isPresent()) {
                response = new ProductoResponse("No existe la Categoría con el ID: " + producto.getCategoria().getCategoria_id(), 400, false);
                return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
            } else if (!tipoOptional.isPresent()) {
                response = new ProductoResponse("No existe el Tipo con el ID: " + producto.getTipoProducto().getTipo_id(), 400, false);
                return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
            } else {
                response = new ProductoResponse("No existe la Tienda con el ID: " + producto.getTienda().getTienda_id(), 400, false);
                return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
            }
        }
    }

    public ResponseEntity<Object> updateProducto( Long id,  Producto updatedProducto) {
        Optional<Producto> existingProductoOptional = productoRepository.findById(id);

        if (existingProductoOptional.isPresent()) {
            Producto existingProducto = existingProductoOptional.get();
            Optional<Categoria> categoriaOptional = categoriaRepository.findById(updatedProducto.getCategoria().getCategoria_id());
            Optional<TipoProducto> tipoOptional = tipoProductoRepository.findById(updatedProducto.getTipoProducto().getTipo_id());
            Optional<Tienda> tiendaOptional = tiendaRepository.findById(updatedProducto.getTienda().getTienda_id());

            if (categoriaOptional.isPresent() && tipoOptional.isPresent() && tiendaOptional.isPresent()) {
                Categoria categoria = categoriaOptional.get();
                TipoProducto tipo = tipoOptional.get();
                Tienda tienda = tiendaOptional.get();

                existingProducto.setCategoria(categoria);
                existingProducto.setTipoProducto(tipo);
                existingProducto.setTienda(tienda);
                existingProducto.setNombre(updatedProducto.getNombre());
                existingProducto.setDescripcion(updatedProducto.getDescripcion());
                existingProducto.setPhoto(updatedProducto.getPhoto());
                existingProducto.setPrecio(updatedProducto.getPrecio());
                existingProducto.setCantidad(updatedProducto.getCantidad());

                productoRepository.save(existingProducto);

                response = new ProductoResponse(existingProducto, "Se actualizó con éxito", 200, true);
                return new ResponseEntity<>(response.response(), HttpStatus.OK);
            } else {
                if (!categoriaOptional.isPresent()) {
                    response = new ProductoResponse("No existe la Categoría con el ID: " + updatedProducto.getCategoria().getCategoria_id(), 400, false);
                    return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
                } else if (!tipoOptional.isPresent()) {
                    response = new ProductoResponse("No existe el Tipo con el ID: " + updatedProducto.getTipoProducto().getTipo_id(), 400, false);
                    return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
                } else {
                    response = new ProductoResponse("No existe la Tienda con el ID: " + updatedProducto.getTienda().getTienda_id(), 400, false);
                    return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            response = new ProductoResponse("No existe el Producto con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> eliminar(Integer id) {
        //Verificar si esta vacio
        if (!this.productoRepository.findById(Long.valueOf(id)).isEmpty()) {
            this.productoRepository.deleteById(Long.valueOf(id));
            response = new ProductoResponse("Si se pudo eliminar el ID:", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ProductoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        if (productoRepository.findById(Long.valueOf(id)).isPresent()) {
            Producto producto = productoRepository.findById(Long.valueOf(id)).get();
            response = new ProductoResponse(producto, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ProductoResponse("No existe la producto con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
