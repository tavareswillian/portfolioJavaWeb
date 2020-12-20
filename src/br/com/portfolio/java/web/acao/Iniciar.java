package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.util.Acao;

public class Iniciar implements Acao {

	@Override
	public boolean executar(HttpSession sessao) {
		sessao.setAttribute("targetPage", "Cadastrar");	
		return false;
	}

}
