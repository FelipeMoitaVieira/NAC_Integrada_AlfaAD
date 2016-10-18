package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.beans.LancamentoDespesa;
import br.com.fiap.beans.Processo;

public class ProcessoDAO {

	
	 public void gravar (Processo p, Connection conexao ) throws Exception{
		 
	    	
	    	
	    	//Insere dados na Tabela Processo
	        PreparedStatement estrutura = conexao.prepareStatement("insert into T_AAD_PROCESSO "
	        		+ "(NR_PROCESSO, CD_CLIENTE, CD_ADVOGADO, CD_FORUM, CD_CAUSA, DS_PROCESSO, "
	        		+ "DT_ABERTURA, DT_FECHAMENTO, DT_DIA_VENCIMENTO, NR_RESULTADO, DS_OBSERVACAO,NR_SITUACAO) "
	        		+ "values (SQ_AM_PROCESSO.nextval,?,?,?,?,?,?,?,?,?,?,?)");
	       
	        estrutura.setLong(1, p.getCliente().getCodigo());
	        estrutura.setLong(2, p.getAdvogado().getCodigo());
	        estrutura.setLong(3, p.getForum().getCodigo());
	        estrutura.setInt(4, p.getAdvogado().getEspecialidade().getCodigoTipoCausa());
	        estrutura.setString(5, p.getDescricaoProcesso());
	        estrutura.setString(6, p.getDataAbertura());
	        estrutura.setString(7, p.getDataFechamento());
	        estrutura.setString(8, p.getDataDiaVencimento());
	        estrutura.setByte(9, p.getResultado());
	        estrutura.setString(10, p.getObservacao());
	        estrutura.setByte(11, p.getSituacao());
	        estrutura.execute();
	        estrutura.close();
	       
	        System.out.println("Gravado!");
	       
	 
	    }
	 
	 
				
		public void atualizar (Processo p, Connection conexao) throws Exception{
			PreparedStatement stmt = conexao.prepareStatement("UPDATE T_AAD_PROCESSO SET CD_CLIENTE = ?, CD_ADVOGADO = ?, "
					+ "CD_FORUM = ?, CD_CAUSA = ?, DS_PROCESSO = ?, DT_ABERTURA = ?, DT_FECHAMENTO = ?, "
	        		+ "DT_DIA_VENCIMENTO = ?, NR_RESULTADO = ?, DS_OBSERVACAO = ?, NR_SITUACAO = ? "
	        		+ "WHERE NR_PROCESSO = ?");
			
			stmt.setLong(1, p.getCliente().getCodigo());
			stmt.setLong(2, p.getAdvogado().getCodigo());
			stmt.setLong(3, p.getForum().getCodigo());
			stmt.setInt(4, p.getAdvogado().getEspecialidade().getCodigoTipoCausa());
			stmt.setString(5, p.getDescricaoProcesso());
			stmt.setString(6, p.getDataAbertura());
			stmt.setString(7, p.getDataFechamento());
			stmt.setString(8, p.getDataDiaVencimento());
			stmt.setByte(9, p.getResultado());
			stmt.setString(10, p.getObservacao());
			stmt.setByte(11, p.getSituacao());
			stmt.setLong(12, p.getNumeroProcesso());
			stmt.execute();
			stmt.close();
			
			
			 System.out.println("Atualizado!");
			
			
		}
	
}
