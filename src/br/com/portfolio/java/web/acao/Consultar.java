package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.Principal;
import br.com.portfolio.java.web.util.Acao;

public class Consultar implements Acao {

	@Override
	public boolean executar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[ Consultar ]");
		request.setAttribute("menuBody", "consultas.jsp");
		request.setAttribute("targetPage", "index.jsp");

		return true;
	}


}
