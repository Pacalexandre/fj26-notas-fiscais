package br.com.caelum.notasfiscais.modelo;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal> {

	private static final long serialVersionUID = 1L;

	@Inject
	private NotaFiscalDao dao;

	@PostConstruct
	void inicializationTotal() {
		this.setRowCount(dao.contaTodos());
	}

	public List<NotaFiscal> load(int inicio, int quantidade, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		return dao.listaTodosPaginada(inicio, quantidade);

	}

}
