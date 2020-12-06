package br.com.portfolio.java.web.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.Principal;
import br.com.portfolio.java.web.dto.Usuario;
import br.com.portfolio.java.web.util.Acao;

public class Login implements Acao {

	@Override
	public boolean executar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[ Login ]");
		String userName = request.getParameter("uname");
		HttpSession sessao = request.getSession();
		String password = request.getParameter("pwd");
		String targetPage = "";
		String mensagem = "";
		
		if(userName == null 
				&& password == null) {
			targetPage = "login.jsp";
			mensagem = "<p style='color: teal;'><b>Bem vindo(a)! Realize o login para acessar o sistema. </b></p>";
			
			request.setAttribute("targetPage", targetPage);
			request.setAttribute("mensagem", mensagem);
			
			return true;
		} else if(Principal.validaLogin(new Usuario(userName,password))) {
			Principal.adicionaSessao(sessao);
			Principal.setUsername(userName);
			sessao.setAttribute("username", userName);
			targetPage = "Cadastrar";
			mensagem = "<p style='color: green;'><b>Bem vindo(a) \n"+ Principal.getUsername() +"!</b></p>";
			
			request.setAttribute("targetPage", targetPage);
			request.setAttribute("mensagem", mensagem);

			return false;
		} else {
			targetPage = "login.jsp";
			mensagem = "<p style='color: red;'><b>Usuário ou senha incorreta! </b></p>";
			
			request.setAttribute("targetPage", targetPage);
			request.setAttribute("mensagem", mensagem);
			
			return true;
		}
	}
}
