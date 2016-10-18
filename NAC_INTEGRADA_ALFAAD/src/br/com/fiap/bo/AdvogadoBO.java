package br.com.fiap.bo;

import java.sql.Connection;

import br.com.fiap.beans.Advogado;
import br.com.fiap.dao.AdvogadoDAO;

public class AdvogadoBO extends PessoaBO{
	
	public static String gravar(Advogado a, Connection conexao ) throws Exception{
	
		new AdvogadoDAO().gravar(a, conexao);
		return "Gravado com sucesso no BO";
	}

}