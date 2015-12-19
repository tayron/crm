package br.com.crm.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.crm.encapsuladores.GrupoEncapsulador;
import br.com.crm.encapsuladores.UsuarioEncapsulador;
import br.com.crm.encapsuladores.UsuarioInformacaoEncapsulador;
import br.com.crm.enuns.TipoMensagem;
import br.com.crm.excecoes.ExcecaoServico;
import br.com.crm.modelos.Grupo;
import br.com.crm.modelos.Usuario;
import br.com.crm.modelos.UsuarioInformacao;
import br.com.crm.servicos.IServicoGrupo;
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
	 * Injeção do serviço grupo para manipulação de dados
	 */
	@EJB
	private IServicoGrupo servicoGrupo;
	
	/**
	 * Objeto que representa os dados do usuário
	 */
	private Usuario usuario;
	
	/**
	 * Objeto que representa as informações do usuário
	 */
	private UsuarioInformacao usuarioInformacao;

	/**
	 * Objeto DTO que representa os dados do grupo
	 */
	@SuppressWarnings("rawtypes")
	private Map grupos;
	
	/**
	 *  @see IUsuarioBean#carregarGruposDeUsuario()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void carregarGruposDeUsuario(){
		Mensagem mensagem = new Mensagem();
		try {
			List<GrupoEncapsulador> gruposDTO =  servicoGrupo.listar();
			grupos = new HashMap();
			
			for(GrupoEncapsulador grupoDTO : gruposDTO){
				Grupo grupo = new Grupo();
				grupo.setId(grupoDTO.getId());
				grupo.setNome(grupoDTO.getNome());
				grupos.put(grupo.getNome(), grupo);
			}
			
			if(gruposDTO.size() == 0){
				mensagem.exibirAviso("Erro", "Não foi possível carregar a lista de grupos");								
			}
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", "Não foi possível carregar a lista de grupos");
		}
	}
	
	/** 
	 * @see IUsuarioBean#listarUsuarios()
	 */
	@Override
	public List<Usuario> listarUsuarios(){
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			List<UsuarioEncapsulador> usuariosDTO = servicoUsuario.listar();
			
			for(UsuarioEncapsulador usuarioDTO : usuariosDTO){
				Usuario usuario = new Usuario();
				usuario.setId(usuarioDTO.getId());
				usuario.setNome(usuarioDTO.getNome());
				usuario.setLogin(usuarioDTO.getLogin());
				usuario.setCpf(usuarioDTO.getCpf());
				usuario.setEndereco(usuarioDTO.getEndereco());
				usuario.setAtivo(usuarioDTO.getAtivo());
				
				Grupo grupo = new Grupo();
				grupo.setId(usuarioDTO.getGrupoDTO().getId());
				grupo.setNome(usuarioDTO.getGrupoDTO().getNome());
				
				usuario.setGrupo(grupo);
				
				listaUsuarios.add(usuario);
			}
			
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
			UsuarioEncapsulador usuarioDTO = new UsuarioEncapsulador();
			usuarioDTO.setNome(usuario.getNome());
			usuarioDTO.setAtivo(usuario.getAtivo());
			usuarioDTO.setLogin(usuario.getLogin());
			usuarioDTO.setSenha(usuario.getSenha());
			usuarioDTO.setConfirmaSenha(usuario.getConfirmaSenha());
			usuarioDTO.setCpf(usuario.getCpf());
			usuarioDTO.setEndereco(usuario.getEndereco());
			
			GrupoEncapsulador grupoDTO = new GrupoEncapsulador();
			grupoDTO.setId(usuario.getGrupo().getId());
			grupoDTO.setNome(usuario.getGrupo().getNome());
			
			usuarioDTO.setGrupoDTO(grupoDTO);
			
			servicoUsuario.incluir(usuarioDTO);
			
			mensagem.exibirAviso("Sucesso", TipoMensagem.CADASTRO_SUCESSO.getDescricao());
			usuarioDTO = null;
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.CADASTRO_ERRO.getDescricao());
		}
	}
	
	/**
	 * Método que busca os dados do usuário através do seu id
	 */
	private boolean buscarDadosUsuario(String id){
		UsuarioEncapsulador parametros = new UsuarioEncapsulador();
		parametros.setId(Integer.parseInt(id));
		
		try {
			UsuarioEncapsulador usuarioDTO = servicoUsuario.recuperar(parametros);
			usuario = new Usuario();
			usuario.setId(usuarioDTO.getId());
			usuario.setAtivo(usuarioDTO.getAtivo());
			usuario.setCpf(usuarioDTO.getCpf());
			usuario.setEndereco(usuarioDTO.getEndereco());
			usuario.setLogin(usuarioDTO.getLogin());
			usuario.setNome(usuarioDTO.getNome());			
			
			Grupo grupo = new Grupo();
			grupo.setId(usuarioDTO.getGrupoDTO().getId());
			grupo.setNome(usuarioDTO.getGrupoDTO().getNome());
			
			usuario.setGrupo(grupo);
			
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
			UsuarioEncapsulador usuarioDTO = new UsuarioEncapsulador();
			usuarioDTO.setId(usuario.getId());
			usuarioDTO.setNome(usuario.getNome());
			usuarioDTO.setAtivo(usuario.getAtivo());
			usuarioDTO.setLogin(usuario.getLogin());
			usuarioDTO.setSenha(usuario.getSenha());
			usuarioDTO.setConfirmaSenha(usuario.getConfirmaSenha());
			usuarioDTO.setCpf(usuario.getCpf());
			usuarioDTO.setEndereco(usuario.getEndereco());
			
			GrupoEncapsulador grupoDTO = new GrupoEncapsulador();
			grupoDTO.setId(usuario.getGrupo().getId());
			grupoDTO.setNome(usuario.getGrupo().getNome());
			
			usuarioDTO.setGrupoDTO(grupoDTO);
			
			servicoUsuario.alterar(usuarioDTO);
			mensagem.exibirAviso("Sucesso", TipoMensagem.SALVO_SUCESSO.getDescricao());
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.SALVO_ERRO.getDescricao());
		}
	}
	
	/**
	 * @see IUsuarioBean#excluirUsuario(Usuario)
	 */
	@Override
	public void excluirUsuario(Usuario usuario){
		Mensagem mensagem = new Mensagem();
		try {
			UsuarioEncapsulador usuarioDTO = new UsuarioEncapsulador();
			usuarioDTO.setId(usuario.getId());
			
			servicoUsuario.excluir(usuarioDTO);
			mensagem.exibirAviso("Sucesso", TipoMensagem.EXCLUIDO_SUCESSO.getDescricao());
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.EXCLUIDO_ERRO.getDescricao());
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
	 * @see IUsuarioBean#exibirTelaInformacaoUsuario(String) 
	 */	
	@Override
	public String exibirTelaInformacaoUsuario(String id) {
		UsuarioEncapsulador usuario = new UsuarioEncapsulador();
		usuario.setId(Integer.parseInt(id));
		
		UsuarioInformacaoEncapsulador informacaoUsuario;
		try {
			informacaoUsuario = servicoUsuario.getInformacaoUsuario(usuario);
			
			usuarioInformacao = new UsuarioInformacao();			
			usuarioInformacao.setNome(informacaoUsuario.getNome());
			usuarioInformacao.setCpf(informacaoUsuario.getCpf());
			usuarioInformacao.setEndereco(informacaoUsuario.getEndereco());
			usuarioInformacao.setNomeGrupo(informacaoUsuario.getNomeGrupo());
			usuarioInformacao.setLogin(informacaoUsuario.getLogin());
			usuarioInformacao.setStatus(informacaoUsuario.getStatus());
			
			return "informacao";
			
		} catch (ExcecaoServico e) {
			Mensagem mensagem = new Mensagem();
			mensagem.exibirAviso("Erro", "Não foi possível recuperar os dados do usuário");
			return "index";
		}
	}	
	
	/**
	 * Método que retorna um grupo através de seu nome
	 */
	public Grupo getGrupoPorNome(String nome){
		this.carregarGruposDeUsuario();
		return (Grupo) grupos.get(nome);		
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return the usuarioInformacao
	 */
	public UsuarioInformacao getUsuarioInformacao() {
		return usuarioInformacao;
	}

	/**
	 * @param usuarioInformacao the usuarioInformacao to set
	 */
	public void setUsuarioInformacao(UsuarioInformacao usuarioInformacao) {
		this.usuarioInformacao = usuarioInformacao;
	}	

	/**
	 * @return the grupos
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getGrupos() {
		return new ArrayList(grupos.values());
	}

	/**
	 * @param grupos the grupos to set
	 */
	@SuppressWarnings("rawtypes")
	public void setGruposDTO(Map grupos) {
		this.grupos = grupos;
	}
}
