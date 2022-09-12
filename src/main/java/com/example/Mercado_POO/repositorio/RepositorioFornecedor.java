package com.example.Mercado_POO.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Fornecedor;


@Repository
public interface RepositorioFornecedor extends JpaRepository<Fornecedor, Long> {

	Fornecedor findById(long id);
	
	Optional<Fornecedor> findByNomeFornecedor(String nomeFornecedor);
	
	Optional<Fornecedor> findByCnpjFornecedor(String cnpjFornecedor);

	boolean existsByCnpjFornecedor(String cnpj);
	
}
