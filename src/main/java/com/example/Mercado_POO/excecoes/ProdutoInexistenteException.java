package com.example.Mercado_POO.excecoes;

public class ProdutoInexistenteException extends Exception {
	public ProdutoInexistenteException() {
		super("Não existe nenhum Produto com este ID.");
	}
}
