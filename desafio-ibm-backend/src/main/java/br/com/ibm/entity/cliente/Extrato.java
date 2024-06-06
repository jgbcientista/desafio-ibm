package br.com.ibm.entity.cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = Extrato.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Extrato{
	public static final String TABLE_NAME = "TB_EXTRATO";
	
	@Id
	@Column(name = "ID_EXTRATO", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "ID_CLIENTE")
    @Schema(description = "ID do cliente")
    private Long idCliente;

    @Column(name = "OPERACAO_EXTRATO")
    @Schema(description = "Operação realizada pelo cliente")
    private String operacao;
    
    @Column(name = "DATA_OPERACAO")
    @Schema(description = "Data da operação realizada pelo cliente")
    private LocalDateTime dataOperacao;
    
    @Column(name = "VALOR_EXTRATO")
    @Schema(description = "Valor da operação realizada pelo cliente")
    private BigDecimal valor;
    
    
}
