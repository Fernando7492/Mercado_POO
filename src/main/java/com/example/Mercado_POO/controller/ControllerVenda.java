package com.example.Mercado_POO.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.Venda;
import com.example.Mercado_POO.fachada.Mercado;

@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/mercado/api/")
public class ControllerVenda {
	
	@Autowired
	private Mercado mercado;

	@PostMapping("venda")
    @ResponseStatus(code = HttpStatus.CREATED)
	public Venda criarVenda(@RequestBody Venda venda) {
		return mercado.saveVenda(venda);
	}
	
	@GetMapping("venda")
	public List<Venda> listarVendas(){
		return mercado.listAllVenda();
	}
	
	@GetMapping("/{idVenda}")
	public Optional<Venda> findById(@PathVariable long idVenda){
		return mercado.findByIdVenda(idVenda);
	}
	
	@GetMapping("/{idCliente}")
	public Optional<Venda> findByClienteId(@PathVariable long idCliente){
		return mercado.findByClienteVendaId(idCliente);
	}
	
	@GetMapping("/{idVendedor}")
	public Optional<Venda> findByVendedorId(@PathVariable long idVendedor){
		return mercado.findByVendedorVendaId(idVendedor);
	}
	
	@DeleteMapping("/{idVenda}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long idVenda) {
		mercado.deleteByIdVenda(idVenda);
	}
	
	@DeleteMapping("venda")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteVenda(Venda venda) {
		mercado.deleteVenda(venda);
	}
	
}
