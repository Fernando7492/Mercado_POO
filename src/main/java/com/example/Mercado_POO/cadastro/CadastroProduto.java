package com.example.Mercado_POO.cadastro;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Produto;
import com.example.Mercado_POO.repositorio.RepositorioProduto;

@Service
public class CadastroProduto {

	@Autowired
	private RepositorioProduto repositorioProduto;
	
	public Optional<Produto> findById(long id) {
		return repositorioProduto.findById(id);
	}
	
	public List<Produto> listAll(){
		return repositorioProduto.findAll();
	}
	
	public Optional<Produto> findByNomeProduto(String nome){
		return repositorioProduto.findByNomeProduto(nome);
	}
	
	public Optional<Produto> findByCategoriaProduto(String categoria){
		return repositorioProduto.findByCategoriaProduto(categoria);
	}
	
	public Optional<Produto> findByValidadeProduto(Date validade){
		return repositorioProduto.findByValidadeProduto(validade);
	} 
	
	public void deleteById(Long id) {
		repositorioProduto.deleteById(id);
	}
	
	public void delete(Produto produto) {
		repositorioProduto.delete(produto);
	}
}
