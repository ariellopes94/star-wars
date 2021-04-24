package com.ariellopes.api.starwars.rest.controller.domain.dto;

import com.ariellopes.api.starwars.rest.model.PlanetaModel;

import lombok.Data;

@Data
public class PlanetaDtoConsultaTodos extends PlanetaModel  {
	private static final long serialVersionUID = 1L;
	
	public int qtExibicaosEmFilme;

}
