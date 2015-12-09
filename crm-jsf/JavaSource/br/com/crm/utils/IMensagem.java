package br.com.crm.utils;
/**
 * Interface que define os métodos a serem implementados pela classe Mensagem
 */
public interface IMensagem {

	/**
	 * Método que exibe uma mensagem de sucesso para o usuário
	 */
	public abstract void exibirSucesso(String titulo, String mensagem);

	/**
	 * Método que exibe uma mensagem de aviso para o usuário
	 */
	public abstract void exibirAviso(String titulo, String mensagem);

	/**
	 * Método que exibe uma mensagem de erro para o usuário
	 */
	public abstract void exibirErro(String titulo, String mensagem);

	/**
	 * Método que exibe uma mensagem de erro fatal para o usuário
	 */
	public abstract void exibirErroFatal(String titulo, String mensagem);

}