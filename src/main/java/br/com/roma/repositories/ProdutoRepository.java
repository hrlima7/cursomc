package br.com.roma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.roma.domain.Categoria;
import br.com.roma.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>  {

	
	
	
}
