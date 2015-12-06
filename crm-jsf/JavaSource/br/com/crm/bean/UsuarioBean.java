package br.com.crm.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.crm.ejb.interfaces.IServicoUsuario;
import br.com.crm.servico.dto.UsuarioDTO;
import br.com.crm.servico.excecao.ExcecaoServico;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	/**
	 * 
	 */
	@EJB
	private IServicoUsuario servicoUsuario;
	
	/**
	 * 
	 * @return
	 */
	public List<UsuarioDTO> listarUsuarios(){
		try {
			return servicoUsuario.listar();
		} catch (ExcecaoServico e) {
			e.printStackTrace();
		}
		return null;
	}
}
