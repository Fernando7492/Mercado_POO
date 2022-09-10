package com.example.Mercado_POO.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Mercado_POO.basica.Produto;

public class CadastroProduto {

	@Autowired
	private CadastroProduto cadastropoduto;
	
	public void cadastrarproduto(Produto produto) {
		this.cadastropoduto.cadastrarproduto(produto);		
	}

	public Produto procurarProduto(String nome) {
		return this.cadastropoduto.procurarProduto(nome);
	}

	public void removerProduto(Produto produto) {
		this.cadastropoduto.removerProduto(produto);	
	}

	public void atualizarProduto(Produto produto) {
		this.atualizarProduto(produto);
	}
	public List<Produto> listarProduto() {
		return this.cadastropoduto.listarProduto();
	}
}
