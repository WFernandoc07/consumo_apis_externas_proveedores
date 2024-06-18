package com.codigo.consumo_apis_externas_proveedores.clients;

import com.codigo.consumo_apis_externas_proveedores.response.ResponseSunat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-sunat", url = "https://api.apis.net.pe/v2/sunat")
public interface ClientSunat {

    @GetMapping("/ruc/full")
    ResponseSunat getInfoSunat(@RequestParam("numero") String numero,
                               @RequestHeader("Authorization") String Authorization);
}
