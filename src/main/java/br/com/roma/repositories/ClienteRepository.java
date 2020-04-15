package br.com.roma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roma.domain.enums.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer>  {

	
	
	
}
