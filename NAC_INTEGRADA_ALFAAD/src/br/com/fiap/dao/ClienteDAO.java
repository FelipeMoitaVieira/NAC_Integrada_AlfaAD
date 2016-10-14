package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.beans.Cliente;

public class ClienteDAO extends PessoaDAO{
	
	public void gravar (Cliente c, Connection conexao ) throws Exception{
		 
    	PreparedStatement strt = conexao.prepareStatement("insert into T_AAD_PESSOA "
				+ "(CD_PESSOA, NM_NOME) "
				+ "values (SQ_AM_PESSOA.nextval,?)");
    	
    	strt.setString(1, c.getNome());
    	strt.execute();
    	strt.close();
    	
        PreparedStatement estrutura = conexao.prepareStatement("insert into T_AAD_CLIENTE "
        		+ "(NR_CNPJ, NR_INSC_ESTADUAL, DS_RAZAO_SOCIAL, DS_EMAIL, DS_SENHA,CD_CLIENTE) "
        		+ "values (?,?,?,?,?,SQ_AM_PESSOA.currval)");

        estrutura.setString(1, c.getCnpj());
        estrutura.setString(2, c.getInscricaoEstadual());
        estrutura.setString(3,c.getRazaoSocial());
        estrutura.setString(4, c.getEmail());
        estrutura.setString(5, c.getSenha());
        estrutura.execute();
        estrutura.close();
 
       
 
    }

	
}
