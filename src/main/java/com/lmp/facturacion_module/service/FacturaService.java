package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.model.Factura;
import com.lmp.facturacion_module.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaService implements ComprobanteService<Factura> {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public Factura getComprobanteById(Long id) {
        return null;
    }

    @Override
    public Factura getComprobanteByName(String nombre) {
        return null;
    }

    @Override
    public Factura getComprobanteByCuit(String cuit) {
        return null;
    }

    @Override
    public ArrayList<Factura> getComprobantesByCuit(String cuit) {
        return null;
    }

    @Override
    public ArrayList<Factura> getComprobantesByNombre(String nombre) {
        return null;
    }

    @Override
    public List<FacturaDTO> getAll() {
        return facturaRepository.findAll()
                 .stream()
                 .map(FacturaDTO::fromFactura)
                 .collect(Collectors.toList());



    }


}
