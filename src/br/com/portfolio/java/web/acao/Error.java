package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.util.Acao;

public class Error implements Acao {
	
	@Override
	public boolean executar(HttpSession sessao) {
		
		System.out.println("[ Error ]");
		sessao.setAttribute("targetPage", "login.jsp");
		
		return false;
	}


}
