package br.com.portfolio.java.web.service;

import java.util.ArrayList;
import java.util.List;

public class FuctionalityService {
	public static List<String> consultaFuncionalidades(String menuName, String prefixPath, String username){

		List<String> listaInclude = new ArrayList<String>();
		String[] listaFuncionalidade;
		
		if(username.equals("admin")) {
			String[] funcionalidade = {
					"usuario","lista","funcionalidade","documento","duvida","evento","perfil","permissao","politica","repositorio"
			};
			
			listaFuncionalidade = funcionalidade;
		} else {
			String[] funcionalidade = {
					"lista","documento","duvida","evento"
			};
			
			listaFuncionalidade = funcionalidade;
		}

		for (String funcionalidade : listaFuncionalidade) {
			listaInclude.add(prefixPath + funcionalidade + ".jsp");
		}

		return listaInclude;
	}
}
