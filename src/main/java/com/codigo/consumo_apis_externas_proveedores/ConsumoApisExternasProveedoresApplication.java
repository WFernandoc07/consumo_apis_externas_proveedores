package com.codigo.consumo_apis_externas_proveedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumoApisExternasProveedoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApisExternasProveedoresApplication.class, args);
	}

}
