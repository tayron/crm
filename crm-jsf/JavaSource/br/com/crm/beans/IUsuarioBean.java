package br.com.crm.beans;

import java.util.List;

import br.com.crm.modelos.Usuario;

/**
 * Interface que define os métodos a serem implementados pelo UsuarioBean
 */
public interface IUsuarioBean {

	/**
	 * Método que carrega uma lista de grupos de usuários
	 */
	public void carregarGruposDeUsuario();
	
	/**
	 * Método que busca todos os usuários cadastrados
	 */
	public List<Usuario> listarUsuarios();
	
	/**
	 * Método que insere um novo usuário no banco de dados
	 */
	public void cadastrarDadosDoUsuario();
	
	/**
	 * Método que altera os dados do usuário no banco
	 */
	public void alterarDadosDoUsuario();
	
	/**
	 * Método que exclui os dados do usuário no banco
	 */
	public void excluirUsuario(Usuario id);
	
	/**
	 * Método que busca e exibe a tela de edição dos dados do usuário
	 */
	public String exibirTelaAlterarUsuario(String id);
	
	/**
	 * Método que busca e exibe a tela com as informações do usuário
	 */
	public String exibirTelaInformacaoUsuario(String id);	
}