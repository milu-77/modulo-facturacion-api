package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.model.Nota;

import java.util.ArrayList;

public class NotaService implements ComprobanteService<Nota>{
    @Override
    public Nota getComprobanteById(Long id) {
        return null;
    }

    @Override
    public Nota getComprobanteByName(String nombre) {
        return null;
    }

    @Override
    public Nota getComprobanteByCuit(String cuit) {
        return null;
    }

    @Override
    public ArrayList<Nota> getComprobantesByCuit(String cuit) {
        return null;
    }

    @Override
    public ArrayList<Nota> getComprobantesByNombre(String nombre) {
        return null;
    }
}
