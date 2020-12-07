package br.com.portfolio.java.web.model;

import java.io.Serializable;

public class Funcionalidade implements Serializable{

	private static final long serialVersionUID = 1L;

	private long idFuncionalidade;
	
	private String nmFuncionalidade;
	
	private String dsFuncionalidade;
	
	private String sourcePage;
	
	private String pageLink;
	
	private String iconType;

	public long getIdFuncionalidade() {
		return idFuncionalidade;
	}

	public void setIdFuncionalidade(long idFuncionalidade) {
		this.idFuncionalidade = idFuncionalidade;
	}

	public String getNmFuncionalidade() {
		return nmFuncionalidade;
	}

	public void setNmFuncionalidade(String nmFuncionalidade) {
		this.nmFuncionalidade = nmFuncionalidade;
	}

	public String getDsFuncionalidade() {
		return dsFuncionalidade;
	}

	public void setDsFuncionalidade(String dsFuncionalidade) {
		this.dsFuncionalidade = dsFuncionalidade;
	}

	public String getSourcePage() {
		return sourcePage;
	}

	public void setSourcePage(String sourcePage) {
		this.sourcePage = sourcePage;
	}

	public String getPageLink() {
		return pageLink;
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public String getIconType() {
		return iconType;
	}

	public void setIconType(String iconType) {
		this.iconType = iconType;
	}
	
	
}
