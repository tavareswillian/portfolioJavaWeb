package br.com.portfolio.java.web.dto;

public class Autenticador{

	private long idAutenticador;
	
	private String hashSessao;
	
	private boolean expirado;
	
	public Autenticador(long idAutenticador, String hashSessao, boolean expirado) {
		super();
		this.idAutenticador = idAutenticador;
		this.hashSessao = hashSessao;
		this.expirado = expirado;
	}

	public Autenticador(String hashSessao) {
		super();
		this.hashSessao = hashSessao;
	}
	
	public long getIdAutenticador() {
		return idAutenticador;
	}

	public void setIdAutenticador(long idAutenticador) {
		this.idAutenticador = idAutenticador;
	}

	public String getHashSessao() {
		return hashSessao;
	}

	public void setHashSessao(String hashSessao) {
		this.hashSessao = hashSessao;
	}

	public boolean isExpirado() {
		return expirado;
	}

	public void setExpirado(boolean expirado) {
		this.expirado = expirado;
	}
}
