package com.proyecto.commons.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductoRequest(
		
		@NotBlank(message = "El nombre no puede ser vacío ni nulo")
		String nombre,
		
		@NotBlank(message = "La descripcion no puede ser vacía ni nulo")
		String descripcion,
		
		@NotNull(message = "El precio no puede ser nulo")
		@Min(message = "El precio debe ser minimo 1", value = 1)
		Double precio,
		
		@NotNull(message = "El stock no puede ser nulo")
		@Min(message = "El stock debe ser minimo 1", value = 1)
		Integer stock
		
) {}
