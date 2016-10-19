package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.beans.LancamentoHonorario;
import br.com.fiap.beans.Processo;
import br.com.fiap.beans.TipoTarefa;

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

	public void deletar(int pCodigoHonorario, Connection conexao) throws Exception{
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_AAD_LANCA_HONORARIO WHERE CD_LANCAMENTO = ?");
		stmt.setInt(1, pCodigoHonorario);
		stmt.execute();
		stmt.close();
		System.out.println("Excluído!!");
		
	}
	
	public void atualizar (LancamentoHonorario lh, Connection conexao) throws Exception{
		PreparedStatement stmt = conexao.prepareStatement("UPDATE T_AAD_LANCA_HONORARIO SET CD_TIPO_TAREFA = ?,"
				+ "NR_PROCESSO = ?, DT_HONORARIO = ?, QT_HORA = ?, DS_OBSERVACAO = ? WHERE CD_LANCAMENTO = ?");
		
		stmt.setInt(1, lh.getTipoTarefa().getCodigoTipoTarefa());
		stmt.setLong(2, lh.getProcesso().getNumeroProcesso());
		stmt.setString(3, lh.getDataHonorario());
		stmt.setDouble(4, lh.getQtdeHora());
		stmt.setString(5, lh.getObservacao());
		stmt.setInt(6, lh.getCodigo());
		stmt.execute();
		stmt.close();
		
		
		 System.out.println("Atualizado!");
		
		
	}
	
	public List<LancamentoHonorario> getLista(Connection conexao) throws Exception{
		List<LancamentoHonorario> lstHonorario = new ArrayList<LancamentoHonorario>();
		
		PreparedStatement stmt = conexao.prepareStatement("SELECT DISTINCT P.NR_PROCESSO,P.DS_PROCESSO, LH.CD_TIPO_TAREFA,"
				+ "TF.DS_TIPO_TAREFA, LH.CD_LANCAMENTO, "
				+ "LH.DT_HONORARIO, LH.QT_HORA, LH.DS_OBSERVACAO, VALOR.VALORHORA VALORHORA"
				+ " FROM T_AAD_HORA_ADVOGADO HA INNER JOIN T_AAD_PROCESSO P ON (HA.CD_ADVOGADO = P.CD_ADVOGADO)"
				+ " INNER JOIN T_AAD_LANCA_HONORARIO LH ON (P.NR_PROCESSO = LH.NR_PROCESSO)"
				+ " INNER JOIN T_AAD_TIPO_TAREFA TF ON (LH.CD_TIPO_TAREFA = TF.CD_TIPO_TAREFA), "
				+ "	(SELECT LH.CD_LANCAMENTO LANC,"
				+ "		   HA.VL_HORA VALORHORA"
				+ "		  FROM T_AAD_HORA_ADVOGADO HA INNER JOIN T_AAD_PROCESSO P ON (P.CD_ADVOGADO = HA.CD_ADVOGADO)"
				+ "									  INNER JOIN T_AAD_LANCA_HONORARIO LH ON (P.NR_PROCESSO = LH.NR_PROCESSO) "
				+ "                                         WHERE HA.CD_ADVOGADO = P.CD_ADVOGADO AND "
				+ "											TO_CHAR(HA.DT_VIGENCIA,'MM') = TO_CHAR(LH.DT_HONORARIO,'MM')) VALOR"
				+ "          WHERE LH.CD_LANCAMENTO = VALOR.LANC"
				+ "		ORDER BY LH.CD_LANCAMENTO");
		
		
		ResultSet resultadoDados = stmt.executeQuery();
		
		while(resultadoDados.next()){
			LancamentoHonorario lancaHonorario = new LancamentoHonorario();
			TipoTarefa tipoTarefa = new TipoTarefa();
			Processo processo = new Processo();
			
			
			processo.setNumeroProcesso(resultadoDados.getInt("NR_PROCESSO"));
			processo.setDescricaoProcesso(resultadoDados.getString("DS_PROCESSO"));
			
			tipoTarefa.setCodigoTipoTarefa(resultadoDados.getInt("CD_TIPO_TAREFA"));
			tipoTarefa.setDescricaoTipoTarefa(resultadoDados.getString("DS_TIPO_TAREFA"));
			
			lancaHonorario.setTipoTarefa(tipoTarefa);
			lancaHonorario.setCodigo(resultadoDados.getInt("CD_LANCAMENTO"));
			lancaHonorario.setDataHonorario(resultadoDados.getString("DT_HONORARIO"));
			lancaHonorario.setObservacao(resultadoDados.getString("DS_OBSERVACAO"));
			lancaHonorario.setProcesso(processo);
			lancaHonorario.setQtdeHora(resultadoDados.getDouble("QT_HORA"));
			lancaHonorario.setVlHoraAdvogado(resultadoDados.getDouble("VALORHORA"));
			
			lstHonorario.add(lancaHonorario);
			
			
		}
		resultadoDados.close();
		stmt.close();
				
		return lstHonorario;
	}
	
}
