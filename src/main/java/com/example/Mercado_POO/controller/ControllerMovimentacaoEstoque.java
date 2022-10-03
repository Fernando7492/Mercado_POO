package com.example.Mercado_POO.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.MovimentacaoEstoque;
import com.example.Mercado_POO.fachada.Mercado;

@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/mercado/api/")

public class ControllerMovimentacaoEstoque {
	@Autowired
	private Mercado mercado;
	
	@PostMapping("MovimentacaoEstoque")
    @ResponseStatus(code = HttpStatus.CREATED)
	public MovimentacaoEstoque criarMovimentacaoEstoque(@RequestBody MovimentacaoEstoque movimentacaoEstoque) {
		return mercado.saveMovimentacaoEstoque(movimentacaoEstoque);
	}
	@GetMapping("/estoque{id}")
	public Optional<MovimentacaoEstoque> findMovimentacaoEstoqueById(Long id){
		return mercado.findMovimentacaoEstoqueById(id);
	}

}
