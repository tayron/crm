package br.com.crm.servicos;

import java.util.List;

import javax.ejb.Local;

import br.com.crm.dtos.GrupoDTO;
import br.com.crm.excecoes.ExcecaoServico;

/**
 * Interface que determina as implementações que deverá ter em serviço grupo
 */
@Local
public interface IServicoGrupo {

	/**
	 * Método que inclui um novo registro no banco dedados
	 */
	public abstract void incluir(GrupoDTO grupoDTO) throws ExcecaoServico;

	/**
	 * Método que atualiza um determinado registro no banco de dados 
	 */
	public abstract void alterar(GrupoDTO grupoDTO) throws ExcecaoServico;

	/**
	 * Método que remove um determinado registro no banco de dados
	 */
	public abstract void excluir(GrupoDTO grupoDTO) throws ExcecaoServico;

	/**
	 * Método que busca vários registros no banco de dados
	 */
	public abstract List<GrupoDTO> listar() throws ExcecaoServico;

	/**
	 * Método que busca um registro no banco de dados
	 */
	public abstract GrupoDTO recuperar(GrupoDTO grupoDTO)
			throws ExcecaoServico;
}