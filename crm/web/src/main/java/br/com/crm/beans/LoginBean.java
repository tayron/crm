package br.com.crm.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletException;

import br.com.crm.encapsuladores.UsuarioDadosSessaoEncapsulador;
import br.com.crm.encapsuladores.UsuarioEncapsulador;
import br.com.crm.excecoes.ExcecaoServico;
import br.com.crm.servicos.IServicoUsuario;
import br.com.crm.utils.FacesUtils;
import br.com.crm.utils.Mensagem;

/**
 * Classe que gerencia as solicitações da tela de login
 */
@ManagedBean
@RequestScoped
public class LoginBean {

	/**
	 * Injeção do serviço usuário para manipulação de dados
	 */
	@EJB
	private IServicoUsuario servicoUsuario;
	
	/**
	 * Armazena o login do usuário
	 */
	private String login;
	
	/**
	 * Armazena a senha do usuário
	 */
	private String senha;
	
	/**
	 * Método que loga o usuário no sistema
	 */
	public String efetuarLogin() {
		try {
			// Autenticando usuário
			FacesUtils.getRequest().login(login, senha);
//			FacesUtils.getSession().setAttribute("usuario", FacesUtils.getRequest().getUserPrincipal());
			
			// Buscando os dados do usuário no banco
			UsuarioEncapsulador parametros = new UsuarioEncapsulador();
			parametros.setLogin(FacesUtils.getRequest().getUserPrincipal().toString());			
			UsuarioDadosSessaoEncapsulador usuarioDTO = servicoUsuario.consultarPorLogin(parametros);
			
			// Guardando os dados do usuário na sessão
			FacesUtils.getSession().setAttribute("usuario", usuarioDTO);
			
			return "/pages/admin/index.xhtml";
		} catch (ServletException e) {
			Mensagem mensagem = new Mensagem();
			mensagem.exibirErro(null, "Acesso negado");
		}catch (ExcecaoServico e) {
			Mensagem mensagem = new Mensagem();
			mensagem.exibirErro(null, e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * Método que desloga o usuário do sistema
	 */
	public String efetuarLogout() {
		try {
			FacesUtils.getRequest().logout();
			FacesUtils.removeObjectInSession("usuario");
			return "/pages/login.xhtml";
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Método que retorna o nome do usuário logado
	 */
	public String getNomeUsuarioLogado(){
		UsuarioDadosSessaoEncapsulador usuarioDTO = (UsuarioDadosSessaoEncapsulador) FacesUtils.getObjectInSession("usuario");
		return usuarioDTO.getNome();
	}

	/**
	 * Retorna o login do usuário
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Senha o login do usuário
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Retorna a senha do usuário
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Seta a senha do usuário
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
