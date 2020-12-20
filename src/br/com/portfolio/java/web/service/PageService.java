package br.com.portfolio.java.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.dto.Menu;
import br.com.portfolio.java.web.dto.MenuOption;
import br.com.portfolio.java.web.model.Funcionalidade;
import br.com.portfolio.java.web.util.PortfolioClientAPI;

public class PageService {

	public static List<MenuOption> menuOptList;

	public static List<MenuOption> obtemMenuOpcoes(String path, String usr, List<String> listaFuncionalidade) {
		menuOptList = new ArrayList<MenuOption>();
		MenuOption menuOption;

		try {
			List<Funcionalidade> listaFuncionalidades = PortfolioClientAPI.obtemFuncionalidades();

			for (String menu : listaFuncionalidade) {
				boolean existe = false;
					for (Funcionalidade funcionalidade : listaFuncionalidades) {
					String nmFuncionalidade = funcionalidade.getNmFuncionalidade().toLowerCase();
					existe = (menu.toLowerCase().equals(nmFuncionalidade));
					if(existe) {
						System.out.println("Usuario possui a funcionalidade: " + menu);
						menuOption = new MenuOption();
						menuOption.setTitle(funcionalidade.getNmFuncionalidade());
						menuOption.setUrl(funcionalidade.getPageLink());
						menuOption.setIcon(funcionalidade.getIconType());

						menuOptList.add(menuOption);
						listaFuncionalidades.remove(funcionalidade);
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return menuOptList;

		//
		//		menuOption = new MenuOption();
		//		menuOption.setTitle("Repositórios");
		//		menuOption.setUrl("#repositorios");
		//		menuOption.setIcon("ui-icon ui-icon-folder-open");
		//		if(usr.equals("admin")) menuOptList.add(menuOption);

	}

	public static List<Menu> loadMenuList(HttpSession sessao) {

		List<Menu> menuList = new ArrayList<Menu>();
		String[] menuTitleList = null;
		String usr = (String) sessao.getAttribute("usr");

		if(usr == null) {
			
		} else if (usr.equals("admin")) {
			String[] menuTitle = {
					"Cadastrar",
					"Consultar",
					"Configurar"
			};

			menuTitleList = menuTitle;
		}else {
			String[] menuTitle = {
					"Consultar",
					"Configurar"
			};
			menuTitleList = menuTitle;
		}

		Menu menu;
		String acaoAtual = (String) sessao.getAttribute("acao");
		boolean noMenuActive = true;
		if(menuTitleList != null) {
			for (String menuData : menuTitleList) {
				menu = new Menu();
				menu.setTitulo(menuData);
				if(acaoAtual.equals(menuData)) {
					sessao.setAttribute("menuTitleList", menuData);
					menu.setStatus("active");
					noMenuActive = false;
				}
				menu.setUrl("?acao=" + menuData);
				menuList.add(menu);
			}
		}
		if(noMenuActive) menuList.get(0).setStatus("active");

		return menuList;

	}
}
