package br.com.fiap.beans;

public class Cliente extends Pessoa {

	private String razaoSocial;
	private int cnpj;
	private String inscricaoEstadual;
	private String email;
	private String senha;
	
	
	public Cliente() {}
	
	public Cliente(int codigo, String nome, Endereco[] endereco, Telefone[] telefone, String razaoSocial, int cnpj,
			String inscricaoEstadual, String email, String senha) {
		super(codigo, nome, endereco, telefone);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.email = email;
		this.senha = senha;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
