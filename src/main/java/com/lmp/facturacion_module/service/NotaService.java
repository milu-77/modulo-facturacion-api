package com.lmp.facturacion_module.service;

import com.lmp.facturacion_module.dto.FacturaDTO;
import com.lmp.facturacion_module.dto.NotaDTO;
import com.lmp.facturacion_module.model.Nota;

import java.util.ArrayList;
import java.util.List;

public class NotaService implements ComprobanteService<NotaDTO>{


    @Override
    public  NotaDTO  getComprobanteById(Long id) {
        return null;
    }

    @Override
    public List<NotaDTO> getComprobanteByCliente(Long id) {
        return null;
    }

    @Override
    public List<NotaDTO> getComprobantesByCuit(String cuit) {
        return null;
    }

    @Override
    public List<NotaDTO> getComprobantesByRazonSocial(String razon) {
        return null;
    }
}
