package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.beans.LancamentoDespesa;

public class LancamentoDespesaDAO {

	public void gravar(LancamentoDespesa ld, Connection conexao) throws Exception{
		
		PreparedStatement estrutura = conexao.prepareStatement("insert into T_AAD_LANCA_DESPESA "
				+ "(CD_LANCAMENTO, CD_TIPO_DESPESA,NR_PROCESSO,DT_DESPESA,VL_DESPESA,DS_OBSERVACAO) "
				+ "values (SQ_AM_LANCA_DESPESA.nextval,?,?,?,?,?)");
		
		
		estrutura.setInt(1, ld.getCodigo());
		estrutura.setLong(2, ld.getProcesso().getNumeroProcesso());
		estrutura.setString(3, ld.getDataDespesa());
		estrutura.setDouble(4, ld.getValorDespesa());
		estrutura.setString(5, ld.getObservacao());
		estrutura.execute();
		
		estrutura.close();
		
	}
	
	
}
