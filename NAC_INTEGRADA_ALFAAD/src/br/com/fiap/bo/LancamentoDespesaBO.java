package br.com.fiap.bo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.LancamentoDespesa;
import br.com.fiap.dao.LancamentoDespesaDAO;
import br.com.fiap.excecao.Excecao;

public abstract class LancamentoDespesaBO {

	public static void gravar(LancamentoDespesa ld, Connection conexao) throws Exception{
		if(ld.getDataDespesa().length() < 6){
			throw new Excecao("Data Inválida");
		}
		if(ld.getValorDespesa() <= 0){
			throw new Excecao("Valor da Despesa Inválido");
		}		
		new LancamentoDespesaDAO().gravar(ld, conexao);
	
	}// fecha gravar
	
	public static void deletar(int pCodigoDespesa, Connection conexao) throws Exception{
		new LancamentoDespesaDAO().deletar(pCodigoDespesa, conexao);
	}
	public static void atualizar(LancamentoDespesa ld, Connection conexao) throws Exception{
		new LancamentoDespesaDAO().atualizar(ld, conexao);
	}
	public static List<LancamentoDespesa> getLista(Connection conexao,int codigo) throws Exception{
		List<LancamentoDespesa> lstDespesa = new ArrayList<LancamentoDespesa>();		
		return new LancamentoDespesaDAO().getLista(conexao,codigo) ;
		
	}
	
	
//int codigo, TipoDespesa tipoDespesa, Processo processo,
//	String dataDespesa, double valorDespesa,String observacao
}
