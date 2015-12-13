/**
 * 
 */
package br.com.crm.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity Bean para representação de um grupo
 */
@Entity
@Table(name="grupos")
public class Grupo extends EntidadeAbstrata {

	/**
	 * Descreve o nome do grupo
	 */
	@Column(name="nome", length=45, nullable=false)
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
