package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.dto.ComprobanteDTO;
import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.model.Comprobante;

import java.util.ArrayList;
import java.util.List;

public interface ComprobanteService<T extends ComprobanteDTO> {
     T   getComprobanteById(Long id);

    List<T>  getComprobanteByCliente(Long id);

    List<T>  getComprobantesByCuit(String cuit);

    List<T>  getComprobantesByRazonSocial(String razon);



}
