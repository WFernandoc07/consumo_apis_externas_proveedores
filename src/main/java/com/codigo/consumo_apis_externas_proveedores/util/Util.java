package com.codigo.consumo_apis_externas_proveedores.util;

import com.codigo.consumo_apis_externas_proveedores.entity.ProveedorEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
    // Aca voy a definir en que momento quiero utlizar redis
    public static String convertirAString(ProveedorEntity proveedor) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(proveedor);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    //Clase generica o clase universal
    public static <T> T convertirDesdeString(String json, Class<T> tipoClase){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, tipoClase);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
