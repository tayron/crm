package br.com.crm.servicos;

import java.util.List;

import javax.ejb.Local;

import br.com.crm.encapsuladores.UsuarioEncapsulador;
import br.com.crm.encapsuladores.UsuarioInformacaoEncapsulador;
import br.com.crm.excecoes.ExcecaoServico;

/**
 * Interface que determina as implementações que deverá ter em serviço usuário
 */
@Local
public interface IServicoUsuario {

	/**
	 * Método que inclui um novo registro no banco dedados
	 */
	public abstract void incluir(UsuarioEncapsulador usuario) throws ExcecaoServico;

	/**
	 * Método que atualiza um determinado registro no banco de dados 
	 */
	public abstract void alterar(UsuarioEncapsulador usuario) throws ExcecaoServico;

	/**
	 * Método que remove um determinado registro no banco de dados
	 */
	public abstract void excluir(UsuarioEncapsulador usuario) throws ExcecaoServico;

	/**
	 * Método que busca vários registros no banco de dados
	 */
	public abstract List<UsuarioEncapsulador> listar() throws ExcecaoServico;

	/**
	 * Método que busca um registro no banco de dados
	 */
	public abstract UsuarioEncapsulador recuperar(UsuarioEncapsulador usuario)
			throws ExcecaoServico;
	
	public abstract UsuarioInformacaoEncapsulador getInformacaoUsuario(UsuarioEncapsulador usuario) 
			throws ExcecaoServico;
}