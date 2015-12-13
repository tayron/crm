package br.com.crm.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.crm.entidades.Grupo;
import br.com.crm.excecoes.ExcecaoModelo;

/**
 * Classe DAO para que manipula dos dao do grupo no banco
 */
@Stateless
public class GrupoDAO implements IGrupoDAO{

	/**
	 * 
	 */
	private EntityManager entityManager;
	
	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
	
	/**
	 * {@link IGrupoDAO#excluir(Grupo)}
	 */
	public void incluir(Grupo grupo) throws ExcecaoModelo {	
		entityManager.persist(grupo);
	}

	/**
	 * {@link IGrupoDAO#alterar(Grupo)}
	 */
	public void alterar(Grupo grupo) throws ExcecaoModelo {
		entityManager.merge(grupo);
	}

	/**
	 * {@link IGrupoDAO#excluir(Grupo)}
	 */
	public void excluir(Grupo grupo) throws ExcecaoModelo {
		entityManager.remove(grupo);
	}

	/**
	 * {@link IGrupoDAO#listar()}
	 */
	public List<Grupo> listar() throws ExcecaoModelo {		
		TypedQuery<Grupo> query = entityManager
			.createQuery("Select u from Grupo u", 
				Grupo.class);
		
		return query.getResultList();
	}

	/**
	 * {@link IGrupoDAO#recuperar(Grupo)}
	 */
	public Grupo recuperar(Grupo grupo) throws ExcecaoModelo {
		return entityManager.find(Grupo.class, grupo.getId());
	}
}
