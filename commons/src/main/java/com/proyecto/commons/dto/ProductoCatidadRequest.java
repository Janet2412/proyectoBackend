package com.proyecto.commons.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductoCatidadRequest(
		@NotNull(message = "El id del producto no puede ser nulo")
		@Min(message = "El id del producto debe ser minimo 1", value = 1)
		Long idProducto,
		
		@Min(value = 3, message = "Los productos deben ser minimo de 3")
		Integer cantidad
		
) {}
