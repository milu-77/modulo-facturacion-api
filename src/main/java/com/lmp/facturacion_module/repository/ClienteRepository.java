package com.lmp.facturacion_module.repository;

import com.lmp.facturacion_module.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente getReferenceByCuit(String cuit);

    Cliente getReferenceByRazonSocial(String razonSocial);
}
