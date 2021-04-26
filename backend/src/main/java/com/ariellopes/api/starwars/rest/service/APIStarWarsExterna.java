package com.ariellopes.api.starwars.rest.service;

import com.ariellopes.api.starwars.rest.model.StarWarsModel;

public interface APIStarWarsExterna {

	public StarWarsModel consultarPorNome(String nome, Boolean buscarFilme);
}
