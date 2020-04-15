package br.com.roma.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.roma.domain.enums.Cliente;
import br.com.roma.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository service ; 
	
	
	public Cliente buscarPorId(Integer cod) {
		
		Optional<Cliente> obj =  service.findById(cod);
		
		return obj.orElse(null);
	} 
	
	
}
