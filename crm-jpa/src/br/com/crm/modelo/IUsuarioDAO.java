package br.com.crm.modelo;

import br.com.crm.modelo.excecoes.ExcecaoModelo;

/**
 * Interface DAO que define as operações básicas a serem implementadas pelo UsuarioDAO
 */
public interface IUsuarioDAO {
	
	/**
	 * Método que pesquisa por um usuário através de seu login e senha
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws ExcecaoModelo
	 */
	public Boolean consultar(String login, String senha)throws ExcecaoModelo;
}
