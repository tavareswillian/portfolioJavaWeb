package br.com.portfolio.java.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.dto.Usuario;

public class UserService {
	
	private static List<Usuario> listaUsuario;
	private static List<HttpSession> sessoesLogadas = new ArrayList<HttpSession>();
	
	public static List<Usuario> carregaUsuarios(){
		
		listaUsuario = new ArrayList<Usuario>();
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
			System.out.println("Usuários carregado: " + usuario.getNome());
		}
		return listaUsuario;
	}

	public static boolean validaLogin(Usuario usuario) {
		boolean logonRealizado = listaUsuario.contains(usuario);
		return logonRealizado;
	}
	
	public static List<Usuario> getListaUsuario() {
		return listaUsuario;
	}
	public static void setListaUsuario(List<Usuario> listaUsuario) {
		UserService.listaUsuario = listaUsuario;
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
}
