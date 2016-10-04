package br.com.fiap.beans;

public class Advogado extends Pessoa{

	private int numeroOAB;
	private int cpf;
	private String rg;
	private String email;
	private String senha;
	private TipoCausa especialidade;
	
	

	public Advogado() {}



	public Advogado(int codigo, String nome, Endereco[] endereco, Telefone[] telefone, int numeroOAB, int cpf,
			String rg, String email, String senha, TipoCausa especialidade) {
		super(codigo, nome, endereco, telefone);
		this.numeroOAB = numeroOAB;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.senha = senha;
		this.especialidade = especialidade;
	}



	public int getNumeroOAB() {
		return numeroOAB;
	}



	public void setNumeroOAB(int numeroOAB) {
		this.numeroOAB = numeroOAB;
	}



	public int getCpf() {
		return cpf;
	}



	public void setCpf(int cpf) {
		this.cpf = cpf;
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
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



	public TipoCausa getEspecialidade() {
		return especialidade;
	}



	public void setEspecialidade(TipoCausa especialidade) {
		this.especialidade = especialidade;
	}
	
	
	
}
