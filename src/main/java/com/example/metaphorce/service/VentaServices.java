package com.example.metaphorce.service;
import com.example.metaphorce.model.Venta;
import com.example.metaphorce.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaServices {
    private final VentaRepository ventaRepository;
    @Autowired
    public VentaServices(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> getVenta(){
        return ventaRepository.findAll();
    }

    public void newVenta(Venta venta) {
        this.ventaRepository.save(venta);
    };
}
