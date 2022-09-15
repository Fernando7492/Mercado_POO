package com.example.Mercado_POO.controller;

import java.util.Date;
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

import com.example.Mercado_POO.basica.Produto;
import com.example.Mercado_POO.fachada.Mercado;

@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/mercado/api/")
public class ControllerProduto {
	
	@Autowired
	private Mercado mercado;
	
	@PostMapping("produto")
    @ResponseStatus(code = HttpStatus.CREATED)
	public Produto criarProduto(@RequestBody Produto produto) {
		return mercado.saveProduto(produto);
	}
	
	@GetMapping("Produto")
	public List<Produto> listarProdutos(){
		return mercado.listAllProduto();
	}
	@GetMapping("/{id}")
	public Optional<Produto> findById(@PathVariable long id){
		return mercado.findProdutoById(id);
	}
	@GetMapping("Produto")
	public Optional<Produto> findProdutoByNome(@RequestBody String nome){
		return mercado.findByNomeProduto(nome);
	}
	@PutMapping("/{id}")
    public Produto atualizarProduto(@RequestBody Produto antigoProduto, Produto novoProduto) {
        return mercado.updateProduto(antigoProduto, novoProduto);
    }
	@GetMapping("Produto")
	public Optional<Produto> findByCategoriaProduto(String categoria){
		return mercado.findByCategoriaProduto(categoria);
	}
	@GetMapping("Produto")
	public Optional<Produto> findByValidadeProduto(Date validadeProdutoMin,Date validadeProdutoMax){
		return mercado.findByValidadeProduto(validadeProdutoMin,validadeProdutoMax);
	} 
	
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) {
		mercado.deleteProdutoById(id);
	}
	
	@DeleteMapping("Produto")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteFornecedor(Produto produto) {
		mercado.deleteProduto(produto);
	}
	
}