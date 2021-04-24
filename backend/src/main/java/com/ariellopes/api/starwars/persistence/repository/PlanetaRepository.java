package com.ariellopes.api.starwars.persistence.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ariellopes.api.starwars.persistence.entity.PlanetaEntity;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsulta;

@Repository
public interface PlanetaRepository extends MongoRepository<PlanetaEntity, String> {
	
	public List<PlanetaDtoConsulta> findByNomeIgnoreCase(String nome);
				   
	public List<PlanetaDtoConsulta> findTop6ByNomeContainingIgnoreCase(String nome);

}
