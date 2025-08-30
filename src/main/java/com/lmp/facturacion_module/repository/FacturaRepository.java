package com.lmp.facturacion_module.repository;

import com.lmp.facturacion_module.model.Factura;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
    boolean existsByNumeroComprobante(String numeroComprobante);
}
