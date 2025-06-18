package com.proyecto.clientes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.proyecto.clientes.services.ClienteService;
import com.proyecto.commons.controllers.CommonController;
import com.proyecto.commons.dto.ClienteRequest;
import com.proyecto.commons.dto.ClienteResponse;

@RestController
public class ClienteController extends CommonController<ClienteRequest, ClienteResponse, ClienteService>{

	public ClienteController(ClienteService service) {
		super(service);
	}
	
	
}


