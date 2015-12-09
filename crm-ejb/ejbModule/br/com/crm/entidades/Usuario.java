package br.com.crm.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity Bean para representação de um usuário
 */
@Entity
@Table(name="usuarios")
public class Usuario extends Pessoa{
	
	/**
	 * Armazena o login do usuário 
	 */
	@Column(name="login", nullable=false, length=45)
	private String login;
	
	/**
	 * Armazena a senha do usuário
	 */
	@Column(name="senha", nullable=false, length=6)
	private String senha;

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
}
