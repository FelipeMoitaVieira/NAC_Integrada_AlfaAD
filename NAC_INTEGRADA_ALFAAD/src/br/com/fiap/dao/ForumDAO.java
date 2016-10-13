package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.beans.Forum;

public class ForumDAO extends PessoaDAO{

	public void gravar (Forum f, Connection conexao ) throws Exception{
		 
    	PreparedStatement strt = conexao.prepareStatement("insert into T_AAD_PESSOA "
				+ "(CD_PESSOA, NM_NOME) "
				+ "values (SQ_AM_PESSOA.nextval,?)");
    	
    	strt.setString(1, f.getNome());
    	
    	strt.execute();
    	
        PreparedStatement estrutura = conexao.prepareStatement("insert into T_AAD_FORUM "
        		+ "(DS_FORUM,CD_FORUM) "
        		+ "values (?,SQ_AM_PESSOA.currval)");
 
        
        	
            estrutura.setString(1, f.getDescricao());
            
            estrutura.execute();
            estrutura.close();
 
       System.out.println("Gravado");
 
    }
	
}
