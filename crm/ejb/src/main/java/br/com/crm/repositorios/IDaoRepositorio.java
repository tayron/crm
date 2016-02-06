package br.com.crm.repositorios;

import javax.ejb.Local;

import br.com.crm.daos.GrupoDAO;
import br.com.crm.daos.UsuarioDAO;

/**
 * Interface que determina e descreve os métodos 
 * a serem implementados pela classe Repositorio
 */
@Local
public interface IDaoRepositorio {

	/**
	 * Método que busca e retorna um usuário
	 */
	public UsuarioDAO getUsuario();
	
	/**
	 * Método que busca e retorna um grupo
	 */
	public GrupoDAO getGrupo();	
}
