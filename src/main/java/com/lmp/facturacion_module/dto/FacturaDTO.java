package com.lmp.facturacion_module.dto;

import com.lmp.facturacion_module.model.Cliente;
import com.lmp.facturacion_module.model.Factura;
import com.lmp.facturacion_module.model.ItemFactura;
import com.lmp.facturacion_module.model.enums.TipoComprobante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacturaDTO extends ComprobanteDTO   {

    private Long id;

    private String puntoVenta;
    private String numeroComprobante;
    private LocalDate fechaEmision;
    private BigDecimal importeTotal;
      private TipoComprobante tipo;
     private List<ItemFactura> items;

    public static FacturaDTO fromFactura(Factura factura){
        if(factura == null) return null;
        return FacturaDTO.builder()
                .id(factura.getId())
                .puntoVenta(factura.getPuntoVenta())
                .fechaEmision(factura.getFechaEmision())
                .numeroComprobante(factura.getNumeroComprobante())
                .importeTotal(factura.getImporteTotal())
                 .tipo(factura.getTipo())
                .items(factura.getItems())
                .build();
    }

    public static FacturaDTO filtro(Factura factura) {
        return FacturaDTO.fromFactura(factura);
    }
}
