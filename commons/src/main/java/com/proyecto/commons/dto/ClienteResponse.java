package com.proyecto.commons.dto;

public record ClienteResponse(
		
		Long id,
		String nombre,
		String apellido,
		String email,
		String telefono,
		String direccion
		
) {}
