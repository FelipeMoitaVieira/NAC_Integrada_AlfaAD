package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.beans.LancamentoHonorario;

public class LancamentoHonorarioDAO {

public void gravar(LancamentoHonorario lh, Connection conexao) throws Exception{
		
		PreparedStatement estrutura = conexao.prepareStatement("insert into T_AAD_LANCA_HONORARIO "
				+ "(CD_LANCAMENTO, CD_TIPO_TAREFA, NR_PROCESSO, DT_HONORARIO, QT_HORA, DS_OBSERVACAO) "
				+ "values (SQ_AM_LANCA_HONORARIO.nextval,?,?,?,?,?)");
		
		
		estrutura.setInt(1, lh.getTipoTarefa().getCodigoTipoTarefa());
		estrutura.setLong(2, lh.getProcesso().getNumeroProcesso());
		estrutura.setString(3, lh.getDataHonorario());
		estrutura.setDouble(4, lh.getQtdeHora());
		estrutura.setString(5, lh.getObservacao());
		estrutura.execute();
		estrutura.close();
		
		System.out.println("Gravado");
		
	}
	
}
