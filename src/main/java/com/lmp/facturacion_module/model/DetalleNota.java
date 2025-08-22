package com.lmp.facturacion_module.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
class DetalleNota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nota_id")
    private Nota nota;
    private String codigo;          // Código interno del producto/servicio
    private String descripcion;     // Descripción detallada
    private BigDecimal precio;      // Precio unitario (siempre usar BigDecimal para dinero)

}
