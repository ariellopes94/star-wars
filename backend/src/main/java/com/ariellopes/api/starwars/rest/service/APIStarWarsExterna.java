package com.ariellopes.api.starwars.rest.service;

import com.ariellopes.api.starwars.rest.controller.StarWars;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsulta;
import com.ariellopes.api.starwars.rest.model.modelApiStarWarsExterna.PlanetaApiStarWarsExterna;

public interface APIStarWarsExterna {

	public StarWars consultarPorNome(String nome, Boolean buscarFilme);
}
