package br.com.ibm.api.util;

import java.util.Comparator;

import br.com.ibm.entity.cliente.Extrato;

public class ExtratoComparator implements Comparator<Extrato> {

	@Override
	public int compare(Extrato item1, Extrato item2) {
		Long nomePessoa1 = item1.getId();
		Long nomePessoa2 = item2.getId();
		return nomePessoa1.compareTo(nomePessoa2);
	}
}