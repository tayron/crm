package br.com.crm.dtos;

import br.com.crm.entidades.Grupo;


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
	 * Descreve o relacionamento com um grupo, onde
	 * um usuário pertence a um grupo.
	 */	
	private Grupo grupo;
	
	/**
	 * Armazena a senha de confirmação do usuário
	 */
	private String confirmaSenha;

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
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
}
