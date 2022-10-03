package com.example.Mercado_POO.excecoes;

public class QuantidadeNegativaException extends Exception {
	public QuantidadeNegativaException(String nome) {
		super("A quantidade de "+nome+" não pode ser negativo!");
	}
}
