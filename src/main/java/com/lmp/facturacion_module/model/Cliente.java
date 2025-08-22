package com.lmp.facturacion_module.model;

import com.lmp.facturacion_module.model.enums.CondicionDeVenta;
import com.lmp.facturacion_module.model.enums.CondicionIVA;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "facturas")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Factura> facturas = new ArrayList<>();
    private String cuit;
    private String razonSocial;
    private String domicilio;
    private String telefono;
    private String mail;
    @Enumerated(EnumType.STRING)
    private CondicionIVA condicionIVA;
    @Enumerated(EnumType.STRING)
    private CondicionDeVenta condicionDeVenta;


}
