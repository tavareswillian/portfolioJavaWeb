package br.com.portfolio.java.web.util;

import javax.servlet.http.HttpSession;

public class UserCurrentSession {
	private String idSession;
	private HttpSession sessao;
	
	public UserCurrentSession(String idSession, HttpSession sessao) {
		this.idSession = idSession;
		this.sessao = sessao;
	}

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public HttpSession getSessao() {
		return sessao;
	}

	public void setSessao(HttpSession sessao) {
		this.sessao = sessao;
	}
}
