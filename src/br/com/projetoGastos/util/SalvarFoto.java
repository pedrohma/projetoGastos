package br.com.projetoGastos.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;

import br.com.projetoGastos.beans.UsuarioBean;

public class SalvarFoto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8961871850898237719L;

	public static String salvarFoto(UsuarioBean usuarioBean){
		
		String nomeFoto = "";
		
		try{
			String path = "C:\\Users\\Marines\\Desktop\\workspace\\projetoGastos\\WebContent\\img\\";
			
			nomeFoto = usuarioBean.getUsuario().getLogin() + ".jpg";
			
			File f = new File(path + nomeFoto);
			
			FileOutputStream out = new FileOutputStream(f);
			out.write(usuarioBean.getImagem().getFileData());
			
			//Upload
			out.flush();
			out.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Ocorreu um erro ao salvar a foto -> " + e.getMessage());
		}
		
		return nomeFoto;
	
	}

}
