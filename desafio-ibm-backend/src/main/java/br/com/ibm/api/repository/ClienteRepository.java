package br.com.ibm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibm.entity.cliente.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
