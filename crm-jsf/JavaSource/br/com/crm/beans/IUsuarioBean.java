package br.com.crm.beans;

import java.util.List;

import br.com.crm.dtos.UsuarioDTO;

public interface IUsuarioBean {

	/**
	 * Método que busca todos os usuários cadastrados
	 */
	public abstract List<UsuarioDTO> listarUsuarios();

}