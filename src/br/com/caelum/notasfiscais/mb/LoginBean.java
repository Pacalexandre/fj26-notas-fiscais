package br.com.caelum.notasfiscais.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean {
	
	@Inject
	UsuarioDao dao;
	@Inject
	UsuarioLogadoBean usuarioLogado;
	
	Usuario usuario = new Usuario();

	public String efetuaLogin() {
		
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			usuarioLogado.logar(usuario);
			return "produto?faces-redirect=true";
		} else {
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public String logout() {
		usuarioLogado.deslogar();
		return "login";
	}
	public Usuario getUsuario() {
		return this.usuario;
	}

}
