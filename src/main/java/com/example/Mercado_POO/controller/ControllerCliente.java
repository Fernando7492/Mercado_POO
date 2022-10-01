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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.Cliente;
import com.example.Mercado_POO.fachada.Mercado;

@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/mercado/api/")
public class ControllerCliente {
	
	@Autowired
	private Mercado mercado;
	
	@PostMapping("cliente")
    @ResponseStatus(code = HttpStatus.CREATED)
	public Cliente criarCliente(@RequestBody Cliente cliente) {
		return mercado.saveCliente(cliente);
	}
	
	@PutMapping("atualizarCliente")
    public Cliente atualizarCliente(@RequestBody Cliente antigoCliente, Cliente novoCliente) {
        return mercado.updateCliente(antigoCliente, novoCliente);
    }
	
	@GetMapping("cliente")
	public List<Cliente> listarClientees(){
		return mercado.listAllCliente();
	}
	
	@GetMapping("/cliente{idCliente}")
	public Optional<Cliente> findByIdCliente(@PathVariable long idCliente){
		return mercado.findByIdCliente(idCliente);
	}
	
	@GetMapping("nomeCliente")
	public Optional<Cliente> findByNomeCliente(@RequestBody String nome){
		return mercado.findByNomeCliente(nome);
	}
	
	@GetMapping("cpfCliente")
	public Optional<Cliente> findByCpfCliente(@RequestBody String cpf){
		return mercado.findByCpfCliente(cpf);
	}
	
	@DeleteMapping("/deleteCliente{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteByIdCliente(@PathVariable long idCliente) {
		mercado.deleteByIdCliente(idCliente);
	}
	
	@DeleteMapping("Cliente")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCliente(Cliente cliente) {
		mercado.deleteCliente(cliente);
	}

}
