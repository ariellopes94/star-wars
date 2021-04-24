package com.ariellopes.api.starwars.rest.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class PlanetaModel implements Serializable {
	private static final long serialVersionUID = 1L;


	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private String codigo;	
	
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

