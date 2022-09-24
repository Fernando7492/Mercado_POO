package com.example.Mercado_POO.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.Endereco;
import com.example.Mercado_POO.basica.Pessoa;
import com.example.Mercado_POO.fachada.Mercado;

@RestController
@RequestMapping("/endereco")
public class ControllerEndereco {

	@Autowired
	private Mercado mercado;
	
	//@PostMapping("cadastrar")
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public Endereco cadastrarEndereco(@RequestBody String dados){
		Date data = new Date();
		JSONObject obj = new JSONObject(dados);
		String logradouro = obj.getString("logradouro");
		String cep = obj.getString("cep");
		String cidade = obj.getString("cidade");
		String uf = obj.getString("uf");
		String bairro = obj.getString("bairro");
		String numero = obj.getString("numero");
		Endereco endereco =  new Endereco(logradouro, uf, cidade, bairro, numero, cep);
		return mercado.saveEndereco(endereco);
		/*if(mercado.saveEndereco(endereco) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(endereco,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}*/
	}
}
