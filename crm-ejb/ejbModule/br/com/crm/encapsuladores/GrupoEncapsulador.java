package br.com.crm.encapsuladores;

/**
 * Método que representa os dados de um grupo
 */
public class GrupoEncapsulador extends EncapsuladorAbstrato{
	
	/**
	 * Armazena o nome do grupo 
	 */
	private String nome;
	
	/**
	 * Construtor padrão
	 */
	public GrupoEncapsulador() {

	}
	
	/**
	 * Construtor com parametros
	 */
	public GrupoEncapsulador(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
    public String toString() {
        return getNome();
    }	
}