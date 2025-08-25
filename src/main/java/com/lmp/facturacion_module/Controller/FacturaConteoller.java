package com.lmp.facturacion_module.Controller;

import com.lmp.facturacion_module.dto.ClienteDTO;
import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.service.ClienteService;
import com.lmp.facturacion_module.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturas")  // Ruta base para todos los endpoints
public class FacturaConteoller {
    @Autowired
    private FacturaService facturaService;


    @GetMapping
    public List<FacturaDTO> getAllClientes() {
        return facturaService.getAll();
    }



}
