package br.com.crm.entidades.pessoas.autorizacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import br.com.crm.entidades.pessoas.EntidadeAbstrata;

/**
 * Entity Bean para representação de um usuário
 */
@Entity
@Table(name="tiposPermissoes")
public class TipoPermissao extends EntidadeAbstrata {
	
	/**
	 * 
	 */
	@Column(name="sigla")
	private String sigla;
	
	/**
	 * 
	 */
	@Column(name="descricao")
	private String descricao;

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
