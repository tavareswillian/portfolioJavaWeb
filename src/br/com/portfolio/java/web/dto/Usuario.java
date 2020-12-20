package br.com.portfolio.java.web.dto;

public class Usuario {
	private String nome;
	private String password;
	private String sessao = "";
	
	public Usuario(String nome, String password) {
		super();
		this.nome = nome;
		this.password = password;
	}
	public Usuario() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSessao() {
		return sessao;
	}
	public void setSessao(String sessao) {
		this.sessao = sessao;
	}
	
	@Override
	public boolean equals(Object obj) {
		Usuario usuario = (Usuario) obj;
		String nomeAtual = this.getNome();
		String senhaAtual = this.getPassword();
		
		String nomeUsuario = usuario.getNome();
		String senhaUsuario = usuario.getPassword();

		boolean mesmoUsuario = (!(nomeAtual.equals("") 
									|| nomeUsuario.equals("") 
									|| senhaAtual.equals("") 
									|| senhaUsuario.equals(""))
								&& nomeAtual.equals(nomeUsuario) 
								&& senhaAtual.equals(senhaUsuario));
		
		return mesmoUsuario;
	}
}
