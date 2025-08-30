package com.lmp.facturacion_module.dto.request;

import com.lmp.facturacion_module.model.Cliente;
import com.lmp.facturacion_module.model.ItemFactura;
import com.lmp.facturacion_module.model.enums.TipoComprobante;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
public class CrearFacturaDTO {
    @NotBlank(message = "El Punto de venta  es obligatorio")
    private String puntoVenta;
    @NotBlank(message = "El Numero de Comprobante  es obligatorio")
    private String numeroComprobante;
    @NotNull(message = "La Fecha de Emisión es obligatoria")
    private LocalDate fechaEmision;
    @NotNull (message = "El importe Total  es obligatorio")
    @DecimalMin(value = "0.01", message = "El importe debe ser mayor a 0")
    private BigDecimal importeTotal;
    @NotNull (message = "El IdCliente es obligatorio")
    @Min(value = 1, message = "El ID del cliente debe ser mayor a 0")
    private Long idCliente;
    @NotNull (message = "El tipo  es obligatorio")
    private TipoComprobante tipo;
    @NotEmpty(message = "La factura debe tener al menos un item")
    @Valid // ← Para validar cada item de la lista
    private List<ItemFacturaDTO> items;


}
