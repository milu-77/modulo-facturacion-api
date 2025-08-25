package com.lmp.facturacion_module.Controller;

import com.lmp.facturacion_module.dto.ClienteDTO;
import com.lmp.facturacion_module.model.Cliente;
import com.lmp.facturacion_module.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")  // Ruta base para todos los endpoints
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteService.getAllClientes();
    }
    @GetMapping("/{id}")
    public ClienteDTO getUserID(@PathVariable Long id) {
        return clienteService.getByID(id);
    }

    @GetMapping( "/buscar")
    public ClienteDTO getUserByCUIT(
        @RequestParam(required = false) String cuit,
        @RequestParam(required = false) String razonSocial) {
            if (cuit != null) {
                return clienteService.getByCUIT(cuit);
            } else if (razonSocial != null) {
                return clienteService.getByRazonSocial(razonSocial);
            } else {
                throw new IllegalArgumentException("Debe proporcionar CUIT o razón social");
            }
    }
}
