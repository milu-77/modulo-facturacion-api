package com.lmp.facturacion_module.Controller;

import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.dto.NotaDTO;
import com.lmp.facturacion_module.service.FacturaService;
import com.lmp.facturacion_module.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
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






}
