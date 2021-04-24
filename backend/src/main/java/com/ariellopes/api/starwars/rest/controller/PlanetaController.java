package com.ariellopes.api.starwars.rest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ariellopes.api.starwars.rest.controller.domain.dto.EditaPlanetaDto;
import com.ariellopes.api.starwars.rest.controller.domain.dto.NovoPlanetaDto;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsulta;
import com.ariellopes.api.starwars.rest.controller.domain.dto.PlanetaDtoConsultaTodos;
import com.ariellopes.api.starwars.rest.model.PlanetaModel;
import com.ariellopes.api.starwars.rest.service.APIStarWarsExterna;
import com.ariellopes.api.starwars.rest.service.PlanetaService;

@RestController
@RequestMapping(path = "/api/v1/starwars/planetas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;

	@Autowired
	private APIStarWarsExterna apiStarWarsExterna;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<NovoPlanetaDto> create(@Valid @RequestBody NovoPlanetaDto novoPlanetaDto) {
		PlanetaModel obj = planetaService.criar(novoPlanetaDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<PlanetaDtoConsultaTodos> buscarTodos(
			@PageableDefault(size = 5, sort = "qtExibicaosEmFilme", direction = Direction.DESC) Pageable pageable) {
		Page<PlanetaDtoConsultaTodos> publicacaoPage = planetaService.buscarTodos(pageable);

		List<PlanetaDtoConsultaTodos> publicacaoModel = publicacaoPage.getContent();
		Page<PlanetaDtoConsultaTodos> publicacaoModelPage = new PageImpl<>(publicacaoModel, pageable,
				publicacaoPage.getTotalElements());
		return publicacaoModelPage;
	}

	@GetMapping(value = "/filtro/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PlanetaModel> consultarPorNome(@PathVariable String nome) {
		PlanetaModel obj = planetaService.consultarPorNome(nome);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/filtro/contains/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<PlanetaDtoConsulta>> consultarPorNomeContains(@PathVariable String nome) {
		List<PlanetaDtoConsulta> obj = planetaService.consultarPorContainsNome(nome);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/{codigo}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PlanetaModel> consultarPorCodigo(@PathVariable String codigo) {
		PlanetaModel obj = planetaService.consultarPorCodigo(codigo);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable String id){
		planetaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<PlanetaModel> editar(@Valid @RequestBody EditaPlanetaDto planetaDto , @PathVariable String id){
		planetaService.editar(planetaDto, id);
		return ResponseEntity.noContent().build();
	}

	/*
	 * 
	 * @PutMapping(value = "/{codigoPlaneta}") public ResponseEntity<PlanetaModel>
	 * atualizar(@RequestBody PlanetaModel planeta, @PathVariable String
	 * codigoPlaneta) { planeta.setCodigo(codigoPlaneta);
	 * /planetaService.editar(planeta); return ResponseEntity.noContent().build(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @GetMapping("/starwars/filtar/{nome}") public ResponseEntity<StarWars>
	 * planetaApiExternaoBuscarPorNome(@PathVariable String nome) {
	 * 
	 * StarWars planetaApiNome =
	 * this.apiStarWarsExterna.consultarPorNome(nome,true);
	 * 
	 * System.out.println(planetaApiNome);
	 * 
	 * return ResponseEntity.ok(planetaApiNome); }
	 */
}
