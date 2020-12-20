package br.com.portfolio.java.web.acao;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.dto.Menu;
import br.com.portfolio.java.web.service.PageService;
import br.com.portfolio.java.web.util.Acao;

public class Consultar implements Acao {

	@Override
	public boolean executar(HttpSession sessao) {
		
		System.out.println("[ Consultar ]");
		sessao.setAttribute("targetPage", "MenuLoader");
		sessao.setAttribute("targetPagePrev", "index.jsp");
		String prefixPath = "consulta/";
		sessao.setAttribute("prefixPath", prefixPath);

		List<Menu> listaMenu = PageService.loadMenuList(sessao);
		sessao.setAttribute("menuList", listaMenu);
		
		if(listaMenu == null) {
			sessao.setAttribute("targetPage", "Error");
		}
		return false;
	}


}
