package br.com.crm.beans;

import java.util.List;

import br.com.crm.dtos.UsuarioDTO;

public interface IUsuarioBean {

	/**
	 * Método que busca todos os usuários cadastrados
	 */
	public List<UsuarioDTO> listarUsuarios();
	
	/**
	 * Método que insere um novo usuário no banco de dados
	 */
	public void cadastrarDadosDoUsuario();
	
	/**
	 * Método que busca e exibe a tela de edição dos dados do usuário
	 */
	public String exibirTelaAlterarUsuario(String id);
	
	/**
	 * Método que altera os dados do usuário no banco
	 */
	public void alterarDadosDoUsuario();
	
	/**
	 * Método que exclui os dados do usuário no banco
	 */
	public void excluirUsuario(UsuarioDTO id);	
}