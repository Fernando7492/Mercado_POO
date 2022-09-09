package com.example.Mercado_POO.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Venda;

@Repository	
public interface RepositorioVenda extends JpaRepository<Venda, Long> {

	Venda findById(long id);
	
	Optional<Venda> findByClienteVendaId(long clienteId);
	
	Optional<Venda>findByVendedorVendaId(long vendedorId);
	
}
