package br.com.roma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.roma.domain.Categoria;
import br.com.roma.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;
	
	
	public List<Categoria> buscarAll() {
		
		List<Categoria> list = repo.findAll();
		
		return list;
	}
	
	public Categoria buscarporId(Integer id) {
	
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElse(null);
	}
	
	public Categoria insert (Categoria obj ) {
		obj.setId(null);
		return repo.save(obj);
		
	
	}
	
	public Categoria update(Categoria obj) {
		
		return repo.save(obj);
	}
	
	
}
