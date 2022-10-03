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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mercado_POO.basica.Cliente;
import com.example.Mercado_POO.basica.Venda;
import com.example.Mercado_POO.excecoes.QuantidadeNegativaException;
import com.example.Mercado_POO.fachada.Mercado;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@CrossOrigin(origins="http://localhost:8080/")
@RestController
@RequestMapping("/venda")
public class ControllerVenda {
	
	@Autowired
	private Mercado mercado;

	@PostMapping("/inserir")
    @ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Object> criarVenda(@RequestBody Venda venda) throws JSONException, ParseException, QuantidadeNegativaException {
		/*try {
			mercado.saveVenda(venda);
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}catch (QuantidadeNegativaException e) {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error",e);
			return new ResponseEntity<>(resp,  HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}*/
		if(mercado.saveVenda(venda) != null) {
			 Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("ok", "successfully");
			return new ResponseEntity<Object>(resp,HttpStatus.OK);
		}else {
			Map<String, Object> resp = new HashMap<String, Object>();
			 resp.put("Error", "Error");
			return new ResponseEntity<>(resp,  HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("venda")
	public List<Venda> listarVendas(){
		return mercado.listAllVenda();
	}
	
	@GetMapping("/{idVenda}")
	public Optional<Venda> findById(@PathVariable long idVenda){
		return mercado.findByIdVenda(idVenda);
	}
	
	@GetMapping("/cliente/venda{idClienteVenda}")
	public Optional<Venda> findByClienteId(@PathVariable long idClienteVenda){
		return mercado.findByClienteVendaId(idClienteVenda);
	}
	
	@GetMapping("/vendedor/venda{idVendedorVenda}")
	public Optional<Venda> findByVendedorId(@PathVariable long idVendedorVenda){
		return mercado.findByVendedorVendaId(idVendedorVenda);
	}
	
	@DeleteMapping("/{idVenda}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long idVenda) {
		mercado.deleteByIdVenda(idVenda);
	}
	
	@DeleteMapping("venda")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteVenda(Venda venda) {
		mercado.deleteVenda(venda);
	}
	
	public static Date parseDate(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.parse(data);
    }
	
}
