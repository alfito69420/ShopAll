package com.example.metaphorce.service;
import com.example.metaphorce.domain.VentaResponse;
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

    

    public  ResponseEntity<Object> updateVenta(Long id, Venta venta) {
        if (ventaRepository.findById(id).isPresent()) {
            Venta existingVenta = ventaRepository.findById(id).get();
            existingVenta.setTipo_pago_id(venta.getTipo_pago_id());
            existingVenta.setUsuario_id(venta.getUsuario_id());
            ventaRepository.save(existingVenta);
            response = new VentaResponse(existingVenta, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new VentaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    };

    public ResponseEntity<Object>  eliminar(Long id){
        //Verificar si esta vacio
        if(!this.ventaRepository.findById(id).isEmpty()){
            this.ventaRepository.deleteById(id);
            response = new VentaResponse("Si se pudo eliminar el ID:"+id,200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new VentaResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    
    
}
