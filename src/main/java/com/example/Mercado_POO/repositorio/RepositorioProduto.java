package com.example.Mercado_POO.repositorio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Produto;

@Repository
public interface RepositorioProduto extends JpaRepository<Produto, Long>{
	
	
	Optional<Produto> findByNomeProduto(String nomeProduto);
	
	Optional<Produto> findByCategoriaProduto(String categoriaProduto);
	
	Optional<Produto> findByQuantidadeProduto(Integer quantidadeProduto);
	
	Optional<Produto> findByValidadeProduto(Date validadeProduto);
	
	
}
