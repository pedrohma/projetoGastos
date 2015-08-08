package br.com.projetoGastos.beans;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import br.com.projetoGastos.entity.Usuario;

public class UsuarioBean extends ActionForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3458113166029142491L;

	private Usuario usuario;
	
	private FormFile imagem;
	
	public UsuarioBean() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FormFile getImagem() {
		return imagem;
	}

	public void setImagem(FormFile imagem) {
		this.imagem = imagem;
	}	
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors erros = new ActionErrors();
		
		Pattern regexNome = Pattern.compile("A-Za-zÀ-Üà-ü\\s]{6,50}$");
		
		if(usuario.getNome() != null){
			Matcher m = regexNome.matcher(usuario.getNome());
			
			if(!m.matches()){
				erros.add("nomeinvalido", new ActionMessage("erro.nome"));
			}
		}
		
		return erros;
	}

}
