package com.codigo.consumo_apis_externas_proveedores.service;

import com.codigo.consumo_apis_externas_proveedores.request.ProveedorRequest;
import com.codigo.consumo_apis_externas_proveedores.response.ResponseBase;

public interface ProveedorService {
    ResponseBase crearProveedor(ProveedorRequest proveedorRequest);

    ResponseBase getProveedor(String numDoc);
    void deleteProveedor(String numDoc);
}
