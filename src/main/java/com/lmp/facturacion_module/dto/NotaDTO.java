package com.lmp.facturacion_module.dto;

import com.lmp.facturacion_module.model.DetalleNota;
import com.lmp.facturacion_module.model.Factura;
import com.lmp.facturacion_module.model.Nota;
import com.lmp.facturacion_module.model.enums.TipoNota;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotaDTO extends ComprobanteDTO{
    private Long id;
    private TipoNota tipo;
    private String numeroNota;
    private LocalDateTime fechaEmision;
    private String motivo;
    private FacturaDTO factura;
    private List<DetalleNota> detalles = new ArrayList<>();
    private BigDecimal importeTotal;


    public static NotaDTO fromNota(Nota nota) {
        return NotaDTO.builder()
                .id(nota.getId())
                .tipo(nota.getTipo())
                .numeroNota(nota.getNumeroNota())
                .fechaEmision(nota.getFechaEmision())
                .motivo(nota.getMotivo())
                .factura(FacturaDTO.filtro (nota.getFactura()))
                .detalles(nota.getDetalles())
                .importeTotal(nota.getImporteTotal())
                .build();


    }
}
