package br.com.fiap.testes;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.TipoDespesa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.TipoDespesaDAO;
import br.com.fiap.excecao.Excecao;

public class TesteListarTipoDespesas {

	public static void main(String[] args) throws Excecao {
		
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));
			
			TipoDespesaDAO tpDespesaDAO = new TipoDespesaDAO();
			List<TipoDespesa> lstTpDespesa = new ArrayList<TipoDespesa>();
			
			
			lstTpDespesa = tpDespesaDAO.getListaTipo(con);
			
			for(TipoDespesa td : lstTpDespesa){
				System.out.println("codigo: " + td.getCodigoTipoDespesa() +
									"\nNome: " + td.getDescricaoTipoDespesa());
			}
			
			
			
			
			
		}catch(Exception e){
			throw new Excecao(e);
		}

	}

}
