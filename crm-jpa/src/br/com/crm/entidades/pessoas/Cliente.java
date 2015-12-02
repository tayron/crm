package br.com.crm.entidades.pessoas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity Bean para representação de um cliente
 */
@Entity
@Table(name="clientes")
public class Cliente extends Pessoa{

	/**
	 * Armazena o telefone de contato
	 */	
	@Column(name="telefone", nullable=false, length=15)
	private String telefone;
	
	/**
	 * Armazena um nome para contato
	 */
	@Column(name="contato", nullable=false, length=45)
	private String contato;

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the contato
	 */
	public String getContato() {
		return contato;
	}

	/**
	 * @param contato the contato to set
	 */
	public void setContato(String contato) {
		this.contato = contato;
	}	
}
