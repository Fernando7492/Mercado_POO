package com.example.Mercado_POO.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.Endereco;


@Repository
public interface RepositorioEndereco extends JpaRepository<Endereco, Long>{

	Endereco findById(long id);
}
