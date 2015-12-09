package br.com.crm.excecoes;

/**
 * Classe de exceção para a camada de modelo
 */
public class ExcecaoServico extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param msg
	 */
	public ExcecaoServico(String mensagem){
		super(mensagem);
	}	
}
