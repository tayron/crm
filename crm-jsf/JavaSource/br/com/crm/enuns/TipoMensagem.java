package br.com.crm.enuns;

/**
 * Enum com os tipos de mensagens padrão de iteração com o usuário
 */
public enum TipoMensagem {
	
	/**
	 * Opções de tipo de mensagens
	 */
	CADASTRO_SUCESSO(0, "Registro criado com sucesso."),
	CADASTRO_ERRO(1, "Erro ao tentar cadastrar."),
	SALVO_SUCESSO(2, "Alterações salva com sucesso."),
	SALVO_ERRO(3, "Erro ao salvar as alterações.");

	/**
	 * 
	 */
	private Integer codigo;
	
	/**
	 * 
	 */
	private String descricao;
	
	/**
	 * 
	 * @param codigo
	 * @param descricao
	 */
	private TipoMensagem(Integer codigo, String descricao)
	{
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getCodigo()
	{
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescricao()
	{
		return descricao;
	}

	/**
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	
}
