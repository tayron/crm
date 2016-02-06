package br.com.crm.excecoes;


/**
 * Classe de exceção para a camada de modelo
 */
public class ExcecaoModelo extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param msg
	 */
	public ExcecaoModelo(String mensagem){
		super(mensagem);
	}
}
