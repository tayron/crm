package br.com.crm.entidades.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe utilitária para disponibilizar recursos para gerencia entidades
 */
public class EntityUtils {

	/**
	 * Retorna uma fábrica de conexão
	 */
	private EntityManagerFactory getEntityManagerFactory(){
		return Persistence.createEntityManagerFactory("crm-jpa");
	}
	
	/**
	 * Retorna uma entidade para gerenciamento de recursos no banco de dados
	 */
	public EntityManager getEntityManager(){
		return getEntityManagerFactory().createEntityManager();
	}
	
	/**
	 * Retorna uma fábrica de conexão para um banco de dados de teste
	 */
	private EntityManagerFactory getEntityManagerFactoryTest(){
		return Persistence.createEntityManagerFactory("CRMJpaTest");
	}
	
	/**
	 * Retorna uma entidade para gerenciamento de recursos no banco de dados de teste
	 */
	public EntityManager getEntityManagerTest(){
		return getEntityManagerFactoryTest().createEntityManager();
	}	
}
