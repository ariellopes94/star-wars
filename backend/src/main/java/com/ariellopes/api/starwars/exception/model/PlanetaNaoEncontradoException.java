package com.ariellopes.api.starwars.exception.model;

public class PlanetaNaoEncontradoException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public PlanetaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PlanetaNaoEncontradoException(String cidadeId, String id) {
		this(String.format("Não existe um cadastro de cidade com código %s", cidadeId));
	}
}