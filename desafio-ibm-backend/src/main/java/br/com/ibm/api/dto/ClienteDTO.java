package br.com.ibm.api.dto;

import java.math.BigDecimal;
import java.util.List;

public class ClienteDTO {

	private Long id;

    private String nome;

    private Long idade;
    
    private String email;
    
    private String numeroConta;
    
    private BigDecimal saldo;
    
    private BigDecimal valor;
    
    private String operacao;
    
    private List<ExtratoDTO> extrato;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
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

	public List<ExtratoDTO> getExtrato() {
		return extrato;
	}

	public void setExtrato(List<ExtratoDTO> extrato) {
		this.extrato = extrato;
	}

}
