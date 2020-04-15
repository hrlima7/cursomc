package br.com.roma.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.roma.domain.enums.Cliente;
import br.com.roma.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ResourceCliente {
	
	@Autowired
	ClienteService source;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity buscar(@PathVariable Integer id) {
		
		Cliente obj = source.buscarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}

	
	
}
