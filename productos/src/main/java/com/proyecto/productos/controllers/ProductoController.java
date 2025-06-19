package com.proyecto.productos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.proyecto.commons.controllers.CommonController;
import com.proyecto.commons.dto.ProductoRequest;
import com.proyecto.commons.dto.ProductoResponse;
import com.proyecto.productos.services.ProductoService;

@RestController
public class ProductoController extends CommonController<ProductoRequest, ProductoResponse, ProductoService> {
	
	public ProductoController(ProductoService service) {
		super(service);
	}

}