package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.modelo.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@Named
@ViewScoped
public class ListaNotasFiscalBean {
	
	@Inject
	private NotaFiscalDao dao;
	
	@Inject
	private DataModelNotasFiscais dataModel;
	
	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}

	public List<NotaFiscal> getNotasFiscais(){
		List<NotaFiscal> notas = dao.listaTodos();
		return notas;
	}
}
