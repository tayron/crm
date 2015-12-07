package br.com.crm.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.crm.dtos.UsuarioDTO;
import br.com.crm.excecoes.ExcecaoServico;
import br.com.crm.servicos.IServicoUsuario;

/**
 * Classe que gerencia as solicitações do usuário em relação aos dados de usuário
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements IUsuarioBean {

	/**
	 * Injeção do serviço usuário para manipulação de dados
	 */
	@EJB
	private IServicoUsuario servicoUsuario;
	
	/** 
	 * @see IUsuarioBean#listarUsuarios()
	 */
	@Override
	public List<UsuarioDTO> listarUsuarios(){
		try {
			return servicoUsuario.listar();
		} catch (ExcecaoServico e) {
			e.printStackTrace();
		}
		return null;
	}
}
