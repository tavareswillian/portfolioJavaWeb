package br.com.portfolio.java.web.acao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.portfolio.java.web.util.Acao;

public class Cadastrar implements Acao {

	@Override
	public boolean executar(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("[ Cadastrar ]");
		request.setAttribute("targetPage", "index.jsp");
		
		List<String> listaInclude = new ArrayList<String>();
		listaInclude.add("cadastros/cadastro_usuario.jsp");
		listaInclude.add("cadastros/cadastro_lista.jsp");
		listaInclude.add("cadastros/cadastro_funcionalidade.jsp");
		listaInclude.add("cadastros/cadastro_documento.jsp");
		listaInclude.add("cadastros/cadastro_duvida.jsp");
		listaInclude.add("cadastros/cadastro_evento.jsp");
		listaInclude.add("cadastros/cadastro_perfil.jsp");
		listaInclude.add("cadastros/cadastro_permissao.jsp");
		listaInclude.add("cadastros/cadastro_politica.jsp");
		listaInclude.add("cadastros/cadastro_repositorio.jsp");

//		request.setAttribute("menuBody", "cadastro.jsp");
		request.setAttribute("menuBody", listaInclude);
		return true;
	}


}
