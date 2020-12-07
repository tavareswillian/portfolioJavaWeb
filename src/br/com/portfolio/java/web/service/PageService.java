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
	private static List<String> functionList;
	public static Map<String,String> listaPathPages;

	public static Map<String,String> carregaDadosPaginas() {
		listaPathPages = new HashMap<String, String>();
		listaPathPages.put("Cadastrar", "cadastros/cadastro");
		listaPathPages.put("Configurar", "configuracoes/configura");
		listaPathPages.put("Consultar", "consultas/consulta");
		return listaPathPages;
	}
	
	public static List<MenuOption> obtemMenuOpcoes(String path) {
		menuOptList = new ArrayList<MenuOption>();
		MenuOption menuOption;

		functionList = new ArrayList<String>();

		menuOption = new MenuOption();
		menuOption.setTitle("Usuários");
		menuOption.setUrl("#usuarios");
		menuOption.setIcon("ui-icon ui-icon-person");
		functionList.add(path+"_usuario.jsp");
		menuOptList.add(menuOption);


		menuOption = new MenuOption();
		menuOption.setTitle("Listas");
		menuOption.setUrl("#listas");
		menuOption.setIcon("ui-icon ui-icon-note");
		functionList.add(path+"_lista.jsp");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Funcionalidades");
		menuOption.setUrl("#funcionalidades");
		menuOption.setIcon("ui-icon ui-icon-wrench");
		functionList.add(path+"_funcionalidade.jsp");
		menuOptList.add(menuOption);


		menuOption = new MenuOption();
		menuOption.setTitle("Documentos");
		menuOption.setUrl("#documentos");
		menuOption.setIcon("ui-icon ui-icon-document");
		functionList.add(path+"_documento.jsp");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Dúvidas");
		menuOption.setUrl("#duvidas");
		menuOption.setIcon("ui-icon ui-icon-help");
		functionList.add(path+"_duvida.jsp");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Eventos");
		menuOption.setUrl("#eventos");
		menuOption.setIcon("ui-icon ui-icon-calendar");
		functionList.add(path+"_evento.jsp");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Perfil");
		menuOption.setUrl("#perfis");
		menuOption.setIcon("ui-icon ui-icon-contact");
		functionList.add(path+"_perfil.jsp");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Permissões");
		menuOption.setUrl("#permissoes");
		menuOption.setIcon("ui-icon ui-icon-locked");
		functionList.add(path+"_permissao.jsp");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Políticas");
		menuOption.setUrl("#politicas");
		menuOption.setIcon("ui-icon ui-icon-suitcase");
		functionList.add(path+"_politica.jsp");
		menuOptList.add(menuOption);

		menuOption = new MenuOption();
		menuOption.setTitle("Repositórios");
		menuOption.setUrl("#repositorios");
		menuOption.setIcon("ui-icon ui-icon-folder-open");
		functionList.add(path+"_repositorio.jsp");
		menuOptList.add(menuOption);

		return menuOptList;
	}
	
	public static List<String> getFunctionList() {
		return functionList;
	}
	
	public static List<Menu> loadMenuList() {

		List<Menu> menuList = new ArrayList<Menu>();

		String[] menuTitleList = {
				"Cadastrar",
				"Consultar",
				"Configurar"
		};
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
