package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portfolio.java.web.Principal;
import br.com.portfolio.java.web.service.UserService;
import br.com.portfolio.java.web.util.Acao;

public class Sair implements Acao {

	@Override
	public boolean executar(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("[ Sair ]");
		String mensagem = "<p style='color: green;'><b>Sessão encerrada!</b></p>";
		
		request.setAttribute("targetPage", "login.jsp");
		request.setAttribute("mensagem", mensagem);
		
		UserService.removeSessao(Principal.getCurrentSession());
		
		return true;
	}

}
