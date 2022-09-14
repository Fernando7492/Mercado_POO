package com.example.Mercado_POO.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Venda;
import com.example.Mercado_POO.basica.Vendedor;

@Repository	
public interface RepositorioVendedor extends JpaRepository<Vendedor, Long> {

	Optional<Vendedor> findByVendedorCpf(String cpf);
	
	Optional<Vendedor>findByVendedorNome(String nome);
	
}
