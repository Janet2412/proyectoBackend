package com.proyecto.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.proyecto.commons.controllers","com.proyecto.clientes"})
@EntityScan({"com.proyecto.commons.models.entities"})
public class ClientesApplication {

	public static void main (String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
		

	}

}
