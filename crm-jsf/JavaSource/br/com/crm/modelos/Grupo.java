package br.com.crm.modelos;


/**
 * Método que representa os dados de um grupo
 */
public class Grupo extends ModeloAbstrato{

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
	
    public String toString() {
        return getNome();
    }	
}