package br.com.roma;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.roma.domain.Categoria;
import br.com.roma.domain.Cidade;
import br.com.roma.domain.Estado;
import br.com.roma.domain.Produto;
import br.com.roma.repositories.CategoriaRepository;
import br.com.roma.repositories.CidadeRepository;
import br.com.roma.repositories.EstadoRepository;
import br.com.roma.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repoCat;
	
	@Autowired
	private ProdutoRepository repoProd;
	@Autowired
	private CidadeRepository repoCid;
	@Autowired
	private EstadoRepository repoEst;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(1,"informatica");
		Categoria cat2 = new Categoria(2,"escritorio");
		
		Produto p1 = new Produto(1,"teclado",20.0);
		Produto p2 = new Produto(2,"impressora",340.0);
		Produto p3 = new Produto(3,"mouse",20.0);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		cat1.getProdutos().addAll(Arrays.asList(p1,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		repoCat.saveAll(Arrays.asList(cat1,cat2));
		repoProd.saveAll(Arrays.asList(p1,p2,p3));
	
		Estado e1 = new Estado(null,"Bahia");
		Estado e2 = new Estado(null,"Rio de Janeiro");
		
		
		Cidade c1 = new Cidade(null,"Entre Rios",e1);
		Cidade c2 = new Cidade(null, "Esplanada",e1);
		Cidade c3 = new Cidade(null, "Niteori", e2);
		
		repoEst.saveAll(Arrays.asList(e1,e2));
		repoCid.saveAll(Arrays.asList(c1,c2,c3));
		
	
	
	}

}
