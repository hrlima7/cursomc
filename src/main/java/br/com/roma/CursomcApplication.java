package br.com.roma;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.roma.domain.Categoria;
import br.com.roma.domain.Cidade;
import br.com.roma.domain.Estado;
import br.com.roma.domain.Pagamento;
import br.com.roma.domain.PagamentoComBoleto;
import br.com.roma.domain.PagamentoComCartao;
import br.com.roma.domain.Pedido;
import br.com.roma.domain.Produto;
import br.com.roma.domain.enums.Cliente;
import br.com.roma.domain.enums.Endereco;
import br.com.roma.domain.enums.EstadoPagamento;
import br.com.roma.domain.enums.TipoCliente;
import br.com.roma.repositories.CategoriaRepository;
import br.com.roma.repositories.CidadeRepository;
import br.com.roma.repositories.ClienteRepository;
import br.com.roma.repositories.EnderecoRepository;
import br.com.roma.repositories.EstadoRepository;
import br.com.roma.repositories.PagamentoRepository;
import br.com.roma.repositories.PedidoRepository;
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
	@Autowired
	private EnderecoRepository endRepo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private PedidoRepository pedRepo;
	@Autowired
	private PagamentoRepository pagrepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"informatica");
		Categoria cat2 = new Categoria(null,"escritorio");
		
		Produto p1 = new Produto(null,"teclado",20.0);
		Produto p2 = new Produto(null,"impressora",340.0);
		Produto p3 = new Produto(null,"mouse",20.0);
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		cat1.getProdutos().addAll(Arrays.asList(p1,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
	

		repoCat.saveAll(Arrays.asList(cat1,cat2));
		repoProd.saveAll(Arrays.asList(p1,p2,p3));
	
		Estado e1 = new Estado(null,"Bahia");
		Estado e2 = new Estado(null,"Rio de Janeiro");
		
		repoEst.saveAll(Arrays.asList(e1,e2));
		
		Cidade c1 = new Cidade(null,"Rio Real",e1);
		Cidade c2 = new Cidade(null, "Esplanada",e1);
		Cidade c3 = new Cidade(null, "PETROPOLES", e2);
		
	
		
		
		Cliente cli1 = new Cliente(null,"Henrique Roma,","hrlima7@gmail.com","012.794.105-31",TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("3372-1519","987630665"));
		
	
		
		
		Endereco end1 = new Endereco(null,"Rua das acassias","723","Condominio das flores","Sussuarana","41213-122",cli1,c3);
		
		repoCid.saveAll(Arrays.asList(c1,c2,c3));
		cliRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(end1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("17/04/2020 10:00"),cli1,end1) ;
		Pedido ped2 = new Pedido(null,sdf.parse("10/03/2020 10:00"),cli1,end1) ;
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("05/08/2020 23:43"), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedRepo.saveAll(Arrays.asList(ped1,ped2));
		pagrepo.saveAll(Arrays.asList(pgto1,pgto2));
		
		
	}

}
