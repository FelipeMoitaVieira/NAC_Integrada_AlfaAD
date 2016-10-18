package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Advogado;
import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Forum;
import br.com.fiap.beans.Processo;
import br.com.fiap.beans.TipoCausa;

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
		
		
		public List<Processo> getProcessos(Connection conexao) throws Exception{
			List<Processo> lstProcesso = new ArrayList<Processo>();
			
			PreparedStatement stmt = conexao.prepareStatement("SELECT P.NR_PROCESSO, C.CD_CLIENTE,PE.NM_NOME CLIENTE, A.CD_ADVOGADO,PESS.NM_NOME ADVOGADO, F.CD_FORUM,PES.NM_NOME FORUM, E.CD_CAUSA, "
					+" TC.DS_CAUSA , P.DS_PROCESSO, P.DT_ABERTURA, P.DT_FECHAMENTO, P.DT_DIA_VENCIMENTO, P.NR_RESULTADO, P.DS_OBSERVACAO, P.NR_SITUACAO "
	        		+" FROM T_AAD_PROCESSO P INNER JOIN T_AAD_CLIENTE C ON (P.CD_CLIENTE = C.CD_CLIENTE) "
	        		+" INNER JOIN T_AAD_ADVOGADO A ON (P.CD_ADVOGADO = A.CD_ADVOGADO) INNER JOIN T_AAD_FORUM F ON (P.CD_FORUM = F.CD_FORUM) " 
	        		+" INNER JOIN T_AAD_ESPECIALIDADE E ON (P.CD_CAUSA = E.CD_CAUSA) INNER JOIN T_AAD_PESSOA PE ON (C.CD_CLIENTE = PE.CD_PESSOA) "
	        		+" INNER JOIN T_AAD_TIPO_CAUSA TC ON (E.CD_CAUSA = TC.CD_CAUSA) "
	        		+" INNER JOIN T_AAD_PESSOA PES ON (F.CD_FORUM = PES.CD_PESSOA) "
	        		+" INNER JOIN T_AAD_PESSOA PESS ON (A.CD_ADVOGADO = PESS.CD_PESSOA)"
	        		+ "ORDER BY P.NR_PROCESSO");
			ResultSet resultadoDados = stmt.executeQuery();
			
			
			
			while(resultadoDados.next()){
				
				TipoCausa tipoCausa = new TipoCausa();
				Advogado advogado = new Advogado();
				Cliente cliente = new Cliente();
				Forum forum = new Forum();
				Processo processo = new Processo();
				
				cliente.setCodigo(resultadoDados.getInt("CD_CLIENTE"));
				cliente.setNome(resultadoDados.getString("CLIENTE"));
				advogado.setNome(resultadoDados.getString("ADVOGADO"));
				advogado.setCodigo(resultadoDados.getLong("CD_ADVOGADO"));
				forum.setCodigo(resultadoDados.getInt("CD_FORUM"));
				forum.setNome(resultadoDados.getString("FORUM"));
				
				
				tipoCausa.setDescricaoTipoCausa(resultadoDados.getString("DS_CAUSA"));
				tipoCausa.setCodigoTipoCausa(resultadoDados.getInt("CD_CAUSA"));
				advogado.setEspecialidade(tipoCausa);
				processo.setNumeroProcesso(resultadoDados.getInt("NR_PROCESSO"));
				processo.setDescricaoProcesso(resultadoDados.getString("DS_PROCESSO"));
				processo.setAdvogado(advogado);
				processo.setCliente(cliente);
				processo.setDataAbertura(resultadoDados.getString("DT_ABERTURA"));
				processo.setDataDiaVencimento(resultadoDados.getString("DT_DIA_VENCIMENTO"));
				processo.setDataFechamento(resultadoDados.getString("DT_FECHAMENTO"));
				processo.setForum(forum);
				processo.setObservacao(resultadoDados.getString("DS_OBSERVACAO"));
				processo.setResultado(resultadoDados.getByte("NR_RESULTADO"));
				processo.setSituacao(resultadoDados.getByte("NR_SITUACAO"));
				
				
				lstProcesso.add(processo);
				
				
			}
			resultadoDados.close();
			stmt.close();
					
			return lstProcesso;
		}
		
		
		
		public Processo pesquisarProcessoNumero (int pProcesso,Connection conexao) throws Exception{
			
			
			PreparedStatement stmt = conexao.prepareStatement("SELECT P.NR_PROCESSO, C.CD_CLIENTE,PE.NM_NOME CLIENTE, A.CD_ADVOGADO,PESS.NM_NOME ADVOGADO, F.CD_FORUM,PES.NM_NOME FORUM, E.CD_CAUSA, "
					+" TC.DS_CAUSA , P.DS_PROCESSO, P.DT_ABERTURA, P.DT_FECHAMENTO, P.DT_DIA_VENCIMENTO, P.NR_RESULTADO, P.DS_OBSERVACAO, P.NR_SITUACAO "
	        		+" FROM T_AAD_PROCESSO P INNER JOIN T_AAD_CLIENTE C ON (P.CD_CLIENTE = C.CD_CLIENTE) "
	        		+" INNER JOIN T_AAD_ADVOGADO A ON (P.CD_ADVOGADO = A.CD_ADVOGADO) INNER JOIN T_AAD_FORUM F ON (P.CD_FORUM = F.CD_FORUM) " 
	        		+" INNER JOIN T_AAD_ESPECIALIDADE E ON (P.CD_CAUSA = E.CD_CAUSA) INNER JOIN T_AAD_PESSOA PE ON (C.CD_CLIENTE = PE.CD_PESSOA) "
	        		+" INNER JOIN T_AAD_TIPO_CAUSA TC ON (E.CD_CAUSA = TC.CD_CAUSA) "
	        		+" INNER JOIN T_AAD_PESSOA PES ON (F.CD_FORUM = PES.CD_PESSOA) "
	        		+" INNER JOIN T_AAD_PESSOA PESS ON (A.CD_ADVOGADO = PESS.CD_PESSOA) WHERE P.NR_PROCESSO = ?");
			
			stmt.setInt(1, pProcesso);
			ResultSet resultadoDados = stmt.executeQuery();
			
			TipoCausa tipoCausa = new TipoCausa();
			Advogado advogado = new Advogado();
			Cliente cliente = new Cliente();
			Forum forum = new Forum();
			Processo processo = new Processo();
			
			if(resultadoDados.next()){
				cliente.setCodigo(resultadoDados.getInt("CD_CLIENTE"));
				cliente.setNome(resultadoDados.getString("CLIENTE"));
				advogado.setNome(resultadoDados.getString("ADVOGADO"));
				advogado.setCodigo(resultadoDados.getLong("CD_ADVOGADO"));
				forum.setCodigo(resultadoDados.getInt("CD_FORUM"));
				forum.setNome(resultadoDados.getString("FORUM"));
				
				
				tipoCausa.setDescricaoTipoCausa(resultadoDados.getString("DS_CAUSA"));
				tipoCausa.setCodigoTipoCausa(resultadoDados.getInt("CD_CAUSA"));
				advogado.setEspecialidade(tipoCausa);
				processo.setNumeroProcesso(resultadoDados.getInt("NR_PROCESSO"));
				processo.setDescricaoProcesso(resultadoDados.getString("DS_PROCESSO"));
				processo.setAdvogado(advogado);
				processo.setCliente(cliente);
				processo.setDataAbertura(resultadoDados.getString("DT_ABERTURA"));
				processo.setDataDiaVencimento(resultadoDados.getString("DT_DIA_VENCIMENTO"));
				processo.setDataFechamento(resultadoDados.getString("DT_FECHAMENTO"));
				processo.setForum(forum);
				processo.setObservacao(resultadoDados.getString("DS_OBSERVACAO"));
				processo.setResultado(resultadoDados.getByte("NR_RESULTADO"));
				processo.setSituacao(resultadoDados.getByte("NR_SITUACAO"));
				
				
				
			}
			
			resultadoDados.close();
			stmt.close();
			return processo;
		}
		
		
public List<Processo> pesquisarProcessoNome (String pProcesso,Connection conexao) throws Exception{
		List<Processo> lstProcesso = new ArrayList<Processo>();
			
			PreparedStatement stmt = conexao.prepareStatement("SELECT DISTINCT P.NR_PROCESSO, C.CD_CLIENTE,PE.NM_NOME CLIENTE, A.CD_ADVOGADO,PESS.NM_NOME ADVOGADO, F.CD_FORUM,PES.NM_NOME FORUM, E.CD_CAUSA, "
					+" TC.DS_CAUSA , P.DS_PROCESSO, P.DT_ABERTURA, P.DT_FECHAMENTO, P.DT_DIA_VENCIMENTO, P.NR_RESULTADO, P.DS_OBSERVACAO, P.NR_SITUACAO "
	        		+" FROM T_AAD_PROCESSO P INNER JOIN T_AAD_CLIENTE C ON (P.CD_CLIENTE = C.CD_CLIENTE) "
	        		+" INNER JOIN T_AAD_ADVOGADO A ON (P.CD_ADVOGADO = A.CD_ADVOGADO) INNER JOIN T_AAD_FORUM F ON (P.CD_FORUM = F.CD_FORUM) " 
	        		+" INNER JOIN T_AAD_ESPECIALIDADE E ON (P.CD_CAUSA = E.CD_CAUSA) INNER JOIN T_AAD_PESSOA PE ON (C.CD_CLIENTE = PE.CD_PESSOA) "
	        		+" INNER JOIN T_AAD_TIPO_CAUSA TC ON (E.CD_CAUSA = TC.CD_CAUSA) "
	        		+" INNER JOIN T_AAD_PESSOA PES ON (F.CD_FORUM = PES.CD_PESSOA) "
	        		+" INNER JOIN T_AAD_PESSOA PESS ON (A.CD_ADVOGADO = PESS.CD_PESSOA) WHERE PE.NM_NOME = ?"
	        		+ "ORDER BY P.NR_PROCESSO");
			stmt.setString(1, pProcesso);
			ResultSet resultadoDados = stmt.executeQuery();
			
			
			
			while(resultadoDados.next()){
				
				TipoCausa tipoCausa = new TipoCausa();
				Advogado advogado = new Advogado();
				Cliente cliente = new Cliente();
				Forum forum = new Forum();
				Processo processo = new Processo();
				
				cliente.setCodigo(resultadoDados.getInt("CD_CLIENTE"));
				cliente.setNome(resultadoDados.getString("CLIENTE"));
				advogado.setNome(resultadoDados.getString("ADVOGADO"));
				advogado.setCodigo(resultadoDados.getLong("CD_ADVOGADO"));
				forum.setCodigo(resultadoDados.getInt("CD_FORUM"));
				forum.setNome(resultadoDados.getString("FORUM"));
				
				
				tipoCausa.setDescricaoTipoCausa(resultadoDados.getString("DS_CAUSA"));
				tipoCausa.setCodigoTipoCausa(resultadoDados.getInt("CD_CAUSA"));
				advogado.setEspecialidade(tipoCausa);
				processo.setNumeroProcesso(resultadoDados.getInt("NR_PROCESSO"));
				processo.setDescricaoProcesso(resultadoDados.getString("DS_PROCESSO"));
				processo.setAdvogado(advogado);
				processo.setCliente(cliente);
				processo.setDataAbertura(resultadoDados.getString("DT_ABERTURA"));
				processo.setDataDiaVencimento(resultadoDados.getString("DT_DIA_VENCIMENTO"));
				processo.setDataFechamento(resultadoDados.getString("DT_FECHAMENTO"));
				processo.setForum(forum);
				processo.setObservacao(resultadoDados.getString("DS_OBSERVACAO"));
				processo.setResultado(resultadoDados.getByte("NR_RESULTADO"));
				processo.setSituacao(resultadoDados.getByte("NR_SITUACAO"));
				
				lstProcesso.add(processo);
				
			}
			
			resultadoDados.close();
			stmt.close();
			return lstProcesso;
		}
	
}
