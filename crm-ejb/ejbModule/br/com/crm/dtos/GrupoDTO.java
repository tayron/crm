package br.com.crm.dtos;

/**
 * Método que representa os dados de um grupo
 */
public class GrupoDTO extends DTOAbstrato{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Armazena o nome do grupo 
	 */
	private String nome;

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
}
