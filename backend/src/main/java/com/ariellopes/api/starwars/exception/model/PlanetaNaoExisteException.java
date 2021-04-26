package com.ariellopes.api.starwars.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PlanetaNaoExisteException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public PlanetaNaoExisteException(String mensagem) {
		super(mensagem);
	}
}