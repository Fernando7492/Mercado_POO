package com.example.Mercado_POO.controller;

import java.text.ParseException;
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
import com.example.Mercado_POO.basica.Fornecedor;
import com.example.Mercado_POO.fachada.Mercado;

//@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/fornecedor")
public class ControllerFornecedor {
	
	@Autowired
	private Mercado mercado;
	@Autowired
	private ControllerEndereco controllerEndereco;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Object> cadastrarFornecedor(@RequestBody String dados) throws JSONException, ParseException{
		Date data = new Date();
		JSONObject obj = new JSONObject(dados);
		String nome = obj.getString("nome");
		String cnpj = obj.getString("cnpj");
		String telefone = obj.getString("telefone");
		String email = obj.getString("email");
		Endereco endereco =  controllerEndereco.cadastrarEndereco(dados);
		//Cliente cliente = (Cliente) new Pessoa(nome,cpf,sexo,dataNascimento,email,endereco);
		Fornecedor fornecedor = new Fornecedor(nome, cnpj, email, telefone, endereco);
		if(mercado.saveFornecedor(fornecedor) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("atualizarFornecedor")
    public Fornecedor atualizarFornecedor(@RequestBody Fornecedor antigoFornecedor, Fornecedor novoFornecedor) {
        return mercado.updateFornecedor(antigoFornecedor, novoFornecedor);
    }
	
	@GetMapping("fornecedor")
	public List<Fornecedor> listarFornecedores(){
		return mercado.listAllFornecedor();
	}
	
	@GetMapping("/{idFornecedor}")
	public Optional<Fornecedor> findByIdFornecedor(@PathVariable long idFornecedor){
		return mercado.findByIdFornecedor(idFornecedor);
	}
	
	@GetMapping("nomeFornecedor")
	public Optional<Fornecedor> findByNomeFornecedor(@RequestBody String nome){
		return mercado.findByNomeFornecedor(nome);
	}
	
	@GetMapping("cnpj")
	public Optional<Fornecedor> findByCnpjFornecedor(@RequestBody String cnpj){
		return mercado.findByCnpjFornecedor(cnpj);
	}
	
	@DeleteMapping("/{idFornecedor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteByIdFornecedor(@PathVariable long idFornecedor) {
		mercado.deleteByIdFornecedor(idFornecedor);
	}
	
	@DeleteMapping("Fornecedor")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteFornecedor(Fornecedor fornecedor) {
		mercado.deleteFornecedor(fornecedor);
	}
	

}
