package com.example.Mercado_POO.repositorio;

import java.sql.Time;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mercado_POO.basica.MovimentacaoEstoque;

@Repository
public interface RepositorioMovimentacaoEstoque extends JpaRepository<MovimentacaoEstoque, Long> {
	
	Optional<MovimentacaoEstoque> findByDataMovimentacaoEstoque(Date dataMovimentacaoEstoque);
	
	Optional<MovimentacaoEstoque> findByHoraMovimentacaoEstoque(Time horaMovimentacaoEstoque);
	
	Optional<MovimentacaoEstoque> findByMotivoMovimentacaoEstoque(String motivoMovimentacaoEstoque);
}
