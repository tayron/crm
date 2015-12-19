package br.com.crm.encapsuladores;


/**
 * Método que representa os dados de uma entidade Usuario
 */
public class UsuarioInformacaoEncapsulador {

	/**
	 * Armazena o nome do usuário
	 */
	private String nome;

	/**
	 * Armazena o cpf do usuário
	 */	
	private String cpf;
	
	/**
	 * Armazena o enderço do usuário
	 */	
	private String endereco;
	
	/**
	 * Armazena o status do usuário
	 */
	private String status;
	
	/**
	 * Armazena o login do usuário 
	 */
	private String login;	
	
	/**
	 * Armazena o nome do grupo
	 */	
	private String nomeGrupo;

	/**
	 * Construtor padrão
	 */
	public UsuarioInformacaoEncapsulador() {
		
	}

	/**
	 * Construtor padrão
	 */
	public UsuarioInformacaoEncapsulador(String nome, String cpf, String endereco, Boolean ativo, String login, String nomeGrupo) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.status = (ativo) ? "Ativo" : "Inativo";
		this.login = login;
		this.nomeGrupo = nomeGrupo;
	}

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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the nomeGrupo
	 */
	public String getNomeGrupo() {
		return nomeGrupo;
	}

	/**
	 * @param nomeGrupo the nomeGrupo to set
	 */
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	

}
