package com.example.Mercado_POO.cadastro;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.MovimentacaoEstoque;
import com.example.Mercado_POO.repositorio.RepositorioMovimentacaoEstoque;

@Service
public class CadastoMovimentacaoEstoque {
	
	@Autowired
	private RepositorioMovimentacaoEstoque repositorioMovimentacaoEstoque;
	
	public MovimentacaoEstoque saveMovimentacaoEstoque(MovimentacaoEstoque movimentacaoEstoque) {
		return repositorioMovimentacaoEstoque.save(movimentacaoEstoque);
	}
	
	public Optional<MovimentacaoEstoque> findById(Long id){
		return repositorioMovimentacaoEstoque.findById(id);
	}
	public Optional<MovimentacaoEstoque> findByDataHora(String dataMovimentacaoEstoqueIni, String dataMovimentacaoEstoqueFim){
		return repositorioMovimentacaoEstoque.findByDataHoraBetween(dataMovimentacaoEstoqueIni, dataMovimentacaoEstoqueFim);
		
	}	

}
