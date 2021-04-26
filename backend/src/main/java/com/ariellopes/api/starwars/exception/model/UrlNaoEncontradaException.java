package com.ariellopes.api.starwars.exception.model;

public class UrlNaoEncontradaException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public UrlNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}