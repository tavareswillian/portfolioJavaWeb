package br.com.portfolio.java.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	boolean executar(HttpServletRequest request, HttpServletResponse response);
}
