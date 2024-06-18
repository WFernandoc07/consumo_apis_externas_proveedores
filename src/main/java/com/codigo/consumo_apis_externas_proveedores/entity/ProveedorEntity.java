package com.codigo.consumo_apis_externas_proveedores.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "proveedores")
@Getter
@Setter
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoDoc;
    private String numDoc;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String contactoPrincipal;
    private String tipoProveedor;
    private String procedencia;
    private int estado;
    private Timestamp fechaRegistro;
    private String usuaRegistro;
    private Timestamp fechaActualizacion;
    private String usuaActualizacion;
    private Timestamp fechaEliminacion;
    private String usuaEliminacion;

}
