package br.com.crm.servicos;

import java.util.List;

import javax.ejb.Local;

import br.com.crm.encapsuladores.GrupoEncapsulador;
import br.com.crm.excecoes.ExcecaoServico;

/**
 * Interface que determina as implementações que deverá ter em serviço grupo
 */
@Local
public interface IServicoGrupo {

	/**
	 * Método que inclui um novo registro no banco dedados
	 */
	public abstract void incluir(GrupoEncapsulador grupoDTO) throws ExcecaoServico;

	/**
	 * Método que atualiza um determinado registro no banco de dados 
	 */
	public abstract void alterar(GrupoEncapsulador grupoDTO) throws ExcecaoServico;

	/**
	 * Método que remove um determinado registro no banco de dados
	 */
	public abstract void excluir(GrupoEncapsulador grupoDTO) throws ExcecaoServico;

	/**
	 * Método que busca vários registros no banco de dados
	 */
	public abstract List<GrupoEncapsulador> listar() throws ExcecaoServico;

	/**
	 * Método que busca um registro no banco de dados
	 */
	public abstract GrupoEncapsulador recuperar(GrupoEncapsulador grupoDTO)
			throws ExcecaoServico;
}