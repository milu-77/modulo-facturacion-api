package com.lmp.facturacion_module.Controller;

import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.dto.NotaDTO;
import com.lmp.facturacion_module.dto.request.CrearClienteDTO;
import com.lmp.facturacion_module.dto.request.CrearNotaDTO;
import com.lmp.facturacion_module.exception.ClienteServiceException;
import com.lmp.facturacion_module.exception.ErrorResponse;
import com.lmp.facturacion_module.service.FacturaService;
import com.lmp.facturacion_module.service.NotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<NotaDTO> getAllNotas() {
        return notaService.getAll();
    }

    @GetMapping("/{id}")
    public NotaDTO getNotaID(@PathVariable Long id) {
        return notaService.getComprobanteById(id);
    }

    @GetMapping("/cliente/{id}")
    public List<NotaDTO> getNotaByID(@PathVariable Long id) {
        return notaService.getComprobanteByCliente(id);
    }

    @GetMapping("/cliente/{id}/credito")
    public List<NotaDTO> getNotaCreditoByID(@PathVariable Long id) {
        return notaService.getNotaCreditoByCliente(id);
    }

    @GetMapping("/cliente/{id}/debito")
    public List<NotaDTO> getNotaDebitoByID(@PathVariable Long id) {
        return notaService.getNotaDebitoByCliente(id);
    }

    @GetMapping("/cliente")
    public List<NotaDTO> getUserByCUIT(
            @RequestParam(required = false) String cuit,
            @RequestParam(required = false) String razonSocial) {
        if (cuit != null) {
            return notaService.getComprobantesByCuit(cuit);
        } else if (razonSocial != null) {
            return notaService.getComprobantesByRazonSocial(razonSocial);
        } else {
            throw new IllegalArgumentException("Debe proporcionar CUIT o razón social");
        }
    }

    @PostMapping
    public ResponseEntity<?> crearCliente(@Valid
                                          @RequestBody
                                          CrearNotaDTO nota) {
        try{
            ;
            return notaService.addNota(nota);
        }  catch (ClienteServiceException e) {
            // Manejar la excepción específica
            return  ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.getMessage()));

        }
    }





}
