package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.model.Factura;

import java.util.ArrayList;

public class FacturaService implements ComprobanteService<Factura> {
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



}
