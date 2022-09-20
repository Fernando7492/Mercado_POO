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

import com.example.Mercado_POO.basica.Vendedor;
import com.example.Mercado_POO.fachada.Mercado;

@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/mercado/api/")
public class ControllerVendedor {

	@Autowired
	private Mercado mercado;
	
	@PostMapping("vendedor")
    @ResponseStatus(code = HttpStatus.CREATED)
	public Vendedor criarVendedor(@RequestBody Vendedor vendedor) {
		return mercado.saveVendedor(vendedor);
	}
	
	@PutMapping("atualizarVendedor")
    public Vendedor atualizarVendedor(@RequestBody Vendedor antigoVendedor, Vendedor novoVendedor) {
        return mercado.updateVendedor(antigoVendedor, novoVendedor);
    }
	
	@GetMapping("vendedor")
	public List<Vendedor> listarVendedores(){
		return mercado.listAllVendedor();
	}
	
	@GetMapping("/{idVendedor}")
	public Optional<Vendedor> findByIdVendedor(@PathVariable long idVendedor){
		return mercado.findByIdVendedor(idVendedor);
	}
	
	@GetMapping("nomeVendedor")
	public Optional<Vendedor> findByNomeVendedor(@RequestBody String nome){
		return mercado.findByNomeVendedor(nome);
	}
	
	@GetMapping("cpfVendedor")
	public Optional<Vendedor> findByCpfVendedor(@RequestBody String cpf){
		return mercado.findByCpfVendedor(cpf);
	}
	
	@DeleteMapping("/{idVendedor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteByIdVendedor(@PathVariable long idVendedor) {
		mercado.deleteByIdVendedor(idVendedor);
	}
	
	@DeleteMapping("Vendedor")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteVendedor(Vendedor vendedor) {
		mercado.deleteVendedor(vendedor);
	}
}
