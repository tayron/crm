package br.com.crm.daos;

import java.util.List;

import javax.ejb.Local;

import br.com.crm.entidades.Grupo;
import br.com.crm.excecoes.ExcecaoModelo;

/**
 * Interface DAO que define as operações básicas a serem implementadas pelo GrupoDAO
 */
@Local
public interface IGrupoDAO {
	
	/**
	 * Método que inclui um novo registro no banco dedados
	 */
	public void incluir(Grupo grupo) throws ExcecaoModelo;
	
	/**
	 * Método que atualiza um determinado registro no banco de dados 
	 */
	public void alterar(Grupo grupo) throws ExcecaoModelo;
	
	/**
	 * Método que remove um determinado registro no banco de dados
	 */
	public void excluir(Grupo grupo) throws ExcecaoModelo;
	
	/**
	 * Método que busca vários registros no banco de dados
	 */
	public List<Grupo> listar() throws ExcecaoModelo;
	
	/**
	 * Método que busca um registro no banco de dados
	 */
	public Grupo recuperar(Grupo grupo) throws ExcecaoModelo;
}