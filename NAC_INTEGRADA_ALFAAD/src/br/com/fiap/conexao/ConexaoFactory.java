package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {

	public Connection getConnection () throws Exception{
		//return DriverManager.getConnection("jdbc:oracle:thin:/:@192.168.60.15:1521:ORCL");
		//return DriverManager.getConnection("jdbc:oracle:thin:/:@localhost:1521:XE","Felps","fe1416");
		return DriverManager.getConnection("jdbc:oracle:thin:/:@oracle.fiap.com.br:1521:ORCL","OPS$RM76193","140487");
	}


}
