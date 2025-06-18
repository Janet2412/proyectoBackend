package com.proyecto.commons.controllers;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;

public class LocalExceptionHandler {

private final static Logger logger = Logger.getLogger(LocalExceptionHandler.class.getName());
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Map<String, Object> > feignException(FeignException e){
		logger.log(Level.SEVERE,"Error al comunicarsemcon el cliente Feign: " +
	(e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code", 500,
				"response","Error al comunicarse: " + e.getMessage()
				));
	}
	
	@ExceptionHandler(FeignException.NotFound.class)
	public ResponseEntity<Map<String, Object> >feignExceptionNotNull(FeignException.NotFound e){
		logger.log(Level.SEVERE,"Erroro al comunicarse con el cliente Feign: " +
				(e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code", 404,
				"response","El recurso solicitado no fue encontrado: " + e.getMessage()
				));
	}
	
}
