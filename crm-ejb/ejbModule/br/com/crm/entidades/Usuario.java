package br.com.crm.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	 * Descreve o relacionamento com um grupo, onde
	 * um usuário pertence a um grupo.
	 */
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="grupo_id", nullable=false)
	private Grupo grupo;

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
