package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.beans.HoraAdvogado;

public class HoraAdvogadoDAO {
	
public void gravar(HoraAdvogado ha, Connection conexao) throws Exception{
		
		PreparedStatement estrutura = conexao.prepareStatement("insert into T_AAD_HORA_ADVOGADO "
				+ "(CD_HIST_HORA, CD_ADVOGADO,DT_VIGENCIA,VL_HORA) "
				+ "values (?,?,?,?)");
		
		
		
		estrutura.setInt(1, ha.getCodigoHistorico());
		estrutura.setLong(2, ha.getAdvogado().getCodigo());
		estrutura.setString(3, ha.getDataVigencia());
		estrutura.setDouble(4, ha.getValorHora());
		
		estrutura.execute();
		
		estrutura.close();
		
	}

}
