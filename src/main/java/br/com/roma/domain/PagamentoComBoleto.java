package br.com.roma.domain;

import java.util.Date;

import br.com.roma.domain.enums.Cliente;
import br.com.roma.domain.enums.Endereco;
import br.com.roma.domain.enums.EstadoPagamento;

public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataDePagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataDePagamento;
		this.dataVencimento= dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	
	
	
	
}
