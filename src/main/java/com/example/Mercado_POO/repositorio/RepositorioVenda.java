package com.example.Mercado_POO.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Venda;

@Repository	
public interface RepositorioVenda extends JpaRepository<Venda, Long> {

	Venda findById(long id);
	
	List<Venda> findByClienteVenda(long clienteId);
	
	List<Venda>findByVendedorVenda(long vendedorId);
	
}
