package com.example.Mercado_POO.repositorio;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.MovimentacaoEstoque;

@Repository
public interface RepositorioMovimentacaoEstoque extends JpaRepository<MovimentacaoEstoque, Long> {
	
	Optional<MovimentacaoEstoque> findByDataHoraBetween(String dataMovimentacaoEstoqueIni, String dataMovimentacaoEstoqueFim);
	
}
