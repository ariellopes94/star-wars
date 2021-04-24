package com.ariellopes.api.starwars.rest.controller.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditaPlanetaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Size(max = 255,message = "descricao ultrapassou 255 caracteres")
	@NotBlank(message = "campo descricao nao pode ser vazio")
	@NotNull(message = "campo descricao nao pode ser nulo")
	private String nome;
	
	@Size(max = 255,message = "descricao ultrapassou 255 caracteres")
	@NotBlank(message = "campo descricao nao pode ser vazio")
	@NotNull(message = "campo descricao nao pode ser nulo")
	private String clima;
	
	@Size(max = 255,message = "descricao ultrapassou 255 caracteres")
	@NotBlank(message = "campo descricao nao pode ser vazio")
	@NotNull(message = "campo descricao nao pode ser nulo")
	private String terreno;
	

}
