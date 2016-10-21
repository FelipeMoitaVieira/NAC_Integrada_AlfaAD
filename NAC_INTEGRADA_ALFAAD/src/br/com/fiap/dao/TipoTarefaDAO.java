package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.TipoTarefa;

public class TipoTarefaDAO {

	public List <TipoTarefa> getListaTipo (Connection conexao) throws Exception{
		List <TipoTarefa> lstTipoTarefa = new ArrayList<TipoTarefa>();
		PreparedStatement stmt = conexao.prepareStatement("SELECT TD.CD_TIPO_TAREFA, TD.DS_TIPO_TAREFA FROM T_AAD_TIPO_TAREFA TD ORDER BY TD.CD_TIPO_TAREFA");
		ResultSet resultadoDados = stmt.executeQuery();
		
		while (resultadoDados.next()){
			TipoTarefa tipoTarefa = new TipoTarefa();
			tipoTarefa.setCodigoTipoTarefa(resultadoDados.getInt("CD_TIPO_TAREFA"));
			tipoTarefa.setDescricaoTipoTarefa(resultadoDados.getString("DS_TIPO_TAREFA"));
			lstTipoTarefa.add(tipoTarefa);
		}
		
		
		resultadoDados.close();
		stmt.close();
		return lstTipoTarefa;
		
		
		
	}
	
	
	
	
	
}
