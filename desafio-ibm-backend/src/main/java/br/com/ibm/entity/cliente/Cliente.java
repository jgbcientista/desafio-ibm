package br.com.ibm.entity.cliente;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Cliente.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente{
	public static final String TABLE_NAME = "TB_CLIENTE";
	
	@Id
	@Column(name = "ID_CLIENTE", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "NOME_CLIENTE")
    @Schema(description = "Nome do cliente")
    private String nome;

    @Column(name = "IDADE_CLIENTE")
    @Schema(description = "Idade do cliente")
    private Long idade;
    
    @Column(name = "EMAIL_CLIENTE")
    @Schema(description = "E-mail do cliente")
    private String email;
    
    @Column(name = "NUMERO_CLIENTE")
    @Schema(description = "Numero da conta do cliente")
    private String numeroConta;
    
    @Column(name = "SALDO_CLIENTE")
    private BigDecimal saldo;
    
}
