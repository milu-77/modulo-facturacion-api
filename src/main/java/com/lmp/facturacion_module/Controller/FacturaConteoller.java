package com.lmp.facturacion_module.Controller;

import com.lmp.facturacion_module.dto.ClienteDTO;
import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.service.ClienteService;
import com.lmp.facturacion_module.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public FacturaDTO getFacturaID(@PathVariable Long id) {
        return facturaService.getComprobanteById(id);
    }
    @GetMapping("/cliente/{id}")
    public List<FacturaDTO> getFacturasByID(@PathVariable Long id) {
        return facturaService.getComprobanteByCliente(id);
    }
    @GetMapping( "/cliente")
    public List<FacturaDTO> getUserByCUIT(
            @RequestParam(required = false) String cuit,
            @RequestParam(required = false) String razonSocial) {
        if (cuit != null) {
            return facturaService.getComprobantesByCuit(cuit);
        } else if (razonSocial != null) {
            return facturaService.getComprobantesByRazonSocial(razonSocial);
        } else {
            throw new IllegalArgumentException("Debe proporcionar CUIT o razón social");
        }
    }




}
