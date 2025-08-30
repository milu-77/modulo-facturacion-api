package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.dto.NotaDTO;
import com.lmp.facturacion_module.dto.request.CrearNotaDTO;
import com.lmp.facturacion_module.model.Nota;
import com.lmp.facturacion_module.model.enums.TipoNota;
import com.lmp.facturacion_module.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NotaService implements ComprobanteService<NotaDTO>{

    @Autowired
    NotaRepository notaRepository;

    @Override
    public  NotaDTO  getComprobanteById(Long id) {
        return null;
    }

    @Override
    public List<NotaDTO> getComprobanteByCliente(Long id) {
        return notaRepository.findAll()
                .stream()
                .filter(nota -> Objects.equals(nota.getFactura().getCliente().getId(), id))
                .map(NotaDTO::fromNota)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotaDTO> getComprobantesByCuit(String cuit) {
        return notaRepository.findAll()
                .stream()
                .filter(nota -> Objects.equals(nota.getFactura().getCliente().getCuit(), cuit))
                .map(NotaDTO::fromNota)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotaDTO> getComprobantesByRazonSocial(String razon) {
        return notaRepository.findAll()
                .stream()
                .filter(nota -> Objects.equals(nota.getFactura().getCliente().getRazonSocial(), razon))
                .map(NotaDTO::fromNota)
                .collect(Collectors.toList());
    }

    public List<NotaDTO> getAll()   {
            return notaRepository.findAll()
                    .stream()
                    .map(NotaDTO::fromNota)
                    .collect(Collectors.toList());
        }


    public List<NotaDTO> getNotaDebitoByCliente(Long id) {
        return notaRepository.findAll()
                .stream()
                .filter(nota -> Objects.equals(nota.getTipo(), TipoNota.DEBITO)&& Objects.equals(nota.getFactura().getCliente().getId(), id)   )
                .map(NotaDTO::fromNota)
                .collect(Collectors.toList());

    }

    public List<NotaDTO> getNotaCreditoByCliente(Long id) {
        return notaRepository.findAll()
                .stream()
                .filter(nota -> Objects.equals(nota.getTipo(), TipoNota.CREDITO)&& Objects.equals(nota.getFactura().getCliente().getId(), id)   )
                .map(NotaDTO::fromNota)
                .collect(Collectors.toList());
    }

    public ResponseEntity<?> addNota(CrearNotaDTO nota) {

        return null;
    }
}
