package br.com.portfolio.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.service.UserService;
import br.com.portfolio.java.web.util.Acao;

@WebServlet("/principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher;
	private static HttpSession currentSession;
	private static String acaoRealizada;
	private static List<String> errorList;
	private static boolean manterSessao = false;

	public Principal() {
		super();
		System.out.println("Servlet Principal inicada...");
		UserService.carregaUsuarios();
		errorList = new ArrayList<String>();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 		String pathClass = "br.com.portfolio.java.web.acao.";
 		
 		if(request.getSession() == null) System.out.println("Sessão nula!");
 		
		System.out.println("Sessões: " + UserService.getSessoesLogadas());
		
		String usr = (String) request.getParameter("usr");
		String password = (String) request.getParameter("password");
		
		if(usr != null) {
			currentSession.setAttribute("usr", usr);
			currentSession.setAttribute("password", password);
		}else {
			acaoRealizada = "Login";
		}
		
		setCurrentSession(request.getSession());
		acaoRealizada = (String) request.getParameter("acao");
		currentSession.setAttribute("acao", acaoRealizada);
		manterSessao = UserService.verificaSessao(currentSession);	
		
		if(acaoRealizada == null || manterSessao) {
			acaoRealizada = "Login";
		}
		
		try {
			String acaoClasse = pathClass+getAcaoRealizada();

			Acao acao = (Acao) Class.forName(acaoClasse).newInstance();
			String targetPage = "";
			if(acao.executar(currentSession)) targetPage = "WEB-INF/pages/";
			else targetPage = "principal?acao=";

			if(acaoRealizada.equals("Sair")) {
				String mensagem = "<p style='color: green;'><b>Sessão encerrada!</b></p>";
				request.setAttribute("mensagem", mensagem);
				targetPage += "login.jsp";
			} else {
				targetPage += (String) currentSession.getAttribute("targetPage");
			}
			
			requestDispatcher = request.getRequestDispatcher(targetPage);
			System.out.println("Sucesso! [Acao: " +targetPage+"]");
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			currentSession.setAttribute("acao","Error");
		}

		requestDispatcher.forward(request, response);
	}

	public static HttpSession getCurrentSession() {
		return currentSession;
	}
	public static void setCurrentSession(HttpSession currentSession) {
		Principal.currentSession = currentSession;
	}
	public static String getAcaoRealizada() {
		return acaoRealizada;
	}
	public static void setAcaoRealizada(String acaoRealizada) {
		Principal.acaoRealizada = acaoRealizada;
		currentSession.setAttribute("acao", acaoRealizada);
	}
}
