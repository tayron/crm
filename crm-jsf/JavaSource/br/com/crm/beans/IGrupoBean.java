package br.com.crm.beans;

import java.util.List;

import br.com.crm.dtos.GrupoDTO;

public interface IGrupoBean {

	/**
	 * Método que busca todos os grupos cadastrados
	 */
	public List<GrupoDTO> listarGrupos();
	
	/**
	 * Método que insere um novo grupo no banco de dados
	 */
	public void cadastrarDadosDoGrupo();
	
	/**
	 * Método que busca e exibe a tela de edição dos dados do grupo
	 */
	public String exibirTelaAlterarGrupo(String id);
	
	/**
	 * Método que altera os dados do grupo no banco
	 */
	public void alterarDadosDoGrupo();
	
	/**
	 * Método que exclui os dados do grupo no banco
	 */
	public void excluirGrupo(GrupoDTO id);	
}