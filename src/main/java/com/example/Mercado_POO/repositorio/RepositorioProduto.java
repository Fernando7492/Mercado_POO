package com.example.Mercado_POO.repositorio;

import java.util.List;

import javax.persistence.Entity;

import com.example.Mercado_POO.basica.Produto;

@Entity
public interface RepositorioProduto{
	
	void cadastrarproduto(Produto produto);
	
	Produto procurarProduto(String nome);
	
	void removerProduto(Produto produto);
	
	void atualizarProduto(Produto produto);
	
	List<Produto> listarProduto();
	

}
