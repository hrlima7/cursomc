package br.com.roma.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roma.domain.Categoria;

@Repository
@Transactional
public interface CategoriaRepository extends JpaRepository <Categoria, Integer>  {


	
	
}
