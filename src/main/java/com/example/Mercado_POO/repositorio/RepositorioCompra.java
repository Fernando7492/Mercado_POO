package com.example.Mercado_POO.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Compra;

@Repository
public interface RepositorioCompra extends JpaRepository<Compra, Long> {
	
	Compra findById(long id);
	
	Optional<Compra> findByFornecedorCompraId(Long fornecedorId);

}
