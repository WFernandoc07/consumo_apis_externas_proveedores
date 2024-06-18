package com.codigo.consumo_apis_externas_proveedores.constants;

public class Constantes {
    public static final Integer CODGO_EXITO=2000;
    public static final Integer CODGO_ERROR=2005;

    public static final String MENSAJE_EXITO="Proveedor insertado correctamente";
    public static final String MENSAJE_EXITO_DESDE_BD="Proveedor encontrado en BD";
    public static final String MENSAJE_EXITO_DESDE_REDIS="Proveedor encontrado en REDIS";
    public static final String MENSAJE_EXITO_DELETE="Proveedor eliminado de REDIS";
    public static final String MENSAJE_ERROR="Ocurrió un error en la transacción";

    public static final String AUDIT_ADMIN="WILLIAMFC";

    public static final String REDIS_KEY_GUARDAR="API:CONSUMO:API:EXTERNA:";
}
