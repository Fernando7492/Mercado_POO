package com.example.Mercado_POO.repositorio;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Produto;

@Repository
public interface RepositorioProduto extends JpaRepository<Produto, Long>{
	
	
	Optional<Produto> findByNomeProdutoContaining(String nomeProduto);
	
	Optional<Produto> findByCategoriaProduto(String categoriaProduto);
	
	Optional<Produto> findByQuantidadeProduto(Integer quantidadeProduto);
	
	Optional<Produto> findByValidadeProdutoBetween(Date validadeProdutoMin,Date validadeProdutoMax);
	
	boolean existByNomeProduto(String nomeProduto);
	
}
