package br.com.crm.servico.dto;


public class PermissaoDTO extends DTOAbstrato{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String modulo;
	
	/**
	 * 
	 */
	private String tela;
	
	/**
	 * Relacionamento com tipo permissão, onde uma permissão só pode ter um tipo de permissão
	 * Permissao 1 -- 1 TipoPermissao
	 */	
	private TipoPermissaoDTO tipoPermissao;

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
	public TipoPermissaoDTO getTipoPermissao() {
		return tipoPermissao;
	}

	/**
	 * @param tipoPermissao the tipoPermissao to set
	 */
	public void setTipoPermissao(TipoPermissaoDTO tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}	
}
