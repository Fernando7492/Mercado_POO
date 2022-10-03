package com.example.Mercado_POO.excecoes;

public class MovimentacaoInexistenteException extends Exception {
	public MovimentacaoInexistenteException() {
		super("Movimentação não encontrada");
	}
}