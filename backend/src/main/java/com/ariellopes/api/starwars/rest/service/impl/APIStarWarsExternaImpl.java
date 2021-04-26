package com.ariellopes.api.starwars.rest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ariellopes.api.starwars.exception.model.UrlNaoEncontradaException;
import com.ariellopes.api.starwars.rest.model.StarWarsModel;
import com.ariellopes.api.starwars.rest.model.modelApiStarWarsExterna.FilmeApiStarWarsExterna;
import com.ariellopes.api.starwars.rest.model.modelApiStarWarsExterna.PlanetaApiStarWarsExterna;
import com.ariellopes.api.starwars.rest.service.APIStarWarsExterna;

import reactor.core.publisher.Mono;

@Service
public class APIStarWarsExternaImpl implements APIStarWarsExterna {

	@Autowired
	private WebClient webClientStarWars;

	@Override
	@Cacheable(cacheNames = "qtExibicaosEmFilmeCache")
	public StarWarsModel consultarPorNome(String nomeParaBuscar, Boolean buscarFilme) {
		StarWarsModel starWars = new StarWarsModel();
		Mono<PlanetaApiStarWarsExterna> monoPlaneta = this.webClientStarWars.method(HttpMethod.GET)
				.uri("/api/planets/?search={nome}", nomeParaBuscar).retrieve()
				.bodyToMono(PlanetaApiStarWarsExterna.class);
		PlanetaApiStarWarsExterna planeta = monoPlaneta.block();
		// Procurar para vê que acha, caso ache entrar no IF
		if (Integer.valueOf(planeta.getCount()) >= 1) {
			int qtExibicaoFilme = planeta.getResults().get(0).getFilms().size();
			if (buscarFilme) {
				List<FilmeApiStarWarsExterna> filmes = buscarTodosFilmesQueApareceramNoPlaneta(
						planeta.getResults().get(0).getFilms());
				starWars.setFilmes(filmes);
			}
			starWars.setQtExibicaosEmFilme(qtExibicaoFilme);
		}
		return starWars;
	}

	@Cacheable(cacheNames = "filmeCache")
	private List<FilmeApiStarWarsExterna> buscarTodosFilmesQueApareceramNoPlaneta(List<String> filmesId) {
		List<FilmeApiStarWarsExterna> filmesStarWars = new ArrayList<>();
		for (String filmeId : filmesId) {
			String removerIdUrl = filmeId.replaceAll("http://swapi.dev/api/films/", "");
			Mono<FilmeApiStarWarsExterna> monoProduto = this.webClientStarWars.method(HttpMethod.GET)
					.uri("/api/films/{codigoID}", removerIdUrl).retrieve().bodyToMono(FilmeApiStarWarsExterna.class);
			FilmeApiStarWarsExterna filmeApi = monoProduto.block();
			filmeApi.setUrlImg(inserirImgUrl(removerIdUrl));
			filmesStarWars.add(filmeApi);
		}
		return filmesStarWars;
	}

	public String inserirImgUrl(String id) {
		Map<String, String> imgUrl = new HashMap<>();
		imgUrl.put("1/", "FILME 01 A New Hope");
		imgUrl.put("2/", "FILME 02 The Empire Strikes Back");
		imgUrl.put("3/", "FILME 03 Return of the Jedi");
		imgUrl.put("4/", "FILME 04 The Phantom Menace");
		imgUrl.put("5/", "FILME 05 Attack of the Clones");
		imgUrl.put("6/", "FILME 06 Revenge of the Sith");

		String urlDaImg = imgUrl.get(id);

		if (urlDaImg == null) {
			throw new UrlNaoEncontradaException("Não Existe imagem para essa url");
		}

		return imgUrl.get(id);
	}

}
