package com.lmp.facturacion_module.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemFacturaDTO {
    @NotBlank(message = "el codigo es obligatorio")
    private String codigo;          // Código interno del producto/servicio

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;     // Descripción detallada
    @DecimalMin(value = "0.01", message = "El importe debe ser mayor a 0")

    private BigDecimal precio;      // Precio unitario (siempre usar BigDecimal para dinero)

    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Double cantidad;        // Cantidad (puede ser entero o decimal)

    @DecimalMin(value = "0.01", message = "El IVA debe ser mayor a 0")
    private BigDecimal iva;         // % de IVA (ej: 21, 10.5)
}
