package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.model.Cliente;
import com.lmp.facturacion_module.model.Comprobante;
import jakarta.persistence.Entity;

import java.util.ArrayList;

public interface ComprobanteService <T extends Comprobante>{
    T getComprobanteById(Long id);
    T getComprobanteByName(String nombre);
    T getComprobanteByCuit(String cuit);
    ArrayList<T> getComprobantesByCuit(String cuit);
    ArrayList<T> getComprobantesByNombre(String nombre);

}
