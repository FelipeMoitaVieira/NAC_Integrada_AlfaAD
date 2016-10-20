package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.TipoDespesa;

public class TipoDespesaDAO {

	public List <TipoDespesa> getListaTipo (Connection conexao) throws Exception{
		List<TipoDespesa> lstTipoDespesa = new ArrayList<TipoDespesa>();
		PreparedStatement stmt = conexao.prepareStatement("SELECT TD.CD_TIPO_DESPESA, TD.DS_TIPO_DESPESA FROM T_AAD_TIPO_DESPESA TD");
		ResultSet resultadoDados = stmt.executeQuery();
		
		
		while (resultadoDados.next()) {
			TipoDespesa tipoDespesa = new TipoDespesa();
			
			tipoDespesa.setCodigoTipoDespesa(resultadoDados.getInt("CD_TIPO_DESPESA"));
			tipoDespesa.setDescricaoTipoDespesa(resultadoDados.getString("DS_TIPO_DESPESA"));
			lstTipoDespesa.add(tipoDespesa);
				
		}
		
		
		resultadoDados.close();
		stmt.close();
		return lstTipoDespesa;
		
		
	}

	
	
	
}
