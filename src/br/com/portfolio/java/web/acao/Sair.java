package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.service.UserService;
import br.com.portfolio.java.web.util.Acao;
import br.com.portfolio.java.web.util.PortfolioClientAPI;

public class Sair implements Acao {

	@Override
	public boolean executar(HttpSession sessao) {

		System.out.println("[ Sair ]");		
		UserService.removeSessao(sessao);
		PortfolioClientAPI.removeAutenticador(sessao.getId());
		sessao.setAttribute("usr", null);
		sessao.setAttribute("password", null);
		
		return true;
	}

}
