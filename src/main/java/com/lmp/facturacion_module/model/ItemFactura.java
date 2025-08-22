package com.lmp.facturacion_module.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "items_factura")
@Getter
@Setter
@NoArgsConstructor
public class ItemFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;          // Código interno del producto/servicio
    private String descripcion;     // Descripción detallada
    private BigDecimal precio;      // Precio unitario (siempre usar BigDecimal para dinero)
    private Double cantidad;        // Cantidad (puede ser entero o decimal)

    @Column(name = "porcentaje_iva")
    private BigDecimal iva;         // % de IVA (ej: 21, 10.5)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id")
    private Factura factura;        // Relación con la factura padre

    // --- Campos calculados (no se persisten) ---
    @Transient
    public BigDecimal getSubtotal() {
        return precio.multiply(BigDecimal.valueOf(cantidad));
    }

    @Transient
    public BigDecimal getImporteIva() {
        return getSubtotal().multiply(iva).divide(BigDecimal.valueOf(100));
    }

    @Transient
    public BigDecimal getTotal() {
        return getSubtotal().add(getImporteIva());
    }
}