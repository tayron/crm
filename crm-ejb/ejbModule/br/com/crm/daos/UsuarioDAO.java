package br.com.crm.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.crm.encapsuladores.UsuarioInformacaoEncapsulador;
import br.com.crm.entidades.Usuario;
import br.com.crm.excecoes.ExcecaoModelo;

/**
 * Classe DAO para que manipula dos dao do usuário no banco
 */
@Stateless
public class UsuarioDAO implements IUsuarioDAO{

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
	 * {@link IUsuarioDAO#excluir(Usuario)}
	 */
	public void incluir(Usuario usuario) throws ExcecaoModelo {	
		entityManager.persist(usuario);
	}

	/**
	 * {@link IUsuarioDAO#alterar(Usuario)}
	 */
	public void alterar(Usuario usuario) throws ExcecaoModelo {
		entityManager.merge(usuario);
	}

	/**
	 * {@link IUsuarioDAO#excluir(Usuario)}
	 */
	public void excluir(Usuario usuario) throws ExcecaoModelo {
		entityManager.remove(usuario);
	}

	/**
	 * {@link IUsuarioDAO#listar()}
	 */
	public List<Usuario> listar() throws ExcecaoModelo {		
		TypedQuery<Usuario> query = entityManager
			.createQuery("Select u from Usuario u", 
				Usuario.class);
		
		return query.getResultList();
	}

	/**
	 * {@link IUsuarioDAO#recuperar(Usuario)}
	 */
	public Usuario recuperar(Usuario usuario) throws ExcecaoModelo {
		return entityManager.find(Usuario.class, usuario.getId());
	}
	
	/**
	 * {@link IUsuarioDAO#consultar(String, String)}
	 */
	public Boolean consultar(String login, String senha) throws ExcecaoModelo {		
		Usuario usuario = null;
		
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

	/**
	 * @see IUsuarioDAO#getInformacaoUsuario(Usuario)
	 */
	@Override
	public UsuarioInformacaoEncapsulador getInformacaoUsuario(Usuario usuario)
			throws ExcecaoModelo {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select new br.com.crm.encapsuladores.UsuarioInformacaoEncapsulador(");
		sql.append("u.nome, u.cpf, u.endereco, u.ativo, u.login, u.grupo.nome)");
		sql.append(" from Usuario u where u.id = :id");
		
		TypedQuery<UsuarioInformacaoEncapsulador> query = entityManager
				.createQuery(sql.toString(),
						UsuarioInformacaoEncapsulador.class);
		
		query.setParameter("id", usuario.getId());
		
		return query.getSingleResult();
	}
}
