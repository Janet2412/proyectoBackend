package com.proyecto.commons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteRequest(
		
		@NotBlank(message = "El nombre no puede ser vacío ni nulo")
		String nombre,
		
		@NotBlank(message = "El apellido no puede ser vacío ni nulo")
		String apellido,
		
		@NotBlank(message = "No puede ser nulo")
		@Email(message = "El correo debe tener un formato correcto")
		String email,
		
		@NotBlank(message = "No puede ser nulo")
		@Pattern(regexp="^[0-9]{10}$", message ="El número de teléfono debe tener solo 10 dígitos")	
		String telefono,
		
		@NotBlank(message = "La dirección no puede ser vacía ni nula")
		String direccion
		
) {}
