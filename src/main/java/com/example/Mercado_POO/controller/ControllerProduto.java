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
import com.example.Mercado_POO.fachada.Mercado;
import com.fasterxml.jackson.core.io.BigDecimalParser;

//@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/produto")
public class ControllerProduto {
	
	@Autowired
	private Mercado mercado;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Object> cadastrarProduto(@RequestBody String dados) throws JSONException, ParseException{
		Date data = new Date();
		JSONObject obj = new JSONObject(dados);
		String nome = obj.getString("nome");
		String categoria = obj.getString("categoria");
		BigDecimal vVenda = new BigDecimal(obj.getDouble("vVenda"));
		BigDecimal vCompra = new BigDecimal(obj.getDouble("vCompra"));
		int quantidade = obj.getInt("quantidade");
		Date validade = parseDate(obj.getString("validade"));
		Produto produto = new Produto(nome, categoria, vCompra, vVenda, quantidade, validade);
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
	
	@GetMapping("Produtos")
	public List<Produto> listarProdutos(){
		return mercado.listAllProduto();
	}
	@GetMapping("/{idProduto}")
	public Optional<Produto> findById(@PathVariable long idProduto){
		return mercado.findProdutoById(idProduto);
	}
	@GetMapping("/{nome}")
	public Optional<Produto> findProdutoByNome(@PathVariable String nome){
		return mercado.findByNomeProduto(nome);
	}
	@PutMapping("produtos")
    public Produto atualizarProduto(@RequestBody Produto antigoProduto, Produto novoProduto) {
        return mercado.updateProduto(antigoProduto, novoProduto);
    }
	@GetMapping("/{categoria}")
	public Optional<Produto> findByCategoriaProduto(@PathVariable String categoria){
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
	public void deleteProduto(Produto produto) {
		mercado.deleteProduto(produto);
	}
	
	public static Date parseDate(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.parse(data);
    }
	
}