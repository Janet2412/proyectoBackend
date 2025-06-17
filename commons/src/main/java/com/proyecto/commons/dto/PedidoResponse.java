package com.proyecto.commons.dto;

import java.util.List;
import java.util.Date;

public record PedidoResponse(
		
		Long id,
		ClienteResponse cliente,
		Double total,
		Date fechaCreación,
		String estado,
		List<ProductoResponse> producto
		
) {}