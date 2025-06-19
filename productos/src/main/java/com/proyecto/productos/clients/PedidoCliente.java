package com.proyecto.productos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyecto.commons.dto.PedidoResponse;

@FeignClient(name = "pedido")
public interface PedidoCliente {
	
	@GetMapping("/{id}")
	PedidoResponse getPedido(@PathVariable Long id);

}
