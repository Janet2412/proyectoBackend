package com.proyecto.productos.controllers;

import java.util.Map;
import java.util.logging.Level;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class LocalExceptionHandler {
	
	private static final Logger logger = Logger.getLogger(LocalExceptionHandler.class.getName());
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, Object> > DataIntegrityViolationException(DataIntegrityViolationException e) {
		logger.log(Level.SEVERE, "Error en la integridad de los datos: " + (e.getMessage() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"codigo", 400,
				"response","Error en la integridad de los datos: " + e.getMessage()
				));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, Object> > ConstraintViolationException(ConstraintViolationException e) {
		logger.log(Level.WARNING, "Violación de la restricción: " + (e.getMessage() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"codigo", 400,
				"response","Violación en la restricción: " + e.getMessage()
				));
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Map<String, Object> > NoSuchElementException(NoSuchElementException e) {
		logger.log(Level.INFO, "No se encontro la información con el ID ingresado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
				"codigo", 404,
				"response","No se encontro la información con el ID ingresado" + e.getMessage()
				));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object> > HandGeneralException(Exception e) {
		logger.log(Level.SEVERE, "Error del servidor: " + (e.getCause() != null ? e.getCause() : e.getMessage()));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
				"codigo", 500,
				"response","Error del servidor: " + e.getCause() != null ? e.getCause() : e.getMessage()
				));
	}

}
