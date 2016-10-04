package br.com.fiap.beans;

public class Forum extends Pessoa{

	private String descricao;


	public Forum(int codigo, String nome, Endereco[] endereco, Telefone[] telefone, String descricao) {
		super(codigo, nome, endereco, telefone);
		this.descricao = descricao;
	}
	

	public Forum() {}



	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
