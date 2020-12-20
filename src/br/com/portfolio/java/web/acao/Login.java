package br.com.portfolio.java.web.acao;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.dto.Usuario;
import br.com.portfolio.java.web.service.UserService;
import br.com.portfolio.java.web.util.Acao;
import br.com.portfolio.java.web.util.PortfolioClientAPI;

public class Login implements Acao {

	@Override
	public boolean executar(HttpSession sessao) {
		
		System.out.println("[ Login ]");
		String usr = (String) sessao.getAttribute("usr");
		String password = (String) sessao.getAttribute("password");
		String targetPage = "";
		String mensagem = "";
		
		if(usr == null && password == null) {
			mensagem = "<p style='color: teal;'><b>Bem vindo(a)! Realize o login para acessar o sistema. </b></p>";
			
			sessao.setAttribute("targetPage", "login.jsp");
			sessao.setAttribute("mensagem", mensagem);
			
			return true;
		} else if(UserService.validaLogin(new Usuario(usr,password))) {
			
			sessao.setAttribute("usr", usr);
			
			mensagem  = "Bem vindo(a) "+ usr +"!";
			sessao.setAttribute("mensagem", mensagem);
			
			List<String> listaSessoes = UserService.getSessoesLogadas();
			boolean newSession = true;
			for (String sessaoLogada : listaSessoes) {
				if(sessaoLogada == sessao.getId()) {
					newSession = false;
					break;
				}
			}
			if(!newSession) UserService.adicionaSessao(sessao);
			
			PortfolioClientAPI.addAutenticador(sessao.getId());
			
			mensagem = "Bem vindo(a) \n"+ usr.trim() +"!";
			
			sessao.setAttribute("targetPage", "Cadastrar");
			sessao.setAttribute("mensagem", mensagem);

			return false;
		} else {
			targetPage = "login.jsp";
			mensagem = "<p style='color: red;'><b>Usuário ou senha incorreta! </b></p>";
			
			sessao.setAttribute("targetPage", targetPage);
			sessao.setAttribute("mensagem", mensagem);
			
			return true;
		}
	}
}
