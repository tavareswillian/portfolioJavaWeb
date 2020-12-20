package br.com.portfolio.java.web.service;

import java.util.ArrayList;
import java.util.List;

public class FuctionalityService {
	public static List<String> consultaFuncionalidades(String usr){
		
		List<String> listaFuncionalidade = new ArrayList<String>();
		
		if(usr == null) {
			
		} else if (usr.equals("admin")) {
			listaFuncionalidade.add("usuario");
			listaFuncionalidade.add("lista");
			listaFuncionalidade.add("funcionalidade");
			listaFuncionalidade.add("documento");
			listaFuncionalidade.add("duvida");
			listaFuncionalidade.add("evento");
			listaFuncionalidade.add("perfil");
			listaFuncionalidade.add("permissao");
			listaFuncionalidade.add("politica");
			listaFuncionalidade.add("repositorio");
		} else {
			listaFuncionalidade.add("lista");
			listaFuncionalidade.add("documento");
			listaFuncionalidade.add("duvida");
			listaFuncionalidade.add("evento");
		}
		
		return listaFuncionalidade;
	}
}
