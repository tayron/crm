package br.com.crm.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.crm.encapsuladores.GrupoEncapsulador;
import br.com.crm.enuns.TipoMensagem;
import br.com.crm.excecoes.ExcecaoServico;
import br.com.crm.modelos.Grupo;
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
	private Grupo grupo;
	
	/** 
	 * @see IGrupoBean#listarGrupos()
	 */
	@Override
	public List<Grupo> listarGrupos(){
		List<Grupo> listaGrupos = new ArrayList<Grupo>();
		try {
			List<GrupoEncapsulador>listaGruposDTO = servicoGrupo.listar();
			
			for(GrupoEncapsulador grupoDTO : listaGruposDTO){
				Grupo grupo = new Grupo();
				grupo.setId(grupoDTO.getId());
				grupo.setNome(grupoDTO.getNome());
				
				listaGrupos.add(grupo);
			}
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
			GrupoEncapsulador grupoDTO = new GrupoEncapsulador();
			grupoDTO.setId(grupo.getId());
			grupoDTO.setNome(grupo.getNome());
			
			servicoGrupo.incluir(grupoDTO);
			
			mensagem.exibirAviso("Sucesso", TipoMensagem.CADASTRO_SUCESSO.getDescricao());
			grupo = null;
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
		GrupoEncapsulador grupoDTO = new GrupoEncapsulador();
		grupoDTO.setId(Integer.parseInt(id));
		
		try {
			grupoDTO = servicoGrupo.recuperar(grupoDTO);
			grupo = new Grupo();
			grupo.setId(grupoDTO.getId());
			grupo.setNome(grupoDTO.getNome());
			
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
			GrupoEncapsulador grupoDTO = new GrupoEncapsulador();
			grupoDTO.setId(grupo.getId());
			grupoDTO.setNome(grupo.getNome());			
			servicoGrupo.alterar(grupoDTO);
			
			mensagem.exibirAviso("Sucesso", TipoMensagem.SALVO_SUCESSO.getDescricao());
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.SALVO_ERRO.getDescricao());
		}
	}
	
	/**
	 * @see IGrupoBean#excluirGrupo(Grupo)
	 */
	@Override
	public void excluirGrupo(Grupo grupo){
		Mensagem mensagem = new Mensagem();
		
		GrupoEncapsulador grupoDTO = new GrupoEncapsulador();
		grupoDTO.setId(grupo.getId());
		
		try {
			servicoGrupo.excluir(grupoDTO);
			
			mensagem.exibirAviso("Sucesso", TipoMensagem.EXCLUIDO_SUCESSO.getDescricao());
		} catch (ExcecaoServico e) {			
			mensagem.exibirAviso("Erro", TipoMensagem.EXCLUIDO_ERRO.getDescricao());
		}		
	}
	
	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		if(grupo == null){
			grupo = new Grupo();
		}
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	/**
	 * 
	 */
	public String cadastrarGrupo(){
		return "cadastrar";
	}
}
