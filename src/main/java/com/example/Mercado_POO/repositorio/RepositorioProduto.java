package com.example.Mercado_POO.repositorio;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Produto;

@Repository
public interface RepositorioProduto extends JpaRepository<Produto, Long>{
	
	
	Optional<Produto> findByNomeContainingIgnoreCase(String nomeProduto);
	
	Optional<Produto> findByCategoriaContainingIgnoreCase(String categoriaProduto);
	
	Optional<Produto> findByQuantidade(Integer quantidadeProduto);
	
	Optional<Produto> findByValidade(String validadeProduto);
	
	boolean existsByNome(String nomeProduto);
	
}
