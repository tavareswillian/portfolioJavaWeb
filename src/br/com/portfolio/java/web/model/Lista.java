package br.com.portfolio.java.web.model;

import java.io.Serializable;

public class Lista implements Serializable{

	private static final long serialVersionUID = 1L;

	private long idLista;
	
	private String nmLista;
	
	private String dsLista;

	public long getIdLista() {
		return idLista;
	}

	public void setIdLista(long idLista) {
		this.idLista = idLista;
	}

	public String getNmLista() {
		return nmLista;
	}

	public void setNmLista(String nmLista) {
		this.nmLista = nmLista;
	}

	public String getDsLista() {
		return dsLista;
	}

	public void setDsLista(String dsLista) {
		this.dsLista = dsLista;
	}
}
