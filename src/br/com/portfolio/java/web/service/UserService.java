package br.com.portfolio.java.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.portfolio.java.web.dto.Usuario;

public class UserService {
	
	private static List<Usuario> listaUsuario;
	private static List<String> sessoesLogadas;
	
	public static List<Usuario> carregaUsuarios(){
		
		listaUsuario = new ArrayList<Usuario>();
		sessoesLogadas = new ArrayList<String>();
		
		String[] usr = {
				"admin",
				"user"
		};
		
		Usuario usuario;
		for (String nome : usr) {
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
		boolean isLogged = false;
		if(sessao != null && sessoesLogadas.contains(sessao.getId())) isLogged = true;
		System.out.println("Sessão existe no banco de dados? "+ isLogged);
		return isLogged;
	}
	public static void adicionaSessao(HttpSession sessao) {
		sessoesLogadas.add(sessao.getId());
	}
	public static void removeSessao(HttpSession sessao) {
		sessoesLogadas.remove(sessao.getId());
	}

	public static List<String> getSessoesLogadas() {
		return sessoesLogadas;
	}
}
