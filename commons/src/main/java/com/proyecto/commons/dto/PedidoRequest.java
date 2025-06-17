package com.proyecto.commons.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record PedidoRequest(
		
		@NotNull(message = "El ID no puede ser vacío ni nulo")
		Long idCliente,
		
		@NotNull(message =  "La lista de productos no puede ser nula")
		@Size(min = 1, message = "La lista de productos debe contener al menos un producto")
		List<ProductoCatidadRequest> productos
		
) {}