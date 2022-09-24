package com.example.Mercado_POO.controller;

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
import com.example.Mercado_POO.basica.Pessoa;
import com.example.Mercado_POO.fachada.Mercado;

//@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/cliente")
public class ControllerCliente {
	
	@Autowired
	private Mercado mercado;
	@Autowired
	private ControllerEndereco controllerEndereco;
	
	//@PostMapping("cadastrar")
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Object> cadastrarCliente(@RequestBody String dados) throws JSONException, ParseException{
		Date data = new Date();
		JSONObject obj = new JSONObject(dados);
		String nome = obj.getString("nome");
		String cpf = obj.getString("cpf");
		String sexo = obj.getString("sexo");
		Date dataNascimento = parseDate(obj.getString("dataNascimento"));
		String email = obj.getString("email");
		Endereco endereco =  controllerEndereco.cadastrarEndereco(dados);
		//Cliente cliente = (Cliente) new Pessoa(nome,cpf,sexo,dataNascimento,email,endereco);
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setSexo(sexo);
		cliente.setDataNascimento(dataNascimento);
		cliente.setEmail(email);
		cliente.setEnderecoPessoa(endereco);
		if(mercado.saveCliente(cliente) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("atualizarCliente")
    public Cliente atualizarCliente(@RequestBody Cliente antigoCliente, Cliente novoCliente) {
        return mercado.updateCliente(antigoCliente, novoCliente);
    }
	
	@GetMapping("cliente")
	public List<Cliente> listarClientees(){
		return mercado.listAllCliente();
	}
	
	@GetMapping("/{idCliente}")
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
	
	@DeleteMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteByIdCliente(@PathVariable long idCliente) {
		mercado.deleteByIdCliente(idCliente);
	}
	
	@DeleteMapping("Cliente")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCliente(Cliente cliente) {
		mercado.deleteCliente(cliente);
	}
	
	public static Date parseDate(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.parse(data);
    }

}
