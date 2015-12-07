package br.com.crm.repositorios;

import javax.ejb.Local;

import br.com.crm.daos.UsuarioDAO;

/**
 * 
 */
@Local
public interface IDaoRepositorio {

	/**
	 * Método que busca e retorna um usuário
	 */
	public UsuarioDAO getUsuario();
}
