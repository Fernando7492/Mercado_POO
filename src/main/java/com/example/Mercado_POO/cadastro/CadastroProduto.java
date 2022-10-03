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
	
	public Produto save(Produto produto) {
		if(repositorioProduto.existsByNome(produto.getNome())) {
			return null;
		}
		else {
			return repositorioProduto.save(produto);
		}
	}
	
	public Optional<Produto> findById(long id) {
		return repositorioProduto.findById(id);
	}
	
	public List<Produto> listAll(){
		return repositorioProduto.findAll();
	}
	
	public Produto update(long antigoId,Produto novo) {
		if(repositorioProduto.existsByNome(novo.getNome())) {
			return null;
		}
		else {
			novo.setId(antigoId);
			return repositorioProduto.save(novo);
		}
	}
	
	public Optional<Produto> findByNome(String nome){
		return repositorioProduto.findByNomeContainingIgnoreCase(nome);
	}
	
	public Optional<Produto> findByCategoria(String categoria){
		return repositorioProduto.findByCategoriaContainingIgnoreCase(categoria);
	}
	
	public Optional<Produto> findByValidade(String validadeProduto){
		return repositorioProduto.findByValidade(validadeProduto);
	} 
	
	public void deleteById(Long id) {
		repositorioProduto.deleteById(id);
	}
	
	public void delete(Produto produto) {
		repositorioProduto.delete(produto);
	}
}
