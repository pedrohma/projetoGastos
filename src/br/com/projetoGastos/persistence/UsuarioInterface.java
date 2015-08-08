package br.com.projetoGastos.persistence;

import br.com.projetoGastos.entity.Usuario;

public interface UsuarioInterface {
	
	public void salvar(Usuario usuario) throws Exception;
	
	public Usuario logar(Usuario usuario) throws Exception;
		
}
