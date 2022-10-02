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
import com.example.Mercado_POO.basica.Vendedor;
import com.example.Mercado_POO.fachada.Mercado;

//@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/vendedor")
public class ControllerVendedor {

	@Autowired
	private Mercado mercado;
	
	//@PostMapping("cadastrar")
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Object> cadastrarVendedor(@RequestBody Vendedor vendedor) throws JSONException, ParseException{
		/*Date data = new Date();
		JSONObject obj = new JSONObject(dados);
		String nome = obj.getString("nome");
		String cpf = obj.getString("cpf");
		String sexo = obj.getString("sexo");
		Date dataNascimento = parseDate(obj.getString("dataNascimento"));
		String email = obj.getString("email");
		String cargo = obj.getString("cargo");
		double salario = obj.getDouble("salario");
		Date dataContrato = parseDate(obj.getString("dataContrato"));
		Endereco endereco =  controllerEndereco.cadastrarEndereco(dados);
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(nome);
		vendedor.setCpf(cpf);
		vendedor.setSexo(sexo);
		vendedor.setDataNascimento(dataNascimento);
		vendedor.setEmail(email);
		vendedor.setCargo(cargo);
		vendedor.setSalario(salario);
		vendedor.setDataContrato(dataContrato);
		vendedor.setEnderecoPessoa(endereco);*/
		if(mercado.saveVendedor(vendedor) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("atualizarVendedor")
    public Vendedor atualizarVendedor(@RequestBody long antigoVendedorId, Vendedor novoVendedor) {
        return mercado.updateVendedor(antigoVendedorId, novoVendedor);
    }
	
	@GetMapping("vendedor")
	public List<Vendedor> listarVendedores(){
		return mercado.listAllVendedor();
	}
	
	@GetMapping("/vendedor{idVendedor}")
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
	
	@DeleteMapping("/vendedor{idVendedor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteByIdVendedor(@PathVariable long idVendedor) {
		mercado.deleteByIdVendedor(idVendedor);
	}
	
	@DeleteMapping("Vendedor")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteVendedor(Vendedor vendedor) {
		mercado.deleteVendedor(vendedor);
	}
	
	public static Date parseDate(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.parse(data);
    }
}
