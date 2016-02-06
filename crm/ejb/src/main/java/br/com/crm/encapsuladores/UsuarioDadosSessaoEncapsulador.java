package br.com.crm.encapsuladores;

/**
 * Método que representa os dados do usuário que deverá ficar guardado na sessão
 */
public class UsuarioDadosSessaoEncapsulador {

	/**
	 * Armazena o nome da pessoa
	 */
	private String nome;

	/**
	 * Armazena o login do usuário
	 */
	private String login;

	/**
	 * Armazena o nome do grupo na qual o usuário pertence
	 */
	private String grupo;
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

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
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
