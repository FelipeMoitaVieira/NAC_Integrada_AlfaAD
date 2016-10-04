package br.com.fiap.excecao;

public class Excecao extends Exception{

	
	private static final long serialVersionUID = 1L;

	public Excecao(Exception e){
		System.out.println(e);
	}

}
