package com.lmp.facturacion_module.model;

import com.lmp.facturacion_module.model.enums.TipoComprobante;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public   class Factura implements Comprobante{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String puntoVenta;
    private String numeroComprobante;
    private LocalDate fechaEmision;
    private BigDecimal importeTotal;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private TipoComprobante tipo;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<ItemFactura> items;

}
