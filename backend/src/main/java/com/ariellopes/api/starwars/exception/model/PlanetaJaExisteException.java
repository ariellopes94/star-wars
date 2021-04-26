package com.ariellopes.api.starwars.exception.model;

public class PlanetaJaExisteException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public PlanetaJaExisteException(String mensagem) {
		super(mensagem);
	}
}