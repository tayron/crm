package br.com.crm.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.crm.dtos.GrupoDTO;
import br.com.crm.enuns.TipoMensagem;
import br.com.crm.excecoes.ExcecaoServico;
import br.com.crm.servicos.IServicoGrupo;
import br.com.crm.utils.Mensagem;

/**
 * Classe que gerencia as solicitações do usuário em relação aos dados de grupo
 */
@ManagedBean
@RequestScoped
public class GrupoBean implements IGrupoBean {

	/**
	 * Injeção do serviço grupo para manipulação de dados
	 */
	@EJB
	private IServicoGrupo servicoGrupo;
	
	/**
	 * Objeto DTO que representa os dados do grupo
	 */
	private GrupoDTO grupoDTO;
	
	/** 
	 * @see IGrupoBean#listarGrupos()
	 */
	@Override
	public List<GrupoDTO> listarGrupos(){
		List<GrupoDTO> listaGrupos = new ArrayList<GrupoDTO>();
		try {
			listaGrupos = servicoGrupo.listar();
		} catch (ExcecaoServico e) {
			e.printStackTrace();
		}
		return listaGrupos;
	}
	
	/**
	 * @see IGrupoBean#cadastrarDadosDoGrupo()
	 */
	@Override
	public void cadastrarDadosDoGrupo() {
		Mensagem mensagem = new Mensagem();
		try {
			servicoGrupo.incluir(grupoDTO);
			mensagem.exibirAviso("Sucesso", TipoMensagem.CADASTRO_SUCESSO.getDescricao());
			grupoDTO = null;
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.CADASTRO_ERRO.getDescricao());
		}
	}
	
	/**
	 * @see IGrupoBean#exibirTelaAlterarGrupo(String) 
	 */
	@Override
	public String exibirTelaAlterarGrupo(String id) {
		if(buscarDadosGrupo(id)){
			return "alterar";
		}else{
			Mensagem mensagem = new Mensagem();
			mensagem.exibirAviso("Erro", "Não foi possível recuperar os dados do grupo");
			return "index";
		}
	}	
	
	/**
	 * Método que busca os dados do grupo através do seu id
	 */
	private boolean buscarDadosGrupo(String id){
		GrupoDTO parametros = new GrupoDTO();
		parametros.setId(Integer.parseInt(id));
		try {
			grupoDTO = servicoGrupo.recuperar(parametros);
			return true;
		} catch (ExcecaoServico e) {
			return false;
		}		
	}	
	
	/**
	 * @see IGrupoBean#alterarDadosDoGrupo()
	 */
	@Override
	public void alterarDadosDoGrupo() {
		Mensagem mensagem = new Mensagem();
		try {
			servicoGrupo.alterar(grupoDTO);
			mensagem.exibirAviso("Sucesso", TipoMensagem.SALVO_SUCESSO.getDescricao());
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.SALVO_ERRO.getDescricao());
		}
	}
	
	/**
	 * @see IGrupoBean#excluirGrupo(GrupoDTO)
	 */
	@Override
	public void excluirGrupo(GrupoDTO grupoDTO){
		Mensagem mensagem = new Mensagem();
		try {
			servicoGrupo.excluir(grupoDTO);
			mensagem.exibirAviso("Sucesso", TipoMensagem.EXCLUIDO_SUCESSO.getDescricao());
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.EXCLUIDO_ERRO.getDescricao());
		}		
	}
	
	/**
	 * @return the grupoDTO
	 */
	public GrupoDTO getGrupoDTO() {
		if(grupoDTO == null){
			grupoDTO = new GrupoDTO();
		}
		return grupoDTO;
	}

	/**
	 * @param grupoDTO the grupoDTO to set
	 */
	public void setGrupoDTO(GrupoDTO grupoDTO) {
		this.grupoDTO = grupoDTO;
	}
	
	/**
	 * 
	 */
	public String cadastrarGrupo(){
		return "cadastrar";
	}
}
