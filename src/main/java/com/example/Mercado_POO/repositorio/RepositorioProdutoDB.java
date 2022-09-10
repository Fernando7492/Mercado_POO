package com.example.Mercado_POO.repositorio;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Mercado_POO.basica.Produto;
@Entity
public class RepositorioProdutoDB implements RepositorioProduto{
	
	@Autowired
	private List<Produto> produtos;

	@Override
	public void cadastrarproduto(Produto produto) {
		this.produtos.add(produto);
		
	}

	@Override
	public Produto procurarProduto(String nome) {
		for(Produto p:this.produtos) {
			if(p.getName().equals(nome)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void removerProduto(Produto produto) {
		this.produtos.remove(produto);
		
	}

	@Override
	public void atualizarProduto(Produto produto) {
		this.produtos.remove(produto);
		this.produtos.add(produto);
		
	}

	@Override
	public List<Produto> listarProduto() {
		return this.produtos;
	}

}
