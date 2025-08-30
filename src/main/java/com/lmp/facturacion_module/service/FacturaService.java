package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.dto.ClienteDTO;
import com.lmp.facturacion_module.dto.ComprobanteDTO;
import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.dto.request.CrearFacturaDTO;
import com.lmp.facturacion_module.exception.ClienteServiceException;
import com.lmp.facturacion_module.model.Factura;
import com.lmp.facturacion_module.repository.FacturaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FacturaService implements ComprobanteService<FacturaDTO> {

    @Autowired
    FacturaRepository facturaRepository;

    public ResponseEntity<?> addFactura(@Valid CrearFacturaDTO factura) {
        if (facturaRepository.existsByNumeroComprobante(factura.getNumeroComprobante())) {
            throw new ClienteServiceException("Cliente ya dado de alta");
        }
        System.out.println("FACTURA AGREGADO ");
        return null;


    }


    public List<FacturaDTO> getAll() {
        return facturaRepository.findAll()
                .stream()
                .map(FacturaDTO::fromFactura)
                .collect(Collectors.toList());
    }

    @Override
    public List<FacturaDTO> getComprobantesByRazonSocial(String razonSocial) {
        return facturaRepository.findAll()
                .stream()
                .filter(factura -> Objects.equals(factura.getCliente().getRazonSocial(), razonSocial))
                .map(FacturaDTO::fromFactura)
                .collect(Collectors.toList());
    }

    @Override
    public FacturaDTO getComprobanteById(Long id) {
        return FacturaDTO.fromFactura(facturaRepository.getReferenceById(id));
    }

    @Override
    public List<FacturaDTO> getComprobanteByCliente(Long id) {
        return facturaRepository.findAll()
                .stream()
                .filter(factura -> Objects.equals(factura.getCliente().getId(), id))
                .map(FacturaDTO::fromFactura)
                .collect(Collectors.toList());
    }

    @Override
    public List<FacturaDTO> getComprobantesByCuit(String cuit) {
        return facturaRepository.findAll()
                .stream()
                .filter(factura -> Objects.equals(factura.getCliente().getCuit(), cuit))
                .map(FacturaDTO::fromFactura)
                .collect(Collectors.toList());
    }


}
