/**
 * 
 */
package br.com.crm.servico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;

import br.com.crm.entidades.pessoas.Usuario;
import br.com.crm.entidades.pessoas.autorizacao.Permissao;
import br.com.crm.entidades.pessoas.autorizacao.TipoPermissao;
import br.com.crm.modelo.dao.UsuarioDAO;
import br.com.crm.modelo.excecoes.ExcecaoModelo;
import br.com.crm.servico.dto.PermissaoDTO;
import br.com.crm.servico.dto.TipoPermissaoDTO;
import br.com.crm.servico.dto.UsuarioDTO;
import br.com.crm.servico.excecao.ExcecaoServico;

/**
 * Classe que define os métodos padrão de um serviço
 */
public class ServicoUsuario implements IServico<UsuarioDTO> {

	/**
	 * Injetando usuario DAO para manipulação dos dados do usuário
	 */
	@EJB
	UsuarioDAO usuarioDAO;
	
	@Override
	public void incluir(UsuarioDTO usuarioDTO) throws ExcecaoServico {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setEndereco(usuarioDTO.getEndereco());		
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setAtivo(usuarioDTO.getAtivo());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setConfirmaSenha(usuarioDTO.getConfirmaSenha());
		
		if(usuarioDTO.getListaPermissoes().size() > 0){
			
			List<Permissao> listaPermissoes = new ArrayList<Permissao>();
			
			for(PermissaoDTO permissaoDTO : usuarioDTO.getListaPermissoes()){
				Permissao permissao = new Permissao();
				permissao.setTela(permissaoDTO.getTela());
				
				if(permissao.getTipoPermissao() != null){
					TipoPermissao tipoPermissao = new TipoPermissao();
					tipoPermissao.setSigla(permissao.getTipoPermissao().getSigla());
					tipoPermissao.setDescricao(permissao.getTipoPermissao().getDescricao());
					permissao.setTipoPermissao(tipoPermissao);
				}

				listaPermissoes.add(permissao);
			}
				
			usuario.setListaPermissoes(listaPermissoes);
		}
		
		try {
			usuarioDAO.incluir(usuario);
		} catch (ExcecaoModelo e) {
			new ExcecaoServico("Não foi possível salvar os dados do usuário");
		}
	}

	@Override
	public void alterar(UsuarioDTO usuarioDTO) throws ExcecaoServico {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setEndereco(usuarioDTO.getEndereco());		
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setAtivo(usuarioDTO.getAtivo());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setConfirmaSenha(usuarioDTO.getConfirmaSenha());
		
		if(usuarioDTO.getListaPermissoes().size() > 0){
			
			List<Permissao> listaPermissoes = new ArrayList<Permissao>();
			
			for(PermissaoDTO permissaoDTO : usuarioDTO.getListaPermissoes()){
				Permissao permissao = new Permissao();
				permissao.setId(permissaoDTO.getId());
				permissao.setTela(permissaoDTO.getTela());
				
				if(permissao.getTipoPermissao() != null){
					TipoPermissao tipoPermissao = new TipoPermissao();
					tipoPermissao.setId(permissao.getTipoPermissao().getId());
					tipoPermissao.setSigla(permissao.getTipoPermissao().getSigla());
					tipoPermissao.setDescricao(permissao.getTipoPermissao().getDescricao());
					permissao.setTipoPermissao(tipoPermissao);
				}

				listaPermissoes.add(permissao);
			}
				
			usuario.setListaPermissoes(listaPermissoes);
		}
		
		try {
			usuarioDAO.alterar(usuario);
		} catch (ExcecaoModelo e) {
			new ExcecaoServico("Não foi possível salvar os dados do usuário");
		}
		
	}

	@Override
	public void excluir(UsuarioDTO usuarioDTO) throws ExcecaoServico {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(usuarioDTO.getId());			
			usuarioDAO.excluir(usuario);
		} catch (ExcecaoModelo e) {
			new ExcecaoServico("Não foi possível excluir os dados do usuário");
		}
		
	}

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
		
		if(usuario.getListaPermissoes().size() > 0){
			
			List<PermissaoDTO> listaPermissoesDTO = new ArrayList<PermissaoDTO>();
			
			for(Permissao permissao : usuario.getListaPermissoes()){
				PermissaoDTO permissaoDTO = new PermissaoDTO();
				permissaoDTO.setId(permissao.getId());
				permissaoDTO.setTela(permissao.getTela());
				
				if(permissao.getTipoPermissao() != null){
					TipoPermissaoDTO tipoPermissaoDTO = new TipoPermissaoDTO();
					tipoPermissaoDTO.setId(permissao.getTipoPermissao().getId());
					tipoPermissaoDTO.setSigla(permissao.getTipoPermissao().getSigla());
					tipoPermissaoDTO.setDescricao(permissao.getTipoPermissao().getDescricao());
					permissaoDTO.setTipoPermissao(tipoPermissaoDTO);
				}

				listaPermissoesDTO.add(permissaoDTO);
			}
				
			usuarioDTO.setListaPermissoes(listaPermissoesDTO);					
		}
		
		return usuarioDTO;
	}
}