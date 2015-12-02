package br.com.crm.servico.dto;

import java.util.List;

/**
 * Método que representa os dados de uma entidade Usuario
 */
public class UsuarioDTO extends PessoaDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Armazena o login do usuário 
	 */
	private String login;
	
	/**
	 * Armazena a senha do usuário
	 */
	private String senha;
	
	/**
	 * Armazena a senha de confirmação do usuário
	 */
	private String confirmaSenha;
	
	/**
	 * Criando relacionamento com permissoes
	 */
	private List<PermissaoDTO> listaPermissoes;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the confirmaSenha
	 */
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	/**
	 * @param confirmaSenha the confirmaSenha to set
	 */
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	/**
	 * @return the listaPermissoes
	 */
	public List<PermissaoDTO> getListaPermissoes() {
		return listaPermissoes;
	}

	/**
	 * @param listaPermissoes the listaPermissoes to set
	 */
	public void setListaPermissoes(List<PermissaoDTO> listaPermissoes) {
		this.listaPermissoes = listaPermissoes;
	}	
}
