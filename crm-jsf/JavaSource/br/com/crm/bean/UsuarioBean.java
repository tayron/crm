package br.com.crm.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.crm.servico.IServico;
import br.com.crm.servico.ServicoUsuario;
import br.com.crm.servico.dto.UsuarioDTO;
import br.com.crm.servico.excecao.ExcecaoServico;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	/**
	 * 
	 */
	@EJB
	private IServico<UsuarioDTO> servicoUsuario;
	
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
	
	/**
	 * @return the servicoUSuario
	 */
	public IServico<UsuarioDTO> getServicoUsuario() {
		if(servicoUsuario == null){
			servicoUsuario = new ServicoUsuario();
		}
		return servicoUsuario;
	}

	/**
	 * @param servicoUSuario the servicoUSuario to set
	 */
	public void setServicoUSuario(ServicoUsuario servicoUsuario) {
		this.servicoUsuario = servicoUsuario;
	}

}
