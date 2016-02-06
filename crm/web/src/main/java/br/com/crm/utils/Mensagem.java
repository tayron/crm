package br.com.crm.utils;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
/**
 * Classe utilitária para exibição de mensagem para o usuário
 */
public class Mensagem implements IMensagem {
	
	/**
	 * @see IMensagem#exibirSucesso(String)
	 */
    @Override
	public void exibirSucesso(String titulo, String mensagem) {      
    	FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Messagem", new FacesMessage(titulo, mensagem) );        
    }
    
	/**
	 * @see IMensagem#exibirInformacao(String)
	 */
    @Override
	public void exibirInformacao(String titulo, String mensagem) {      
    	FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Messagem", new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem) );        
    }    
    
	/**
	 * @see IMensagem#exibirAviso(String)
	 */
    @Override
	public void exibirAviso(String titulo, String mensagem) {
    	FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Messagem", new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensagem) ); 
    }       
    
	/**
	 * @see IMensagem#exibirErro(String, String)
	 */
    @Override
	public void exibirErro(String titulo, String mensagem) {
    	FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Messagem", new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensagem) );        
    }    
    
	/**
	 * @see IMensagem#exibirErroFatal(String, String)
	 */
    @Override
	public void exibirErroFatal(String titulo, String mensagem) {
    	FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Messagem", new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensagem) );        
    }      
}