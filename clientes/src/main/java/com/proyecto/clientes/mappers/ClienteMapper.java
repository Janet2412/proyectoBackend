package com.proyecto.clientes.mappers;

import org.springframework.stereotype.Component;

import com.proyecto.commons.dto.ClienteRequest;
import com.proyecto.commons.dto.ClienteResponse;
import com.proyecto.commons.mappers.CommonMapper;
import com.proyecto.commons.models.entities.Cliente;

@Component
public class ClienteMapper extends CommonMapper<ClienteRequest, ClienteResponse, Cliente>{

	@Override
	public ClienteResponse entityToDTO(Cliente entity) {
		if (entity != null) {
			ClienteResponse response = new ClienteResponse(
					entity.getId(),
					entity.getNombre(),
					entity.getApellido(),
					entity.getEmail(),
					entity.getTelefono(),
					entity.getDireccion());
			return response;
		}
		return null;
	}

	@Override
	public Cliente dtoToEntity(ClienteRequest request) {
		if (request != null) {
			Cliente clienteEntity = new Cliente();
			clienteEntity.setNombre(request.nombre());
			clienteEntity.setApellido(request.apellido());
			clienteEntity.setEmail(request.email());
			clienteEntity.setTelefono(request.telefono());
			clienteEntity.setEmail(request.direccion());
			return clienteEntity;
		}
		return null;
	}


}
