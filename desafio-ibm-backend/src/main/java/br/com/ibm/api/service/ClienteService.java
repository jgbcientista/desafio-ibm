package br.com.ibm.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ibm.api.dto.ClienteDTO;
import br.com.ibm.api.dto.ExtratoDTO;
import br.com.ibm.api.repository.ClienteRepository;
import br.com.ibm.api.repository.ExtratoRepository;
import br.com.ibm.entity.cliente.Cliente;
import br.com.ibm.entity.cliente.Extrato;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ExtratoRepository extratoRepository;

	public ClienteDTO findById(Long idCliente) {
		var cliente = new ClienteDTO();
		var item = this.repository.findById(idCliente);
		BeanUtils.copyProperties(item.get(), cliente);
		// recuepra o extrato do cliente
		cliente.setExtrato(findExtratoByCliente(cliente.getId()));
		return cliente;
	}

	public List<ClienteDTO> all() {
		List<ClienteDTO> lista = new ArrayList<>();

		var lis = this.repository.findAll();

		lis.forEach(item -> {
			ClienteDTO cliente = new ClienteDTO();
			BeanUtils.copyProperties(item, cliente);
			// recuepra o extrato do cliente
			cliente.setExtrato(findExtratoByCliente(cliente.getId()));
			lista.add(cliente);
		});

		return lista;
	}

	@Transactional
	public ClienteDTO criar(ClienteDTO obj) {
		var entity = new Cliente();
		BeanUtils.copyProperties(obj, entity);
		// Persiste o dado na na base dedados
		entity = this.repository.save(entity);
		// salva o extrato
		Extrato extrato = new Extrato();
		extrato.setIdCliente(entity.getId());
		extrato.setOperacao("creditar");
		extrato.setValor(obj.getSaldo());
		extrato.setDataOperacao(LocalDateTime.now());
		extrato = extratoRepository.save(extrato);

		BeanUtils.copyProperties(entity, obj);

		return obj;
	}

	@Transactional
	public ClienteDTO creditarDebitar(ExtratoDTO obj) {
		var newObj = repository.findById(obj.getIdCliente());
		ClienteDTO response = null;
		if (newObj.isPresent() && obj.getValor() != null) {
			var entity = newObj.get();

			if (obj.getOperacao().equals("creditar")) {
				// Realiza o credito da conta
				entity.setSaldo(entity.getSaldo().add(obj.getValor()));
				entity = this.repository.save(entity);
				BeanUtils.copyProperties(entity, obj);

			} else if (obj.getOperacao().equals("debitar")) {
				// Realiza o debito da conta
				entity.setSaldo(entity.getSaldo().subtract(obj.getValor()));
				entity = this.repository.save(entity);
				BeanUtils.copyProperties(entity, obj);
			}
			// salva o extrato
			response = new ClienteDTO();
			BeanUtils.copyProperties(entity, response);
			createExtrato(obj, entity.getId());
		}
		return response;
	}

	private void createExtrato(ExtratoDTO obj, Long idCliente) {
		Extrato extrato = new Extrato();
		extrato.setIdCliente(idCliente);
		extrato.setOperacao(obj.getOperacao());
		extrato.setValor(obj.getValor());
		extrato.setDataOperacao(LocalDateTime.now());
		extrato = extratoRepository.save(extrato);
	}

	public List<ExtratoDTO> findExtratoByCliente(Long idCliente) {
		List<ExtratoDTO> lista = new ArrayList<>();

		var lis = this.extratoRepository.findByIdCliente2(idCliente);

		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");

		lis.forEach(item -> {
			ExtratoDTO extratoDTO = new ExtratoDTO();
			BeanUtils.copyProperties(item, extratoDTO);
			extratoDTO.setIdCliente(idCliente);
			extratoDTO.setDataOperacaoFormatada(formatterHora.format(item.getDataOperacao()));
			lista.add(extratoDTO);
		});
		
		return lista;
	}

}