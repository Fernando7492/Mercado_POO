package com.example.Mercado_POO.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfiguracaoController {

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> validarConfiguração(@RequestBody String dados) {
System.out.println("ENTROU AQUI NA CONFIGURAÇÃO");
		JSONObject obj = new JSONObject(dados);
		String banco = obj.getString("nameDataBase");
		String porta = obj.getString("dataBasePort");
		String servidor = obj.getString("ipDataBase");
		String usuario = obj.getString("userDataBase");
		String senha = obj.getString("passwordDataBase");
		if(banco.equals("mercado")
		   && porta.equals("5432")
		   && servidor.equals("localhost")
		   && usuario.equals("postgres")
		   && senha.equals("123")
		) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
	}
}
