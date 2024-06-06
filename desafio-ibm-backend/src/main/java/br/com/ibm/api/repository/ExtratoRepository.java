package br.com.ibm.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ibm.entity.cliente.Extrato;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Long> {
	
	@Query(value = "SELECT * FROM TB_EXTRATO ex WHERE ex.ID_CLIENTE = :idCliente ORDER BY ID_EXTRATO DESC", nativeQuery = true)
	List<Extrato> findByIdCliente2(Long idCliente);
}
