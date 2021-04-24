package com.ariellopes.api.starwars.rest.controller.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.ariellopes.api.starwars.rest.model.PlanetaModel;
import com.ariellopes.api.starwars.rest.model.modelApiStarWarsExterna.FilmeApiStarWarsExterna;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetaDtoConsulta extends PlanetaModel {
	private static final long serialVersionUID = 1L;

		public int qtExibicaosEmFilme;
		
		public List<FilmeApiStarWarsExterna> filmes = new ArrayList<>();
		

	
}
