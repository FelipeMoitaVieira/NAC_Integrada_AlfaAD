package br.com.fiap.excecao;

public class Excecao extends Exception{

	
	private static final long serialVersionUID = 1L;

	public Excecao (String mensagem, Exception e){
		super(mensagem, e);
		if (e.getClass().toString().equals("class java.lang.NumberFormatException")){
			System.out.println("Número Inválido");
		}else if (e.getClass().toString().equals("class java.lang.ArithmeticException")){
			System.out.println("Divisão por 0");
		}
		this.print();
		e.printStackTrace();
	}
	public Excecao (String mensagem){
		super(mensagem);
	}
	
	public void print(){
		System.out.println("----------------- Tratando Erro -------------------");
		System.out.println(getMessage());
		System.out.println("PrintStackTrace: ");
	}
	
	public Excecao(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}

}
