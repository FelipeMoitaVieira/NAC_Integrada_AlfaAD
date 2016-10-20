package br.com.fiap.conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public final class ConexaoFactory {

	private static ConexaoFactory conexao = null;
	
	public static ConexaoFactory controlarInstancia(){
		if(conexao == null){
			conexao = new ConexaoFactory();
		}
		return conexao;
	}
	
	public Connection getConnection (String usuario, String senha) throws Exception{
		FileReader arquivo = new FileReader("D:/NACAO/NAC_INTEGRADA_ALFAAD/conexao/banco.txt");
		BufferedReader dados = new BufferedReader(arquivo);
		
		String url = dados.readLine();
				
		if(url.indexOf("oracle")>0){
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}else if (url.indexOf("mysql")>0){
			Class.forName("com.mysql.jdbc.Driver");
		}
		dados.close();
		
		
		
		//CONEXÃO LOCALHOST FELPS
		return DriverManager.getConnection(url,"Felps","fe1416");
		
	}
}
