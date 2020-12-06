package br.com.portfolio.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.dto.Menu;
import br.com.portfolio.java.web.dto.MenuOption;
import br.com.portfolio.java.web.dto.Usuario;
import br.com.portfolio.java.web.util.Acao;

@WebServlet("/principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher;
	private static List<HttpSession> sessoesLogadas;
	private static HttpSession currentSession;
	private static String username;
	private static String acaoRealizada;
	List<MenuOption> menuOptList;
	List<String> functionList;
	private static List<Usuario> listaUsuario;
	Map<String,String> listaPathPages = new HashMap<String, String>();

	public Principal() {
		super();
		System.out.println("Servlet Principal inicada...");
		listaUsuario = new ArrayList<Usuario>();
		sessoesLogadas = new ArrayList<HttpSession>();
		carregaBancoDeDados();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathClass = "br.com.portfolio.java.web.acao.";
		acaoRealizada = request.getParameter("acao");
		setCurrentSession(request.getSession());
		
		if(!Principal.verificaSessao(getCurrentSession())) {
			if(acaoRealizada == null) setAcaoRealizada("Login");
		} else {
			setAcaoRealizada(acaoRealizada);
		}

		try {
			String acaoClasse = pathClass+getAcaoRealizada();
			
			Acao acao = (Acao) Class.forName(acaoClasse).newInstance();
			if(acao.executar(request, response)) {
				String pagePath = "WEB-INF/pages/";
				String targetPage = pagePath  + (String) request.getAttribute("targetPage");
				requestDispatcher = request.getRequestDispatcher(targetPage);
				System.out.println("Sucesso! [Acao: " +targetPage+"]");
			} else{
				String targetPage = "principal?acao=" + (String) request.getAttribute("targetPage");
				requestDispatcher = request.getRequestDispatcher(targetPage);
				System.out.println("Sucesso! [Acao: " +targetPage+"]");
			};

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		if(currentSession != null) {
			
			String path = listaPathPages.get(acaoRealizada);
			
			request.setAttribute("menuList", loadMenuList(request, response));
			request.setAttribute("optionList", obtemMenuOpcoes(path));
			request.setAttribute("functionList", functionList);
			
			if(!(acaoRealizada.equals("Login") || acaoRealizada.equals("Sair"))) {
				String mensagem  = "Bem vindo(a) "+ currentSession.getAttribute("username").toString() +"!";
				request.setAttribute("mensagem", mensagem);
			}
		}

		requestDispatcher.forward(request, response);
	}

	private List<MenuOption> obtemMenuOpcoes(String path) {
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
	private List<Menu> loadMenuList(HttpServletRequest request, HttpServletResponse response) {

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
			if(acaoRealizada.equals(menuData)) menu.setStatus("active");
			menuList.add(menu);	
		}

		return menuList;

	}
	public static boolean verificaSessao(HttpSession sessao) {
		boolean isLogged = sessoesLogadas.contains(sessao);
		System.out.println("Sessão existe no banco de dados? "+ isLogged);
		return isLogged;
	}
	public static void adicionaSessao(HttpSession sessao) {
		sessoesLogadas.add(sessao);
	}
	public static void removeSessao(HttpSession sessao) {
		sessoesLogadas.remove(sessao);
	}
	public static HttpSession getCurrentSession() {
		return currentSession;
	}
	public static void setCurrentSession(HttpSession currentSession) {
		Principal.currentSession = currentSession;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Principal.username = username;
	}
	public String getAcaoRealizada() {
		return acaoRealizada;
	}
	public static void setAcaoRealizada(String acaoRealizada) {
		Principal.acaoRealizada = acaoRealizada;
	}
	public static List<Usuario> getListaUsuario() {
		return listaUsuario;
	}
	public static void setListaUsuario(List<Usuario> listaUsuario) {
		Principal.listaUsuario = listaUsuario;
	}
	private void carregaBancoDeDados() {
		
		String[] usernames = {
				"admin",
				"user"
		};
		
		Usuario usuario;
		for (String nome : usernames) {
			usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setPassword("1234");
			listaUsuario.add(usuario);
			System.out.println("Usuários carregados...");
		}
		
		listaPathPages.put("Cadastrar", "cadastros/cadastro");
		listaPathPages.put("Configurar", "configuracoes/configura");
		listaPathPages.put("Consultar", "consultas/consulta");
	}
	public static boolean validaLogin(Usuario usuario) {
		boolean logonRealizado = listaUsuario.contains(usuario);
		return logonRealizado;
	}
}
