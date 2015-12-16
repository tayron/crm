/**
 * 
 */
package br.com.crm.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.crm.daos.UsuarioDAO;
import br.com.crm.dtos.GrupoDTO;
import br.com.crm.dtos.UsuarioDTO;
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
	 * Busca o dao usuário no repositório e armazena em usuarioDAO
	 */
	@PostConstruct
	public void initialize(){
		usuarioDAO = daoRepotorio.getUsuario();
	}
	
	/**
	 * @see IServicoUsuario#incluir(UsuarioDTO)
	 */
	@Override
	public void incluir(UsuarioDTO usuarioDTO) throws ExcecaoServico {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setEndereco(usuarioDTO.getEndereco());		
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setAtivo(usuarioDTO.getAtivo());
		
		Grupo grupo = new Grupo();
		grupo.setId(usuarioDTO.getGrupoDTO().getId());
		grupo.setNome(usuarioDTO.getGrupoDTO().getNome());
		
		usuario.setGrupo(grupo);
		
		if(usuarioDTO.getSenha() != null && usuarioDTO.getSenha().equals(usuarioDTO.getConfirmaSenha())){
			usuario.setSenha(usuarioDTO.getSenha());	
		}else if(usuarioDTO.getSenha() != null && !usuarioDTO.getSenha().equals(usuarioDTO.getConfirmaSenha())){
			new ExcecaoServico("O valor do campo confirmar senha está diferente do campo senha");
		}
		
		try {
			usuarioDAO.incluir(usuario);
		} catch (ExcecaoModelo e) {
			new ExcecaoServico("Não foi possível salvar os dados do usuário");
		}
	}

	/**
	 * @see IServicoUsuario#alterar(UsuarioDTO)
	 */
	@Override
	public void alterar(UsuarioDTO usuarioDTO) throws ExcecaoServico {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		
		try {
			usuario = usuarioDAO.recuperar(usuario);
			usuario.setAtivo(usuarioDTO.getAtivo());
			usuario.setCpf(usuarioDTO.getCpf());
			usuario.setEndereco(usuarioDTO.getEndereco());
			usuario.setLogin(usuarioDTO.getLogin());
			usuario.setNome(usuarioDTO.getNome());
			
			if(usuarioDTO.getSenha() != null && usuarioDTO.getSenha().equals(usuarioDTO.getConfirmaSenha())){
				usuario.setSenha(usuarioDTO.getSenha());	
			}else if(usuarioDTO.getSenha() != null && !usuarioDTO.getSenha().equals(usuarioDTO.getConfirmaSenha())){
				new ExcecaoServico("O valor do campo confirmar senha está diferente do campo senha");
			}
			
			usuarioDAO.alterar(usuario);
		} catch (ExcecaoModelo e) {
			new ExcecaoServico("Não foi possível salvar os dados do usuário");
		}
		
	}

	/**
	 * @see IServicoUsuario#excluir(UsuarioDTO)
	 */
	@Override
	public void excluir(UsuarioDTO usuarioDTO) throws ExcecaoServico {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(usuarioDTO.getId());	
			usuario = usuarioDAO.recuperar(usuario);
			
			usuarioDAO.excluir(usuario);
		} catch (ExcecaoModelo e) {
			new ExcecaoServico("Não foi possível excluir os dados do usuário");
		}
		
	}

	/**
	 * @see servico.IServicoUsuario#listar()
	 */
	@Override
	public List<UsuarioDTO> listar() throws ExcecaoServico {		
		try {
			List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
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
	 * @see IServicoUsuario#recuperar(UsuarioDTO)
	 */
	@Override
	public UsuarioDTO recuperar(UsuarioDTO usuarioDTO) throws ExcecaoServico {
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
	private UsuarioDTO transformarUsuarioDTO(Usuario usuario){
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNome(usuario.getNome());
		usuarioDTO.setCpf(usuario.getCpf());
		usuarioDTO.setEndereco(usuario.getEndereco());		
		usuarioDTO.setLogin(usuario.getLogin());
		usuarioDTO.setAtivo(usuario.getAtivo());
		
		GrupoDTO grupoDTO = new GrupoDTO();
		
		if(usuario.getGrupo() != null){
			grupoDTO.setId(usuario.getGrupo().getId());
			grupoDTO.setNome(usuario.getGrupo().getNome());
		}
		
		usuarioDTO.setGrupoDTO(grupoDTO);
		
		return usuarioDTO;
	}
}
