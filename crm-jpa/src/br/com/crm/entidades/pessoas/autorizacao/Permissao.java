package br.com.crm.entidades.pessoas.autorizacao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.crm.entidades.pessoas.EntidadeAbstrata;

/**
 * Entity Bean para representação de uma permissão
 */
@Entity
@Table(name="permissoes")
public class Permissao extends EntidadeAbstrata {

	/**
	 * 
	 */
	@Column(name="modulo")
	private String modulo;
	
	/**
	 * 
	 */
	@Column(name="tela")
	private String tela;
	
	/**
	 * Relacionamento com tipo permissão, onde uma permissão só pode ter um tipo de permissão
	 * Permissao 1 -- 1 TipoPermissao
	 */	
	@OneToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="tipoPermissao_id")
	private TipoPermissao tipoPermissao;

	/**
	 * @return the modulo
	 */
	public String getModulo() {
		return modulo;
	}

	/**
	 * @param modulo the modulo to set
	 */
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	/**
	 * @return the tela
	 */
	public String getTela() {
		return tela;
	}

	/**
	 * @param tela the tela to set
	 */
	public void setTela(String tela) {
		this.tela = tela;
	}

	/**
	 * @return the tipoPermissao
	 */
	public TipoPermissao getTipoPermissao() {
		return tipoPermissao;
	}

	/**
	 * @param tipoPermissao the tipoPermissao to set
	 */
	public void setTipoPermissao(TipoPermissao tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}	
}