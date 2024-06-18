package com.codigo.consumo_apis_externas_proveedores.dao;

import com.codigo.consumo_apis_externas_proveedores.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
    ProveedorEntity findByNumDoc(String numDoc);
}
