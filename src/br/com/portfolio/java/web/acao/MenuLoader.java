package br.com.portfolio.java.web.acao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.dto.MenuOption;
import br.com.portfolio.java.web.service.FuctionalityService;
import br.com.portfolio.java.web.service.PageService;
import br.com.portfolio.java.web.util.Acao;

public class MenuLoader implements Acao {

	@Override
	public boolean executar(HttpSession sessao) {

		String prefixPath = (String) sessao.getAttribute("prefixPath");
		String targetPagePrev = (String) sessao.getAttribute("targetPagePrev");
		String usr = (String) sessao.getAttribute("usr");
		sessao.setAttribute("targetPage", targetPagePrev);
		
		List<String> listaInclude = new ArrayList<String>();
		List<String> listaFuncionalidade = FuctionalityService.consultaFuncionalidades(usr);

		for (String funcionalidade : listaFuncionalidade) listaInclude.add(prefixPath + funcionalidade + ".jsp");

		List<MenuOption> optionList = PageService.obtemMenuOpcoes(prefixPath, usr, listaFuncionalidade);
		if(optionList != null && listaInclude != null 
				&& optionList.size() != listaInclude.size()) {
			System.out.println("Atenção!!!! Lista de funcionalidades incompatível");	
		}
		
		if(optionList == null || listaInclude == null
				|| optionList.size() == 0 || listaInclude.size() == 0) {
			sessao.setAttribute("optionList", "");
			sessao.setAttribute("menuBody", "");
			sessao.setAttribute("functionList", "");
		} else {
			sessao.setAttribute("optionList", optionList);
			sessao.setAttribute("menuBody", listaInclude);
			sessao.setAttribute("functionList", listaInclude);
		}

		if(listaFuncionalidade == null) sessao.setAttribute("targetPage", "Login");
		
		return true;
	}

}
