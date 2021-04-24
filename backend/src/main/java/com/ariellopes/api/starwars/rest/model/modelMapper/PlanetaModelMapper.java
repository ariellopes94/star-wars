package com.ariellopes.api.starwars.rest.model.modelMapper;

import org.springframework.stereotype.Component;

import com.ariellopes.api.starwars.persistence.entity.PlanetaEntity;
import com.ariellopes.api.starwars.rest.controller.domain.dto.EditaPlanetaDto;
import com.ariellopes.api.starwars.rest.controller.domain.dto.NovoPlanetaDto;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsulta;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsultaTodos;
import com.ariellopes.api.starwars.rest.model.PlanetaModel;

@Component
public class PlanetaModelMapper {

	public PlanetaDtoConsulta toPlanetaDtoConsulta(PlanetaEntity planetaEntity) {

		PlanetaDtoConsulta planetaModel = new PlanetaDtoConsulta();

		planetaModel.setCodigo(planetaEntity.getCodigo());
		planetaModel.setNome(planetaEntity.getNome());
		planetaModel.setClima(planetaEntity.getClima());
		planetaModel.setTerreno(planetaEntity.getTerreno());

		return planetaModel;
	}

	public PlanetaDtoConsultaTodos toPlanetaDtoConsultaTodos(PlanetaEntity planetaEntity) {

		PlanetaDtoConsultaTodos planetaModel = new PlanetaDtoConsultaTodos();

		planetaModel.setCodigo(planetaEntity.getCodigo());
		planetaModel.setNome(planetaEntity.getNome());
		planetaModel.setClima(planetaEntity.getClima());
		planetaModel.setTerreno(planetaEntity.getTerreno());

		return planetaModel;
	}
	
	public PlanetaEntity toEntity(PlanetaModel planetaModel) {

		PlanetaEntity planetaEntity = new PlanetaEntity();

		planetaEntity.setCodigo(planetaModel.getCodigo());
		planetaEntity.setNome(planetaModel.getNome());
		planetaEntity.setClima(planetaModel.getClima());
		planetaEntity.setTerreno(planetaModel.getTerreno());

		return planetaEntity;
	}
	
	public PlanetaModel toModel(PlanetaEntity planetaEntity) {

		PlanetaModel planetaModel = new PlanetaModel();

		planetaModel.setCodigo(planetaEntity.getCodigo());
		planetaModel.setNome(planetaEntity.getNome());
		planetaModel.setClima(planetaEntity.getClima());
		planetaModel.setTerreno(planetaEntity.getTerreno());

		return planetaModel;
	}
	
	public PlanetaEntity toEntity(NovoPlanetaDto novoPlanetaDto) {

		PlanetaEntity planetaEntity = new PlanetaEntity();

		planetaEntity.setNome(novoPlanetaDto.getNome());
		planetaEntity.setClima(novoPlanetaDto.getClima());
		planetaEntity.setTerreno(novoPlanetaDto.getTerreno());

		return planetaEntity;
	}
	
	public PlanetaEntity toEntity(EditaPlanetaDto editaPlanetaDto) {

		PlanetaEntity planetaEntity = new PlanetaEntity();

		planetaEntity.setNome(editaPlanetaDto.getNome());
		planetaEntity.setClima(editaPlanetaDto.getClima());
		planetaEntity.setTerreno(editaPlanetaDto.getTerreno());
		
		return planetaEntity;
	}

}
