package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.model.Comprobante;

import java.util.ArrayList;
import java.util.List;

public interface ComprobanteService <T extends Comprobante>{
    T getComprobanteById(Long id);
    T getComprobanteByName(String nombre);
    T getComprobanteByCuit(String cuit);
    ArrayList<T> getComprobantesByCuit(String cuit);
    ArrayList<T> getComprobantesByNombre(String nombre);
    List<FacturaDTO> getAll();
}
