package br.com.crm.repositorios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.crm.daos.UsuarioDAO;

/**
 * Classe repositório que fornece acesso a um dao
 */
@Stateless
public class DaoRepositorio implements IDaoRepositorio {

	/**
	 * Injeção de um entityManager
	 */
	@PersistenceContext(name="crm-jpa")
	private EntityManager entityManager;
	
	public UsuarioDAO getUsuario() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.setEntityManager(entityManager);
		return usuarioDAO;
	}
}