package com.proyecto.commons.mappers;

public abstract class CommonMapper<RQ, RS, E> {
	
	protected abstract RS entityToDTO(E entity);
	
	protected abstract E dtoToEntity(RQ request);
}
