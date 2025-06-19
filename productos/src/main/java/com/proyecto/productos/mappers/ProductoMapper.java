package com.proyecto.productos.mappers;

import org.springframework.stereotype.Component;

import com.proyecto.commons.dto.ProductoRequest;
import com.proyecto.commons.dto.ProductoResponse;
import com.proyecto.commons.mappers.CommonMapper;
import com.proyecto.commons.models.entities.Producto;

@Component
public class ProductoMapper extends CommonMapper<ProductoRequest, ProductoResponse, Producto> {
	
	@Override
	public ProductoResponse entityToDTO(Producto entity) {
		if(entity != null) {
			ProductoResponse response =new ProductoResponse(
					entity.getId(),
					entity.getNombre(),
					entity.getDescripcion(),
					entity.getPrecio(),
					entity.getStock());
			return response;
		}
		return null;
	}
	
	@Override
	public Producto dtoToEntity(ProductoRequest request) {
		if (request != null) {
			Producto productoEntity = new Producto();
			productoEntity.setNombre(request.nombre());
			productoEntity.setDescripcion(request.descripcion());
			productoEntity.setPrecio(request.precio());
			productoEntity.setStock(request.stock());
			return productoEntity;
		}
		return null;
	}

}
