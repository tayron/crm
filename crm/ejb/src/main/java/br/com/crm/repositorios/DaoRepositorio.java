package br.com.crm.repositorios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.crm.daos.GrupoDAO;
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
	
	/**
	 * @see IDaoRepositorio#getUsuario()
	 */
	@Override
	public UsuarioDAO getUsuario() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.setEntityManager(entityManager);
		return usuarioDAO;
	}

	/**
	 * @see IDaoRepositorio#getGrupo()
	 */
	@Override
	public GrupoDAO getGrupo() {
		GrupoDAO grupoDAO = new GrupoDAO();
		grupoDAO.setEntityManager(entityManager);
		return grupoDAO;
	}	
}