/**
 * 
 */
package br.com.crm.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.crm.daos.GrupoDAO;
import br.com.crm.daos.UsuarioDAO;
import br.com.crm.encapsuladores.GrupoEncapsulador;
import br.com.crm.encapsuladores.UsuarioDadosSessaoEncapsulador;
import br.com.crm.encapsuladores.UsuarioEncapsulador;
import br.com.crm.entidades.Grupo;
import br.com.crm.entidades.Usuario;
import br.com.crm.excecoes.ExcecaoModelo;
import br.com.crm.excecoes.ExcecaoServico;
import br.com.crm.repositorios.IDaoRepositorio;

/**
 * Classe que disponibiliza serviços para manipulação do usuario
 */
@Stateless
public class ServicoUsuario implements IServicoUsuario{

	/**
	 * Injetando dao repositório para manipulação dos dados do usuário
	 */
	@EJB
	IDaoRepositorio daoRepotorio;
	
	/**
	 * Armazena o UsuarioDAO para manipulacao dos dados do usuário
	 */
	UsuarioDAO usuarioDAO;

	/**
	 * Armazena o GrupoDAO para manipulacao dos dados do grupo
	 */	
	GrupoDAO grupoDAO;
	
	/**
	 * Busca o dao usuário no repositório e armazena em usuarioDAO
	 */
	@PostConstruct
	public void initialize(){
		usuarioDAO = daoRepotorio.getUsuario();
		grupoDAO = daoRepotorio.getGrupo();
	}
	
	/**
	 * @see IServicoUsuario#incluir(UsuarioEncapsulador)
	 */
	@Override
	public void incluir(UsuarioEncapsulador usuarioDTO) throws ExcecaoServico {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setEndereco(usuarioDTO.getEndereco());		
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setAtivo(usuarioDTO.getAtivo());
		
		Grupo grupo = new Grupo();
		grupo.setId(usuarioDTO.getGrupoDTO().getId());
		
		try {
			usuario.setGrupo(grupoDAO.recuperar(grupo));
		} catch (ExcecaoModelo e1) {
			throw new ExcecaoServico("Não foi possível vincular o grupo selecionado ao novo usuário");
		}
		
		if(usuarioDTO.getSenha().equals(usuarioDTO.getConfirmaSenha())){
			usuario.setSenha(usuarioDTO.getSenha());	
		}else{
			throw new ExcecaoServico("O valor do campo confirmar senha está diferente do campo senha");
		}
		
		try {
			usuarioDAO.incluir(usuario);
		} catch (ExcecaoModelo e) {
			throw new ExcecaoServico("Não foi possível salvar os dados do usuário");
		}
	}

	/**
	 * @see IServicoUsuario#alterar(UsuarioEncapsulador)
	 */
	@Override
	public void alterar(UsuarioEncapsulador usuarioDTO) throws ExcecaoServico {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		
		try {
			usuario = usuarioDAO.recuperar(usuario);
			usuario.setAtivo(usuarioDTO.getAtivo());
			usuario.setCpf(usuarioDTO.getCpf());
			usuario.setEndereco(usuarioDTO.getEndereco());
			usuario.setLogin(usuarioDTO.getLogin());
			usuario.setNome(usuarioDTO.getNome());
			
			Grupo grupo = new Grupo();
			grupo.setId(usuarioDTO.getGrupoDTO().getId());
			
			try {
				usuario.setGrupo(grupoDAO.recuperar(grupo));
			} catch (ExcecaoModelo e1) {
				throw new ExcecaoServico("Não foi possível vincular o grupo selecionado ao novo usuário");
			}			
			
			if(usuarioDTO.getSenha() != "" && usuarioDTO.getSenha().equals(usuarioDTO.getConfirmaSenha())){
				usuario.setSenha(usuarioDTO.getSenha());	
			}else if(usuarioDTO.getSenha() != "" && !usuarioDTO.getSenha().equals(usuarioDTO.getConfirmaSenha())){
				throw new ExcecaoServico("O valor do campo confirmar senha está diferente do campo senha");
			}
			
			usuarioDAO.alterar(usuario);
		} catch (ExcecaoModelo e) {
			throw new ExcecaoServico("Não foi possível salvar os dados do usuário");
		}
		
	}

	/**
	 * @see IServicoUsuario#excluir(UsuarioEncapsulador)
	 */
	@Override
	public void excluir(UsuarioEncapsulador usuarioDTO) throws ExcecaoServico {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(usuarioDTO.getId());	
			usuario = usuarioDAO.recuperar(usuario);
			
			usuarioDAO.excluir(usuario);
		} catch (ExcecaoModelo e) {
			throw new ExcecaoServico("Não foi possível excluir os dados do usuário");
		}
		
	}

	/**
	 * @see servico.IServicoUsuario#listar()
	 */
	@Override
	public List<UsuarioEncapsulador> listar() throws ExcecaoServico {		
		try {
			List<UsuarioEncapsulador> usuariosDTO = new ArrayList<UsuarioEncapsulador>();
			List<Usuario> usuarios = usuarioDAO.listar();
			
			for(Usuario usuario : usuarios){				
				usuariosDTO.add(transformarUsuarioDTO(usuario));
			}

			return usuariosDTO;
			
		} catch (ExcecaoModelo e) {
			return null;
		}		
	}

	/**
	 * @see IServicoUsuario#recuperar(UsuarioEncapsulador)
	 */
	@Override
	public UsuarioEncapsulador recuperar(UsuarioEncapsulador usuarioDTO) throws ExcecaoServico {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(usuarioDTO.getId());			
			return transformarUsuarioDTO(usuarioDAO.recuperar(usuario));
		} catch (ExcecaoModelo e) {
			return null;
		}
	}	
	
	/**
	 * Método que transforma uma entidade usuário em usuarioDTO
	 */
	private UsuarioEncapsulador transformarUsuarioDTO(Usuario usuario){
		UsuarioEncapsulador usuarioDTO = new UsuarioEncapsulador();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNome(usuario.getNome());
		usuarioDTO.setCpf(usuario.getCpf());
		usuarioDTO.setEndereco(usuario.getEndereco());		
		usuarioDTO.setLogin(usuario.getLogin());
		usuarioDTO.setAtivo(usuario.getAtivo());
		
		GrupoEncapsulador grupoDTO = new GrupoEncapsulador();
		
		if(usuario.getGrupo() != null){
			grupoDTO.setId(usuario.getGrupo().getId());
			grupoDTO.setNome(usuario.getGrupo().getNome());
		}
		
		usuarioDTO.setGrupoDTO(grupoDTO);
		
		return usuarioDTO;
	}
	
	/**
	 * @see IServicoUsuario#consultarPorLogin(UsuarioEncapsulador)
	 */
	public UsuarioDadosSessaoEncapsulador consultarPorLogin(UsuarioEncapsulador parametro) throws ExcecaoServico {		
		try {
			Usuario usuario = usuarioDAO.consultarPorLogin(parametro.getLogin());
			
			UsuarioDadosSessaoEncapsulador usuarioEncapsulador = new UsuarioDadosSessaoEncapsulador();
			usuarioEncapsulador.setNome(usuario.getNome());
			usuarioEncapsulador.setLogin(usuario.getLogin());
			usuarioEncapsulador.setGrupo(usuario.getGrupo().getNome());
			
			return usuarioEncapsulador;
		} catch (ExcecaoModelo e) {
			return null;
		}
		
	}
}
