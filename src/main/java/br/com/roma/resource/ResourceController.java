package br.com.roma.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roma.domain.Categoria;

@RestController
public class ResourceController {

	@RequestMapping("/categoria")
	public List<Categoria> Categorizar() {
		
		Categoria cat1 = new Categoria(1,"celular");
		Categoria cat2 = new Categoria(2, "NoteBook");
		
		
		
		List<Categoria> lista = new ArrayList();
		
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
		
	}
}
