package br.com.portfolio.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.service.PageService;
import br.com.portfolio.java.web.service.UserService;
import br.com.portfolio.java.web.util.Acao;

@WebServlet("/principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher;
	private static HttpSession currentSession;
	private static String username;
	private static String acaoRealizada;

	public Principal() {
		super();
		System.out.println("Servlet Principal inicada...");
		UserService.carregaUsuarios();
//		PageService.carregaDadosPaginas();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathClass = "br.com.portfolio.java.web.acao.";
		acaoRealizada = request.getParameter("acao");	
		setCurrentSession(request.getSession());
		if(acaoRealizada == null) setAcaoRealizada("Login");
		
		if(UserService.verificaSessao(getCurrentSession())) {
			if(acaoRealizada == null) setAcaoRealizada("Iniciar");
			setAcaoRealizada(acaoRealizada);
			if(currentSession != null) {
				
//				String path = PageService.listaPathPages.get(acaoRealizada);
				
				request.setAttribute("menuList", PageService.loadMenuList(username));
//				request.setAttribute("optionList", PageService.obtemMenuOpcoes(path));
//				request.setAttribute("functionList", PageService.getFunctionList());
				
				if(!(acaoRealizada.equals("Login") || acaoRealizada.equals("Sair"))) {
					String mensagem  = "Bem vindo(a) "+ currentSession.getAttribute("username").toString() +"!";
					request.setAttribute("mensagem", mensagem);
				}
			}
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

		requestDispatcher.forward(request, response);
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
	public static String getAcaoRealizada() {
		return acaoRealizada;
	}
	public static void setAcaoRealizada(String acaoRealizada) {
		Principal.acaoRealizada = acaoRealizada;
	}
}
