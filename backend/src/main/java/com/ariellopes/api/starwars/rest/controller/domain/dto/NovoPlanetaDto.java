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
public class NovoPlanetaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Size(max = 25,message = "nome ultrapassou 255 caracteres")
	@NotBlank(message = "campo nome nao pode ser vazio")
	@NotNull(message = "campo nome nao pode ser nulo")
	private String nome;
	
	@Size(max = 25,message = "clima ultrapassou 255 caracteres")
	@NotBlank(message = "campo clima nao pode ser vazio")
	@NotNull(message = "campo clima nao pode ser nulo")
	private String clima;
	
	@Size(max = 25,message = "descricao terreno 255 caracteres")
	@NotBlank(message = "campo terreno nao pode ser vazio")
	@NotNull(message = "campo terreno nao pode ser nulo")
	private String terreno;
	
}
