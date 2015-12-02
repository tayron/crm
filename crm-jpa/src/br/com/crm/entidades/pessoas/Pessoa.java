package br.com.crm.entidades.pessoas;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Entity Bean para representação de uma pessoa
 */
@MappedSuperclass
public class Pessoa extends EntidadeAbstrata {
	
	/**
	 * Armazena o nome da pessoa
	 */
	@Column(name="nome", nullable=false, length=40 )
	private String nome;
	
	/**
	 * Armaneza o cpf da pessoa
	 */
	@Column(name="cpf", nullable=false, length=11)
	private String cpf;
	
	/**
	 * Armazena o endereço da pessoa
	 */
	@Column(name="endereco", nullable=false, length=40)
	private String endereco;
	
	/**
	 * Armazena o status da pessoa, se ela está ativa ou não.
	 */
	@Column(name="ativo", length=1)
	private Boolean ativo;

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
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
