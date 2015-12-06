package br.com.crm.servico;

import java.util.List;

import javax.ejb.Local;

import br.com.crm.servico.dto.UsuarioDTO;
import br.com.crm.servico.excecao.ExcecaoServico;

@Local
public interface IServicoUsuario {

	/**
	 * Método que inclui um novo registro no banco dedados
	 */
	public abstract void incluir(UsuarioDTO usuarioDTO) throws ExcecaoServico;

	/**
	 * Método que atualiza um determinado registro no banco de dados 
	 */
	public abstract void alterar(UsuarioDTO usuarioDTO) throws ExcecaoServico;

	/**
	 * Método que remove um determinado registro no banco de dados
	 */
	public abstract void excluir(UsuarioDTO usuarioDTO) throws ExcecaoServico;

	/**
	 * Método que busca vários registros no banco de dados
	 */
	public abstract List<UsuarioDTO> listar() throws ExcecaoServico;

	/**
	 * Método que busca um registro no banco de dados
	 */
	public abstract UsuarioDTO recuperar(UsuarioDTO usuarioDTO)
			throws ExcecaoServico;

}