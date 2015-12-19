package br.com.crm.daos;

import java.util.List;

import javax.ejb.Local;

import br.com.crm.encapsuladores.UsuarioInformacaoEncapsulador;
import br.com.crm.entidades.Usuario;
import br.com.crm.excecoes.ExcecaoModelo;

/**
 * Interface DAO que define as operações básicas a serem implementadas pelo UsuarioDAO
 */
@Local
public interface IUsuarioDAO {
	/**
	 * Método que inclui um novo registro no banco dedados
	 */
	public void incluir(Usuario usuario) throws ExcecaoModelo;
	
	/**
	 * Método que atualiza um determinado registro no banco de dados 
	 */
	public void alterar(Usuario usuario) throws ExcecaoModelo;
	
	/**
	 * Método que remove um determinado registro no banco de dados
	 */
	public void excluir(Usuario usuario) throws ExcecaoModelo;
	
	/**
	 * Método que busca vários registros no banco de dados
	 */
	public List<Usuario> listar() throws ExcecaoModelo;
	
	/**
	 * Método que busca um registro no banco de dados
	 */
	public Usuario recuperar(Usuario usuario) throws ExcecaoModelo;
	
	/**
	 * Método que pesquisa por um usuário através de seu login e senha
	 */
	public Boolean consultar(String login, String senha)throws ExcecaoModelo;
	
	/**
	 * Retorna os dados do usuário encapsulado
	 */
	public UsuarioInformacaoEncapsulador getInformacaoUsuario(Usuario usuario) throws ExcecaoModelo;
}
