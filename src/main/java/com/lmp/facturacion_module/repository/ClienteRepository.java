package com.lmp.facturacion_module.repository;

import com.lmp.facturacion_module.dto.request.CrearClienteDTO;
import com.lmp.facturacion_module.model.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente getReferenceByCuit(String cuit);

    Cliente getReferenceByRazonSocial(String razonSocial);

    boolean existsByCuitAndRazonSocial( String cuit,  String razonSocial);

    boolean existsByCuitOrRazonSocial(@NotBlank(message = "El CUIT es obligatorio") String cuit, @NotBlank(message = "La Razon Social es obligatorio") String razonSocial);
}
