package br.com.portfolio.java.web.dto;

import java.util.ArrayList;
import java.util.List;

public class WebPage {
	private String titlePage;
	private String descriPition;
	private String subTitlePage;
	private List<MenuOption> menuOptionList = new ArrayList<MenuOption>();

	public String getTitlePage() {
		return titlePage;
	}
	public void setTitlePage(String titlePage) {
		this.titlePage = titlePage;
	}
	public String getDescriPition() {
		return descriPition;
	}
	public void setDescriPition(String descriPition) {
		this.descriPition = descriPition;
	}
	public String getSubTitlePage() {
		return subTitlePage;
	}
	public void setSubTitlePage(String subTitlePage) {
		this.subTitlePage = subTitlePage;
	}
	public List<MenuOption> getMenuOptionList() {
		return menuOptionList;
	}
	public void addMenuOptionList(MenuOption menuOption) {
		menuOptionList.add(menuOption);
	}
}
