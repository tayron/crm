package br.com.crm.servico;

import java.util.List;

import javax.ejb.Stateless;

import br.com.crm.servico.excecao.ExcecaoServico;

/**
 * Interface que define os métodos padrões de um serviço
 * @param <DTO>ServicoUsuario
 */
@Stateless
public interface IServico<DTO> {
	
	/**
	 * Método que inclui um novo registro no banco dedados
	 */
	public void incluir(DTO entidadeDTO) throws ExcecaoServico;
	
	/**
	 * Método que atualiza um determinado registro no banco de dados 
	 */
	public void alterar(DTO entidadeDTO) throws ExcecaoServico;
	
	/**
	 * Método que remove um determinado registro no banco de dados
	 */
	public void excluir(DTO entidadeDTO) throws ExcecaoServico;
	
	/**
	 * Método que busca vários registros no banco de dados
	 */
	public List<DTO> listar() throws ExcecaoServico;
	
	/**
	 * Método que busca um registro no banco de dados
	 */
	public DTO recuperar(DTO entidadeDTO) throws ExcecaoServico;
}