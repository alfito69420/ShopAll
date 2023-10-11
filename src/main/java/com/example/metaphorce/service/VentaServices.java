package com.example.metaphorce.service;
import com.example.metaphorce.domain.TiendaResponse;
import com.example.metaphorce.domain.VentaResponse;
import com.example.metaphorce.domain.VentaResponse;
import com.example.metaphorce.model.Venta;
import com.example.metaphorce.model.Venta;
import com.example.metaphorce.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaServices {
    private final VentaRepository ventaRepository;
    VentaResponse response;
    @Autowired
    public VentaServices(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    public ResponseEntity<Object> getVenta(){
        List<Venta> ventas = ventaRepository.findAll();
        if (!ventas.isEmpty()) {
            response = new VentaResponse(ventas, "Obtención de todas las tiendas", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new VentaResponse("No se encontraron tiendas", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getOne(Long id){
        if (ventaRepository.findById(id).isPresent()) {
            Venta venta = ventaRepository.findById(id).get();
            response = new VentaResponse(venta, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new VentaResponse("No existe la tienda con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

    public  ResponseEntity<Object> newVenta(Venta venta) {
        this.ventaRepository.save(venta);
        response = new VentaResponse(venta, "Se pudo crear la venta",200,true );
        return new ResponseEntity<>(response.response(), HttpStatus.OK);


    };

    /*

    public  ResponseEntity<Object> updateTienda(Integer id, Venta tienda) {
        if (tiendaRepository.findById(id).isPresent()) {
            Venta existingTienda = tiendaRepository.findById(id).get();
            existingTienda.setNombre(tienda.getNombre());
            existingTienda.setDescripcion(tienda.getDescripcion());
            tiendaRepository.save(existingTienda);
            response = new VentaResponse(existingTienda, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new VentaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    };

    public ResponseEntity<Object>  eliminar(Integer id){
        //Verificar si esta vacio
        if(!this.ventaRepository.findById(id).isEmpty()){
            this.ventaRepository.deleteById(id);
            response = new TiendaResponse("Si se pudo eliminar el ID:",200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new TiendaResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    
     */
}
