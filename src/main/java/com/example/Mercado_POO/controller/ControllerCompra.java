package com.example.Mercado_POO.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.Compra;
import com.example.Mercado_POO.excecoes.QuantidadeNegativaException;
import com.example.Mercado_POO.fachada.Mercado;

//@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/compra")
public class ControllerCompra {
	
	@Autowired
	private Mercado mercado;

	@PostMapping("/inserir")
    @ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Object> criarCompra(@RequestBody Compra compra) throws QuantidadeNegativaException {
		if(mercado.saveCompra(compra) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("compra")
	public List<Compra> listarCompras(){
		return mercado.listAllCompra();
	}
	
	@GetMapping("/compra{idCompra}")
	public Optional<Compra> findByIdCompra(@PathVariable long idCompra){
		return mercado.findByIdCompra(idCompra
				);
	}
	
	@GetMapping("/fornecedor/compra{idFornecedorCompra}")
	public Optional<Compra> findByFornecedorId(@PathVariable long idFornecedorCompra){
		return mercado.findByFornecedorCompraId(idFornecedorCompra);
	}
	
	@DeleteMapping("/compra{idCompra}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteByIdCompra(@PathVariable long idCompra) {
		mercado.deleteByIdCompra(idCompra);
	}
	
	@DeleteMapping("compra")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCompra(@RequestBody Compra compra) {
		mercado.deleteCompra(compra);
	}
	
	
	
}
