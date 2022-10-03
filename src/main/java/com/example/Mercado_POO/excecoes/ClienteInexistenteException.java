package com.example.Mercado_POO.excecoes;

public class ClienteInexistenteException extends Exception {
	public ClienteInexistenteException() {
		super("Não existe nenhum cliente com este ID.");
	}
}
