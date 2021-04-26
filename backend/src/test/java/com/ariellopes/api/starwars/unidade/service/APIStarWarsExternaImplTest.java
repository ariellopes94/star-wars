package com.ariellopes.api.starwars.unidade.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ariellopes.api.starwars.exception.model.UrlNaoEncontradaException;
import com.ariellopes.api.starwars.rest.service.impl.APIStarWarsExternaImpl;

public class APIStarWarsExternaImplTest {
	
	APIStarWarsExternaImpl apiStarWars = new APIStarWarsExternaImpl();
	
	@Test
	public void deveRetornarURI_IMAGE_FILME() {	
		String filmeUriImg = apiStarWars.inserirImgUrl("1/");
		assertEquals("FILME 01 A New Hope", filmeUriImg);
	}

	@Test
	public void deveRetornarExceptionUrlNaoEncontrada() {	
		assertThrows(UrlNaoEncontradaException.class, () -> apiStarWars.inserirImgUrl("15/"));
	}
	
}
