package br.com.crm.modelo;

import java.util.List;

import br.com.crm.entidades.pessoas.Pessoa;
import br.com.crm.modelo.excecoes.ExcecaoModelo;

/**
 * Interface DAO que define as operações básicas a serem implementadas 
 */
public interface IBaseDAO<T extends Pessoa> {

	/**
	 * Método que inclui um novo registro no banco dedados
	 * 
	 * @param t
	 * @throws ExcecaoModelo
	 */
	public void incluir(T entidade) throws ExcecaoModelo;
	
	/**
	 * Método que atualiza um determinado registro no banco de dados 
	 * 
	 * @param t
	 * @throws ExcecaoModelo
	 */
	public void alterar(T entidade) throws ExcecaoModelo;
	
	/**
	 * Método que remove um determinado registro no banco de dados
	 * 
	 * @param t
	 * @throws ExcecaoModelo
	 */
	public void excluir(T entidade) throws ExcecaoModelo;
	
	/**
	 * Método que busca vários registros no banco de dados
	 * 
	 * @param t
	 * @return
	 * @throws ExcecaoModelo
	 */
	public List<T> listar() throws ExcecaoModelo;
	
	/**
	 * Método que busca um registro no banco de dados
	 * 
	 * @param t
	 * @return
	 * @throws ExcecaoModelo
	 */
	public T recuperar(T entidade) throws ExcecaoModelo;
}
