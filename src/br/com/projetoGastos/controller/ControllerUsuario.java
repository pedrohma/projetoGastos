package br.com.projetoGastos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.projetoGastos.beans.UsuarioBean;
import br.com.projetoGastos.entity.Usuario;
import br.com.projetoGastos.persistence.UsuarioDao;
import br.com.projetoGastos.util.SalvarFoto;

public class ControllerUsuario extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String cmd = request.getParameter("cmd");
		
		if(cmd.equalsIgnoreCase("logar")){
			return logar(mapping, form, request, response);
		}
		else if(cmd.equalsIgnoreCase("cadastrar")){
			return cadastrar(mapping, form, request, response);
		}
		
		
		return super.execute(mapping, form, request, response);
	}

	private ActionForward cadastrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		try{
			UsuarioBean usuarioBean = (UsuarioBean) form;
			String caminho = SalvarFoto.salvarFoto(usuarioBean);
			usuarioBean.getUsuario().setFoto(caminho);
			new UsuarioDao().salvar(usuarioBean.getUsuario());
			request.setAttribute("msg", usuarioBean.getUsuario().getNome() + " cadastrado(a) com sucesso!");
			usuarioBean.setUsuario(new Usuario());
		}
		catch(Exception e){
			request.setAttribute("erroCad", "Ocorreu um erro ao realizar o cadastro! -> " + e.getMessage());
		}
		
		return mapping.findForward("index.jsp");
	}

	private ActionForward logar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
