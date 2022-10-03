package com.example.Mercado_POO.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.Cliente;
import com.example.Mercado_POO.basica.Endereco;
import com.example.Mercado_POO.basica.Produto;
import com.example.Mercado_POO.excecoes.ProdutoInexistenteException;
import com.example.Mercado_POO.fachada.Mercado;
import com.fasterxml.jackson.core.io.BigDecimalParser;

//@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/produto")
public class ControllerProduto {
	
	@Autowired
	private Mercado mercado;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Object> cadastrarProduto(@RequestBody Produto produto) throws JSONException, ParseException{
		if(mercado.saveProduto(produto) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("listarTodos")
	public List<Produto> listarProdutos(){
		return mercado.listAllProduto();
	}
	@GetMapping("/produto{idProduto}")
	public Optional<Produto> findById(@PathVariable long idProduto){
		return mercado.findProdutoById(idProduto);
	}
	@GetMapping("/{nome}")
	public Optional<Produto> findProdutoByNome(@PathVariable String nome){
		return mercado.findByNomeProduto(nome);
	}
	@PostMapping("/editar")
    public ResponseEntity<Object> atualizarProduto(@RequestBody Produto novoProduto) {
		if(mercado.updateProduto( novoProduto) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
    }
	@GetMapping("/{categoria}")
	public Optional<Produto> findByCategoriaProduto(@PathVariable String categoria){
		return mercado.findByCategoriaProduto(categoria);
	}
	
	@DeleteMapping("/delete/{id}") 
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id)throws ProdutoInexistenteException {
		mercado.deleteProdutoById(id);
	}
	
	@DeleteMapping("Produto")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProduto(Produto produto) {
		mercado.deleteProduto(produto);
	}
	
	public static Date parseDate(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.parse(data);
    }
	
}