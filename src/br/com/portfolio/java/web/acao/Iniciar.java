package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portfolio.java.web.util.Acao;

public class Iniciar implements Acao {

	@Override
	public boolean executar(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("[ Iniciar ]");
		request.setAttribute("targetPage", "index.jsp");
		return true;

	}

}
