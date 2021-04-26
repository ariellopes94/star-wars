package com.ariellopes.api.starwars.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ariellopes.api.starwars.exception.model.PlanetaJaExisteException;
import com.ariellopes.api.starwars.exception.model.PlanetaNaoEncontradoException;
import com.ariellopes.api.starwars.exception.model.PlanetaNaoExisteException;
import com.ariellopes.api.starwars.persistence.entity.PlanetaEntity;
import com.ariellopes.api.starwars.persistence.repository.PlanetaRepository;
import com.ariellopes.api.starwars.rest.controller.domain.dto.EditaPlanetaDto;
import com.ariellopes.api.starwars.rest.controller.domain.dto.NovoPlanetaDto;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsulta;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsultaTodos;
import com.ariellopes.api.starwars.rest.model.PlanetaModel;
import com.ariellopes.api.starwars.rest.model.StarWarsModel;
import com.ariellopes.api.starwars.rest.model.modelMapper.PlanetaModelMapper;
import com.ariellopes.api.starwars.rest.service.APIStarWarsExterna;
import com.ariellopes.api.starwars.rest.service.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Autowired
	private PlanetaModelMapper modelMapper;

	@Autowired
	private APIStarWarsExterna apiStarWarsExterna;

	@Override
	@Transactional
	public PlanetaModel criar(NovoPlanetaDto novoPlanetaDto) {
		verrificarExistenciaPorNome(novoPlanetaDto.getNome());
		PlanetaEntity planetaEntity = planetaRepository.save(modelMapper.toEntity(novoPlanetaDto));
		return modelMapper.toModel(planetaEntity);
	}

	@Override
	public Page<PlanetaDtoConsultaTodos> buscarTodos(Pageable pageable) {
		Page<PlanetaEntity> planetaEntity = planetaRepository.findAll(pageable);
		
		if(planetaEntity.getTotalElements() == 0) {
			throw new PlanetaNaoExisteException("Não existe Planeta");
		}
	
		Page<PlanetaDtoConsultaTodos> contactDtoPage = planetaEntity.map(modelMapper::toPlanetaDtoConsultaTodos);
		for (PlanetaDtoConsultaTodos planetaDto : contactDtoPage) {
			StarWarsModel api = apiStarWarsExterna.consultarPorNome(planetaDto.getNome(), false);
			planetaDto.setQtExibicaosEmFilme(api.getQtExibicaosEmFilme());
		}
		return contactDtoPage;
	}

	@Override
	public PlanetaDtoConsulta consultarPorNome(String nome) {
		List<PlanetaDtoConsulta> planetas = planetaRepository.findByNomeIgnoreCase(nome);

		if (planetas.isEmpty() == true) {
			throw new PlanetaNaoEncontradoException("Não existe Planeta");
		}
		StarWarsModel api = apiStarWarsExterna.consultarPorNome(nome, true);

		for (PlanetaDtoConsulta planeta : planetas) {
			planeta.setQtExibicaosEmFilme(api.getQtExibicaosEmFilme());
			planeta.setFilmes(api.getFilmes());
		}
		return planetas.get(0);
	}

	@Override
	public List<PlanetaDtoConsulta> consultarPorContainsNome(String nome) {
		List<PlanetaDtoConsulta> planetaDtoConsulta = planetaRepository.findTop6ByNomeContainingIgnoreCase(nome);

		if (planetaDtoConsulta.isEmpty() == true) {
			throw new PlanetaNaoEncontradoException("Não existe Planeta");
		}
		return planetaDtoConsulta;
	}

	@Override
	public PlanetaDtoConsulta consultarPorCodigo(String codigo) {

		verrificarExistenciaPorCodigo(codigo);

		PlanetaEntity planetaEntity = planetaRepository.findById(codigo).get();
		PlanetaDtoConsulta planetaDtoConsulta = modelMapper.toPlanetaDtoConsulta(planetaEntity);
		StarWarsModel api = apiStarWarsExterna.consultarPorNome(planetaDtoConsulta.getNome(), true);
		planetaDtoConsulta.setQtExibicaosEmFilme(api.getQtExibicaosEmFilme());
		planetaDtoConsulta.setFilmes(api.getFilmes());
		return planetaDtoConsulta;
	}
	
	@Override
	@Transactional
	public void deletar(String id) {
		verrificarExistenciaPorCodigo(id);
		planetaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public PlanetaModel editar(EditaPlanetaDto editarPlanetaDto, String id) {

		consultarPorCodigo(id);

		PlanetaEntity planetaEntity = modelMapper.toEntity(editarPlanetaDto);
		planetaEntity.setCodigo(id);
		planetaEntity = planetaRepository.save(planetaEntity);
		PlanetaModel planetaModel = modelMapper.toModel(planetaEntity);

		return planetaModel;
	}

	private Boolean verrificarExistenciaPorNome(String nome) {
		List<PlanetaDtoConsulta> planetas = planetaRepository.findByNomeIgnoreCase(nome);

		if (planetas.isEmpty() != true) {
			throw new PlanetaJaExisteException("Planeta já existe");
		}
		return true;
	}

	private Boolean verrificarExistenciaPorCodigo(String id) {
		Optional<PlanetaEntity> obj = planetaRepository.findById(id);
		obj.orElseThrow(() -> new PlanetaNaoEncontradoException("Planeta não encontrado"));
		return true;
	}
}