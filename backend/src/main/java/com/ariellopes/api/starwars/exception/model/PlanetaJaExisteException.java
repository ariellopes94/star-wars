package com.ariellopes.api.starwars.exception.model;

public class PlanetaJaExisteException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public PlanetaJaExisteException(String mensagem) {
		super(mensagem);
	}
	
	public PlanetaJaExisteException(String cidadeId, String id) {
		this(String.format("Não existe um cadastro de cidade com código %s", cidadeId));
	}
}