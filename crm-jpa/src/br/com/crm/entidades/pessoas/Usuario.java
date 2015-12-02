package br.com.crm.entidades.pessoas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.crm.entidades.pessoas.autorizacao.Permissao;

/**
 * Entity Bean para representação de um usuário
 */
@Entity
@Table(name="usuarios")
public class Usuario extends Pessoa{
	
	/**
	 * Armazena o login do usuário 
	 */
	@Column(name="login", nullable=false, length=6)
	private String login;
	
	/**
	 * Armazena a senha do usuário
	 */
	@Column(name="senha", nullable=false, length=6)
	private String senha;
	
	/**
	 * Armazena a senha de confirmação do usuário
	 */
	@Transient
	private String confirmaSenha;
	
	/**
	 * Criando relacionamento com permissoes
	 */
	@OneToMany(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinTable(
		name="usuariosPermissoes", 
		joinColumns={
			@JoinColumn(name="usuario_id", referencedColumnName="id")},
		inverseJoinColumns={
			@JoinColumn(name="permissao_id", referencedColumnName="id")}
	)
	private List<Permissao> listaPermissoes;

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
	public List<Permissao> getListaPermissoes() {
		return listaPermissoes;
	}

	/**
	 * @param listaPermissoes the listaPermissoes to set
	 */
	public void setListaPermissoes(List<Permissao> listaPermissoes) {
		this.listaPermissoes = listaPermissoes;
	}	
}
