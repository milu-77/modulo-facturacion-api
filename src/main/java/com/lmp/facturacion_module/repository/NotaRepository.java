package com.lmp.facturacion_module.repository;

import com.lmp.facturacion_module.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Long> {
}
