package com.codigo.consumo_apis_externas_proveedores.service.impl;

import com.codigo.consumo_apis_externas_proveedores.clients.ClientSunat;
import com.codigo.consumo_apis_externas_proveedores.constants.Constantes;
import com.codigo.consumo_apis_externas_proveedores.dao.ProveedorRepository;
import com.codigo.consumo_apis_externas_proveedores.entity.ProveedorEntity;
import com.codigo.consumo_apis_externas_proveedores.redis.RedisService;
import com.codigo.consumo_apis_externas_proveedores.request.ProveedorRequest;
import com.codigo.consumo_apis_externas_proveedores.response.ResponseBase;
import com.codigo.consumo_apis_externas_proveedores.response.ResponseSunat;
import com.codigo.consumo_apis_externas_proveedores.service.ProveedorService;
import com.codigo.consumo_apis_externas_proveedores.util.Util;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Constants;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {
    private final ProveedorRepository proveedorRepository;
    private final ClientSunat clientSunat;
    private final RedisService redisService;

    @Value("${token.api}")
    private String tokenApi;


    @Override
    public ResponseBase crearProveedor(ProveedorRequest proveedorRequest) {
        ProveedorEntity proveedorEntity = getEntity(proveedorRequest);
        if(proveedorEntity != null){
            proveedorRepository.save(proveedorEntity);
            return new ResponseBase(Constantes.CODGO_EXITO, Constantes.MENSAJE_EXITO, Optional.of(proveedorEntity));
        }else{
            return new ResponseBase(Constantes.CODGO_ERROR, Constantes.MENSAJE_ERROR, Optional.empty());
        }
    }


    @Override
    public ResponseBase getProveedor(String numDoc) {
        String redisInfo = redisService.getFromRedis(Constantes.REDIS_KEY_GUARDAR+numDoc);
        if(redisInfo != null){
            ProveedorEntity proveedor = Util.convertirDesdeString(redisInfo, ProveedorEntity.class);
            return new ResponseBase(Constantes.CODGO_EXITO, Constantes.MENSAJE_EXITO_DESDE_REDIS, Optional.of(proveedor));
        }else{
            ProveedorEntity proveedor = proveedorRepository.findByNumDoc(numDoc);
            String dataParaRedis = Util.convertirAString(proveedor);
            redisService.saveInRedis(Constantes.REDIS_KEY_GUARDAR+numDoc, dataParaRedis,2);
            return new ResponseBase(Constantes.CODGO_EXITO, Constantes.MENSAJE_EXITO_DESDE_BD, Optional.of(proveedor));
        }
    }

    @Override
    public void deleteProveedor(String numDoc) {
        redisService.deleteKey(Constantes.REDIS_KEY_GUARDAR+numDoc);
    }

    private ResponseSunat getExecutionSunat(String ruc){
        String auth = "Bearer " + tokenApi;
        ResponseSunat sunat = clientSunat.getInfoSunat(ruc, auth);
        return sunat;
    }

    private ProveedorEntity getEntity(ProveedorRequest proveedorRequest){
        ProveedorEntity proveedorEntity = new ProveedorEntity();
        ResponseSunat responseSunat = getExecutionSunat(proveedorRequest.getRuc());
        if(responseSunat != null){
            proveedorEntity.setNombre(responseSunat.getRazonSocial());
            proveedorEntity.setDireccion(responseSunat.getDireccion());
            proveedorEntity.setTipoDoc(responseSunat.getTipoDocumento());
            proveedorEntity.setNumDoc(responseSunat.getNumeroDocumento());
            proveedorEntity.setUsuaRegistro(Constantes.AUDIT_ADMIN);
            proveedorEntity.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
            return proveedorEntity;
        }else {
            return null;
        }
    }
}
