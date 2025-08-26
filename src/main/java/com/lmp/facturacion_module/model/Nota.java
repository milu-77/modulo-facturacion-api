package com.lmp.facturacion_module.model;

import com.lmp.facturacion_module.model.enums.TipoComprobante;
import com.lmp.facturacion_module.model.enums.TipoNota;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "nota")
public class Nota implements Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoNota tipo;

    @Column(unique = true, nullable = false)
    private String numeroNota;

    @Column(nullable = false)
    private LocalDateTime fechaEmision;

    @Column(length = 500)
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;

    @OneToMany(mappedBy = "nota", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleNota> detalles = new ArrayList<>();

    private BigDecimal importeTotal;


}
