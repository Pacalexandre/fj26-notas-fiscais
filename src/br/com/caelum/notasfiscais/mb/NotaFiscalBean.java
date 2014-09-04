package br.com.caelum.notasfiscais.mb;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
@ViewScoped
public class NotaFiscalBean {

	private Item item = new Item();
	private NotaFiscal nf = new NotaFiscal();
	private Long idProduto;
	
	@Inject
	private NotaFiscalDao notaFiscalDao;
	
	@Inject
	private ProdutoDao produtoDao;
	
	public void grava(){
		this.notaFiscalDao.adiciona(nf);
		this.nf=new NotaFiscal();
	}
	
	public NotaFiscal getNotaFiscal(){
		return nf;
	}
	
	public void guardaItem(){
		Produto produto = produtoDao.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		nf.getItens().add(item);
		item.setNotaFiscal(nf);
		item = new Item();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public NotaFiscal getNf() {
		return nf;
	}

	public void setNf(NotaFiscal nf) {
		this.nf = nf;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public NotaFiscalDao getNotaFiscalDao() {
		return notaFiscalDao;
	}

	public void setNotaFiscalDao(NotaFiscalDao notaFiscalDao) {
		this.notaFiscalDao = notaFiscalDao;
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	
	
}
