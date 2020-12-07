package br.com.portfolio.java.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portfolio.java.web.Principal;
import br.com.portfolio.java.web.dto.Menu;
import br.com.portfolio.java.web.dto.MenuOption;

public class PageService {

	public static List<MenuOption> menuOptList;

	public static List<MenuOption> obtemMenuOpcoes(String path, String username) {
		menuOptList = new ArrayList<MenuOption>();
		MenuOption menuOption;

		menuOption = new MenuOption();
		menuOption.setTitle("Usuários");
		menuOption.setUrl("#usuarios");
		menuOption.setIcon("ui-icon ui-icon-person");
		if(username.equals("admin")) menuOptList.add(menuOption);


		menuOption = new MenuOption();
		menuOption.setTitle("Listas");
		menuOption.setUrl("#listas");
		menuOption.setIcon("ui-icon ui-icon-note");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Funcionalidades");
		menuOption.setUrl("#funcionalidades");
		menuOption.setIcon("ui-icon ui-icon-wrench");
		if(username.equals("admin")) menuOptList.add(menuOption);


		menuOption = new MenuOption();
		menuOption.setTitle("Documentos");
		menuOption.setUrl("#documentos");
		menuOption.setIcon("ui-icon ui-icon-document");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Dúvidas");
		menuOption.setUrl("#duvidas");
		menuOption.setIcon("ui-icon ui-icon-help");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Eventos");
		menuOption.setUrl("#eventos");
		menuOption.setIcon("ui-icon ui-icon-calendar");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Perfil");
		menuOption.setUrl("#perfis");
		menuOption.setIcon("ui-icon ui-icon-contact");
		if(username.equals("admin")) menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Permissões");
		menuOption.setUrl("#permissoes");
		menuOption.setIcon("ui-icon ui-icon-locked");
		if(username.equals("admin")) menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Políticas");
		menuOption.setUrl("#politicas");
		menuOption.setIcon("ui-icon ui-icon-suitcase");
		if(username.equals("admin")) menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Repositórios");
		menuOption.setUrl("#repositorios");
		menuOption.setIcon("ui-icon ui-icon-folder-open");
		if(username.equals("admin")) menuOptList.add(menuOption);

		return menuOptList;
	}

	public static List<Menu> loadMenuList(String username) {

		List<Menu> menuList = new ArrayList<Menu>();
		String[] menuTitleList ;

		if(username.equals("admin")) {
			String[] menuTitle = {
					"Cadastrar",
					"Consultar",
					"Configurar"
			};

			menuTitleList = menuTitle;
		}else {
			String[] menuTitle = {
					"Consultar"
			};
			menuTitleList = menuTitle;
		}
		Menu menu;

		for (String menuData : menuTitleList) {
			menu = new Menu();
			if(menuData.equals("Configurar")) menu.setTitulo("Configurações");
			else menu.setTitulo(menuData);
			menu.setUrl("?acao=" + menuData);
			if(Principal.getAcaoRealizada().equals(menuData)) menu.setStatus("active");
			menuList.add(menu);
		}

		return menuList;

	}
}
