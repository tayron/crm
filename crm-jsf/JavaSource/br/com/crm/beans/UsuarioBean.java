package br.com.crm.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.crm.dtos.UsuarioDTO;
import br.com.crm.enuns.TipoMensagem;
import br.com.crm.excecoes.ExcecaoServico;
import br.com.crm.servicos.IServicoUsuario;
import br.com.crm.utils.Mensagem;

/**
 * Classe que gerencia as solicitações do usuário em relação aos dados de usuário
 */
@ManagedBean
@RequestScoped
public class UsuarioBean implements IUsuarioBean {

	/**
	 * Injeção do serviço usuário para manipulação de dados
	 */
	@EJB
	private IServicoUsuario servicoUsuario;
	
	/**
	 * Objeto DTO que representa os dados do usuário
	 */
	private UsuarioDTO usuarioDTO;
	
	/** 
	 * @see IUsuarioBean#listarUsuarios()
	 */
	@Override
	public List<UsuarioDTO> listarUsuarios(){
		List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
		try {
			listaUsuarios = servicoUsuario.listar();
		} catch (ExcecaoServico e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	/**
	 * @see IUsuarioBean#cadastrarDadosDoUsuario()
	 */
	@Override
	public void cadastrarDadosDoUsuario() {
		Mensagem mensagem = new Mensagem();
		try {
			servicoUsuario.incluir(usuarioDTO);
			mensagem.exibirAviso("Sucesso", TipoMensagem.CADASTRO_SUCESSO.getDescricao());
			usuarioDTO = null;
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.CADASTRO_ERRO.getDescricao());
		}
	}
	
	/**
	 * @see IUsuarioBean#exibirTelaAlterarUsuario(String) 
	 */
	@Override
	public String exibirTelaAlterarUsuario(String id) {
		if(buscarDadosUsuario(id)){
			return "alterar";
		}else{
			Mensagem mensagem = new Mensagem();
			mensagem.exibirAviso("Erro", "Não foi possível recuperar os dados do usuário");
			return "index";
		}
	}	
	
	/**
	 * Método que busca os dados do usuário através do seu id
	 */
	private boolean buscarDadosUsuario(String id){
		UsuarioDTO parametros = new UsuarioDTO();
		parametros.setId(Integer.parseInt(id));
		try {
			usuarioDTO = servicoUsuario.recuperar(parametros);
			return true;
		} catch (ExcecaoServico e) {
			return false;
		}		
	}	
	
	/**
	 * @see IUsuarioBean#alterarDadosDoUsuario()
	 */
	@Override
	public void alterarDadosDoUsuario() {
		Mensagem mensagem = new Mensagem();
		try {
			servicoUsuario.alterar(usuarioDTO);
			mensagem.exibirAviso("Sucesso", TipoMensagem.SALVO_SUCESSO.getDescricao());
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.SALVO_ERRO.getDescricao());
		}
	}
	
	/**
	 * @see IUsuarioBean#excluirUsuario(UsuarioDTO)
	 */
	@Override
	public void excluirUsuario(UsuarioDTO usuarioDTO){
		Mensagem mensagem = new Mensagem();
		try {
			servicoUsuario.excluir(usuarioDTO);
			mensagem.exibirAviso("Sucesso", TipoMensagem.EXCLUIDO_SUCESSO.getDescricao());
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.EXCLUIDO_ERRO.getDescricao());
		}		
	}
	
	/**
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		if(usuarioDTO == null){
			usuarioDTO = new UsuarioDTO();
		}
		return usuarioDTO;
	}

	/**
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	/**
	 * 
	 */
	public String cadastrarUsuario(){
		return "cadastrar";
	}
}
