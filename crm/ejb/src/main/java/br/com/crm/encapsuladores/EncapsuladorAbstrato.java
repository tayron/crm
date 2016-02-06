package br.com.crm.encapsuladores;


/**
 * DTO Abstrato que possui o atributo id como padrão e implementa serializable 
 * para que o DTO possa ser transportado entre os projetos.
 */
public class EncapsuladorAbstrato{
	
	/**
	 * Armazena o código de indentifição
	 */
	protected Integer id;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}	
}
