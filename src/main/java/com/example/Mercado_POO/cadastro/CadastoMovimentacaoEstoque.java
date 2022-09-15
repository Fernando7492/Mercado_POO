package com.example.Mercado_POO.cadastro;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.MovimentacaoEstoque;
import com.example.Mercado_POO.basica.Produto;
import com.example.Mercado_POO.repositorio.RepositorioMovimentacaoEstoque;

@Service
public class CadastoMovimentacaoEstoque {
	
	@Autowired
	private RepositorioMovimentacaoEstoque repositorioMovimentacaoEstoque;
	
	public MovimentacaoEstoque save(MovimentacaoEstoque movimentacaoEstoque) {
			return repositorioMovimentacaoEstoque.save(movimentacaoEstoque);
		
	}
	
	public Optional<MovimentacaoEstoque> findById(Long id){
		return repositorioMovimentacaoEstoque.findById(id);
	}
	public Optional<MovimentacaoEstoque> findByDataMovimentacaoEstoque(Date dataMovimentacaoEstoque){
		return repositorioMovimentacaoEstoque.findByDataMovimentacaoEstoque(dataMovimentacaoEstoque);
		
	}
	
	public Optional<MovimentacaoEstoque> findByHoraMovimentacaoEstoque(Time horaMovimentacaoEstoque) {
		return repositorioMovimentacaoEstoque.findByHoraMovimentacaoEstoque(horaMovimentacaoEstoque);
	}
	
	public Optional<MovimentacaoEstoque> findByMotivoMovimentacaoEstoque(String motivoMovimentacaoEstoque) {
		return repositorioMovimentacaoEstoque.findByMotivoMovimentacaoEstoque(motivoMovimentacaoEstoque);
	}
	

}
