package com.lmp.facturacion_module.dto;

import com.lmp.facturacion_module.model.Cliente;
import com.lmp.facturacion_module.model.Factura;
import com.lmp.facturacion_module.model.enums.CondicionDeVenta;
import com.lmp.facturacion_module.model.enums.CondicionIVA;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
 public class ClienteDTO {
    private List<Factura> facturas = new ArrayList<>();
    private Long id;
    private String cuit;
    private String razonSocial;
    private String domicilio;
    private String telefono;
    private String mail;
     private CondicionIVA condicionIVA;
     private CondicionDeVenta condicionDeVenta;


    public static ClienteDTO fromCliente(Cliente cliente){
        if(cliente == null) return null;
        return ClienteDTO.builder()
                .id(cliente.getId())
                .cuit(cliente.getCuit())
                .razonSocial(cliente.getRazonSocial())
                .domicilio(cliente.getDomicilio())
                .telefono(cliente.getTelefono())
                .mail(cliente.getMail())
                .condicionIVA(cliente.getCondicionIVA())
                .condicionDeVenta(cliente.getCondicionDeVenta())
                .build();
   }
}
