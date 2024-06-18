package com.codigo.consumo_apis_externas_proveedores.controller;

import com.codigo.consumo_apis_externas_proveedores.constants.Constantes;
import com.codigo.consumo_apis_externas_proveedores.request.ProveedorRequest;
import com.codigo.consumo_apis_externas_proveedores.response.ResponseBase;
import com.codigo.consumo_apis_externas_proveedores.service.ProveedorService;
import io.netty.util.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/proveedor")
public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping
    public ResponseEntity<ResponseBase> crearProveedor(@RequestBody ProveedorRequest proveedorRequest){
        ResponseBase responseBase = proveedorService.crearProveedor(proveedorRequest);
        if (responseBase.getCode() == Constantes.CODGO_EXITO){
            return ResponseEntity.ok(responseBase);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBase);
        }
    }

    @GetMapping("/{numDoc}")
    public ResponseEntity<ResponseBase> getProveedor(@PathVariable String numDoc){
        ResponseBase responseBase = proveedorService.getProveedor(numDoc);
        if (responseBase.getCode() == Constantes.CODGO_EXITO){
            return ResponseEntity.ok(responseBase);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBase);
        }
    }

    @DeleteMapping("/{numDoc}")
    public ResponseEntity<ResponseBase> deleteProveedor(@PathVariable String numDoc){
        proveedorService.deleteProveedor(numDoc);
        return ResponseEntity.ok(new ResponseBase(Constantes.CODGO_EXITO, Constantes.MENSAJE_EXITO_DELETE, Optional.empty()));
    }
}
