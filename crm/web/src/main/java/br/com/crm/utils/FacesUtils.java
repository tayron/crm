package br.com.crm.utils;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FacesUtils {

	/**
	 * Metodo utilizado para retornar o contexto.
	 * 
	 * @return context
	 */
	public static FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Metodo utilizado para retornar o ViewRoot.
	 * 
	 * @return context
	 */
	public static UIViewRoot getViewRoot() {
		return getContext().getViewRoot();
	}

	/**
	 * Metodo utilizado para retornar o request.
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getContext().getExternalContext().getRequest();
	}

	/**
	 * Metodo utilizado para retornar o response.
	 * 
	 * @return request
	 */
	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) getContext().getExternalContext().getResponse();
	}

	/**
	 * Metodo utilizado para retornar a sessao.
	 * 
	 * @return sessao
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * Metodo utilizado para recuperar qualquer objeto no request.
	 * 
	 * @param key
	 *            - chave do objeto
	 * @return Object - objeto
	 */
	public static Object getObjectInRequest(String key) {
		return getRequest().getAttribute(key);
	}

	/**
	 * Metodo utilizado para setar algum objeto no request.
	 * 
	 * @param key
	 *            - chave do objeto
	 * @param object
	 *            - objeto
	 */
	public static void setObjectInRequest(String key, Object object) {
		getRequest().setAttribute(key, object);
	}

	/**
	 * Metodo utilizado para remover algum objeto do request.
	 * 
	 * @param key
	 *            - chave do objeto
	 * @param object
	 *            - objeto
	 */
	public static void removeObjectInRequest(String key) {
		getRequest().removeAttribute(key);
	}

	/**
	 * Metodo utilizado para recuperar qualquer objeto na sessao.
	 * 
	 * @param key
	 *            - chave do objeto
	 * @return Object - objeto
	 */
	public static Object getObjectInSession(String key) {
		return getSession().getAttribute(key);
	}

	/**
	 * Metodo utilizado para setar algum objeto na sessao.
	 * 
	 * @param key
	 *            - chave do objeto
	 * @param object
	 *            - objeto
	 */
	public static void setObjectInSession(String key, Object object) {
		getSession().setAttribute(key, object);
	}

	/**
	 * Metodo utilizado para remover algum objeto da sessao.
	 * 
	 * @param key
	 *            - chave do objeto
	 * @param object
	 *            - objeto
	 */
	public static void removeObjectInSession(String key) {
		getSession().removeAttribute(key);
	}

	/**
	 * Metodo utilizado para recuperar o nome da aplicacao.
	 * 
	 * @return String - nomeAplicacao
	 */
	public static String getNomeAplicacao() {
		return getRequest().getContextPath();
	}

	/**
	 * Metodo utilizado para redirecionar para alguma URL.
	 * 
	 * @param url
	 */
	public static void redirecionar(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo utilizado para adicionar uma mensagem de erro.
	 * 
	 * @param mensagem
	 *            - Mensagem a ser colocada.
	 */
	public static void addError(String mensagem) {
		getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	/**
	 * Metodo utilizado para adicionar uma mensagem de aviso.
	 * 
	 * @param mensagem
	 *            - Mensagem a ser colocada.
	 */
	public static void addWarning(String mensagem) {
		getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, ""));
	}

	/**
	 * Metodo utilizado para adicionar uma mensagem de informacao.
	 * 
	 * @param mensagem
	 *            - Mensagem a ser colocada.
	 */
	public static void addInfo(String mensagem) {
		getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}

	/**
	 * Metodo utilizado para adicionar uma mensagem de sucesso.
	 * 
	 * @param mensagem
	 *            - Mensagem a ser colocada.
	 */
	public static void addSuccess(String mensagem) {
		getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}

	/**
	 * Metodo utilizado para recuperar o valor de qualquer properties do sistema.
	 * 
	 * @param nomeProperties
	 * @param chave
	 * @return valor
	 */
	public static String getValorProperties(String nomeProperties, String chave) {
		return getContext().getApplication().getResourceBundle(getContext(), nomeProperties).getString(chave);
	}

	/**
	 * Metodo que retorna o componente passando o id por parametro.
	 * 
	 * @param id
	 * @return UIComponent
	 */
	public static UIComponent findComponentById(String id) {
		return findComponent(getViewRoot(), id);
	}

	/**
	 * Metodo privado que utiliza a recursividade para encontrar o id passado por parametro
	 * procurando em toda a tela.
	 * 
	 * @param root
	 * @param id
	 * @return UIComponent
	 */
	private static UIComponent findComponent(UIComponent root, String id) {
		if (root.getId().contains(id)) {
			return root;
		}
		Iterator<UIComponent> kids = root.getFacetsAndChildren();
		while (kids.hasNext()) {
			UIComponent found = findComponent(kids.next(), id);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
}