package br.com.portfolio.java.web.util;

import javax.servlet.http.HttpSession;

public interface Acao {
	boolean executar(HttpSession sessao);
}
