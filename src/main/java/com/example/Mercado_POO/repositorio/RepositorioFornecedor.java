package com.example.Mercado_POO.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Fornecedor;


@Repository
public interface RepositorioFornecedor extends JpaRepository<Fornecedor, Long> {

	Fornecedor findById(long id);
	
	List<Fornecedor> findByNomeFornecedor(String nome);
	
	Fornecedor findByCnpjFornecedor(String cnpjFornecedor);
	
}
