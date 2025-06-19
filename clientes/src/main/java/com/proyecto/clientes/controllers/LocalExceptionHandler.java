package com.proyecto.clientes.controllers;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.proyecto.commons.controllers.GlobalExceptionHandler;

import feign.FeignException;

public class LocalExceptionHandler extends GlobalExceptionHandler {
	
	
private static final Logger logger = Logger.getLogger(LocalExceptionHandler.class.getName());
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity< Map<String, Object> > feignException(FeignException e) {
		logger.log(Level.SEVERE, "Error al comunicarse con el cliente Feign: " + 
				(e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code", 500,
				"response", "Error al comunicarse con el cliente Feign: " + e.getMessage()
		));
	}

	@ExceptionHandler(FeignException.NotFound.class)
	public ResponseEntity< Map<String, Object> > feignExceptionNotFound(FeignException.NotFound e) {
		logger.log(Level.SEVERE, "Error al comunicarse con el cliente Feign: " + 
				(e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code", 404,
				"response", "El recurso solicitado no fue entregado: "
		));
	}

}


