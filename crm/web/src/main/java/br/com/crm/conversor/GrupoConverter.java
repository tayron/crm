package br.com.crm.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.crm.beans.UsuarioBean;
 
/**
 * Conversor que converte um objeto select do jsf para um objeto Grupo 
 */
@FacesConverter(value="grupoConverter")
public class GrupoConverter implements Converter {
 
	/**
	 * 
	 */
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        UsuarioBean usuarioBean = (UsuarioBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "usuarioBean");
 
        return usuarioBean.getGrupoPorNome(key);
    }
 
    /**
     * 
     */
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return arg2.toString();
    }
}