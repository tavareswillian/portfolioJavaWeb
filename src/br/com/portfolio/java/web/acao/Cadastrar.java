package br.com.portfolio.java.web.acao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portfolio.java.web.Principal;
import br.com.portfolio.java.web.service.FuctionalityService;
import br.com.portfolio.java.web.service.PageService;
import br.com.portfolio.java.web.util.Acao;

public class Cadastrar implements Acao {

	@Override
	public boolean executar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[ Cadastrar ]");
		request.setAttribute("targetPage", "index.jsp");
		String prefixPath = "cadastro/";
		List<String> listaInclude = FuctionalityService.consultaFuncionalidades(prefixPath, prefixPath, Principal.getUsername());
		
		request.setAttribute("menuBody", listaInclude);
		request.setAttribute("optionList", PageService.obtemMenuOpcoes(prefixPath, Principal.getUsername()));
		request.setAttribute("functionList", listaInclude);

		return true;
	}


}
