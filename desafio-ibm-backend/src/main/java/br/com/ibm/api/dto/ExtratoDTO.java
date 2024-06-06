package br.com.ibm.api.dto;

import java.math.BigDecimal;

public class ExtratoDTO {

	private Long id;

    private Long idCliente;

    private String operacao;
    
    private BigDecimal valor;
    
    private String dataOperacaoFormatada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDataOperacaoFormatada() {
		return dataOperacaoFormatada;
	}

	public void setDataOperacaoFormatada(String dataOperacaoFormatada) {
		this.dataOperacaoFormatada = dataOperacaoFormatada;
	}
	

}
