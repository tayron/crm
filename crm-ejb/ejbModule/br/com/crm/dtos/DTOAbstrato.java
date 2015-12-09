package br.com.crm.dtos;

import java.io.Serializable;

/**
 * DTO Abstrato que possui o atributo id como padrão e implementa serializable 
 * para que o DTO possa ser transportado entre os projetos.
 */
public class DTOAbstrato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Armazena o código de indentifição
	 */
	private Integer id;
	
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
