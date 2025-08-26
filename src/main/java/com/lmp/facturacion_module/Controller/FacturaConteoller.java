package com.lmp.facturacion_module.Controller;

import com.lmp.facturacion_module.dto.ClienteDTO;
import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.service.ClienteService;
import com.lmp.facturacion_module.service.FacturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/cliente")
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

//    @PostMapping
//     public ResponseEntity<?> crear(
//            @Valid
//            @RequestBody
//            FacturaDTO producto )
//    {
//        try{
//            Optional<Producto> productoGuardado = productoService.guardar(producto);
//            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                    .path("/{id}")
//                    .buildAndExpand(productoGuardado.get().getId())
//                    .toUri();
//            return ResponseEntity.created(location).body(new AcceptResponse(HttpStatus.CREATED.value(), "Producto Agregado"));
//        } catch (Exception e) {
//            return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));
//        }
//    }


}
