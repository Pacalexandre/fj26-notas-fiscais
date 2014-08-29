package br.com.caelum.notasfiscais.mb;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@Named
public class ProdutoBean {
	
	@Inject
	private ProdutoDao dao;

	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public List<Produto> getProdutos(){
		if (produtos == null) {
			System.out.println("Carregando produtos ...");
			produtos = this.dao.listaTodos();
		}
		return produtos;
	}
	
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto){
		this.produto = produto;
	}
	
	public void grava() {		
		if (produto.getId() ==null){
			this.dao.adiciona(produto);
		}else{
			this.dao.atualiza(produto);
		}
		
		this.produtos = this.dao.listaTodos();
		this.produto = new Produto(); //limpar a tela 
	}
	
	public void remove(Produto prod){
		this.dao.remove(prod);
		this.produtos = this.dao.listaTodos();
		this.produto = new Produto(); //limpar a tela 
	}
	
	public void altera(Produto prod){
		this.dao.atualiza(prod);
		this.produtos = this.dao.listaTodos();
		this.produto = new Produto(); //limpar a tela 
		
	}
	
	public void cancela(){
		this.produtos = this.dao.listaTodos();
		this.produto = new Produto();
	}
	
	
	
}
