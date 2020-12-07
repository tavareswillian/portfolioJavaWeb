package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portfolio.java.web.util.Acao;

public class Configurar implements Acao {

	@Override
	public boolean executar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[ Configurar ]");
		request.setAttribute("targetPage", "index.jsp");
		request.setAttribute("menuBody", "configuracao.jsp");
		return true;
	}


}
