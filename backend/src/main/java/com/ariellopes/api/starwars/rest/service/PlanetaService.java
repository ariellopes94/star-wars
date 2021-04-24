package com.ariellopes.api.starwars.rest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ariellopes.api.starwars.rest.controller.domain.dto.EditaPlanetaDto;
import com.ariellopes.api.starwars.rest.controller.domain.dto.NovoPlanetaDto;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsulta;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsultaTodos;
import com.ariellopes.api.starwars.rest.model.PlanetaModel;

public interface PlanetaService {

	PlanetaModel criar (NovoPlanetaDto novoPlanetaDto);

	Page<PlanetaDtoConsultaTodos> buscarTodos(Pageable pageable);
	
	PlanetaDtoConsulta consultarPorNome(String planetaNome);
	
	List<PlanetaDtoConsulta> consultarPorContainsNome(String planetaNome);
	
	PlanetaDtoConsulta consultarPorCodigo(String codigo);
	
	void deletar(String id);
	
    PlanetaModel editar(EditaPlanetaDto planeta, String id);

}
