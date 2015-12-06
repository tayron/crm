package br.com.crm.modelo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.crm.entidades.pessoas.Usuario;
import br.com.crm.entidades.util.EntityUtils;
import br.com.crm.modelo.excecoes.ExcecaoModelo;

/**
 * Classe DAO para que manipula dos dao do usuário no banco
 */
@Stateless
public class UsuarioDAO implements IUsuarioDAO{

	/**
	 * 
	 */
	private EntityUtils entityUtil;
	
	/**
	 * {@link IUsuarioDAO#excluir(Usuario)}
	 */
	public void incluir(Usuario usuario) throws ExcecaoModelo {	
		entityUtil = new EntityUtils();
		EntityManager entityManager = entityUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
	}

	/**
	 * {@link IUsuarioDAO#alterar(Usuario)}
	 */
	public void alterar(Usuario usuario) throws ExcecaoModelo {
		entityUtil = new EntityUtils();
		EntityManager entityManager = entityUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();	
	}

	/**
	 * {@link IUsuarioDAO#excluir(Usuario)}
	 */
	public void excluir(Usuario usuario) throws ExcecaoModelo {
		entityUtil = new EntityUtils();
		EntityManager entityManager = entityUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		Usuario usuarioEncontrado = entityManager.find(Usuario.class, usuario.getId());
		entityManager.remove(usuarioEncontrado);
		entityManager.getTransaction().commit();
	}

	/**
	 * {@link IUsuarioDAO#listar()}
	 */
	public List<Usuario> listar() throws ExcecaoModelo {		
		List<Usuario> usuarios = null;
		
		entityUtil = new EntityUtils();
		EntityManager entityManager = entityUtil.getEntityManager();
		
		TypedQuery<Usuario> query = entityManager
			.createQuery("Select u from Usuario u", 
				Usuario.class);
		
		usuarios = query.getResultList();		
		return usuarios;
	}

	/**
	 * {@link IUsuarioDAO#recuperar(Usuario)}
	 */
	public Usuario recuperar(Usuario usuario) throws ExcecaoModelo {
		entityUtil = new EntityUtils();
		EntityManager entityManager = entityUtil.getEntityManager();		
		return entityManager.find(Usuario.class, usuario.getId());
	}
	
	/**
	 * {@link IUsuarioDAO#consultar(String, String)}
	 */
	public Boolean consultar(String login, String senha) throws ExcecaoModelo {		
		Usuario usuario = null;
		
		entityUtil = new EntityUtils();
		EntityManager entityManager = entityUtil.getEntityManager();
		
		StringBuffer sql = new StringBuffer();
		sql.append("Select u from Usuario u where ");
		sql.append("u.login = :login and ");
		sql.append("u.senha = :senha");
		
		TypedQuery<Usuario> query = entityManager.createQuery(sql.toString(), Usuario.class);

		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		usuario = query.getSingleResult();
		
		return usuario != null;
	}
}
