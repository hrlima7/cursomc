package br.com.roma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.roma.domain.Categoria;
import br.com.roma.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado, Integer>  {

	
	
	
}
