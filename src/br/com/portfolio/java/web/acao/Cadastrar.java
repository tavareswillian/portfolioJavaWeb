package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portfolio.java.web.util.Acao;

public class Cadastrar implements Acao {

	@Override
	public boolean executar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[ Cadastrar ]");
		request.setAttribute("targetPage", "index.jsp");
		request.setAttribute("menuBody", "cadastro.jsp");
		return true;
	}


}
