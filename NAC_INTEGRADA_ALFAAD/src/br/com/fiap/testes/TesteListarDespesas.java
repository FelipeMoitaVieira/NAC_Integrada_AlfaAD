package br.com.fiap.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.LancamentoDespesa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoDespesaDAO;
import br.com.fiap.excecao.Excecao;

public class TesteListarDespesas {

	public static void main(String[] args) throws Excecao{

		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));
			
			
			LancamentoDespesaDAO ldDAO = new LancamentoDespesaDAO();
			List<LancamentoDespesa> lstDespesa = new ArrayList<LancamentoDespesa>();
			lstDespesa = ldDAO.getLista(con,15);
			
			for (LancamentoDespesa ld: lstDespesa){
				System.out.println("Código Lançamento: " + ld.getCodigo() + 
						"\nCódigo Tipo Despesa: " + ld.getTipoDespesa().getCodigoTipoDespesa() +
						"\nNome Despesa: " + ld.getTipoDespesa().getDescricaoTipoDespesa() +
						"\nNúmero Processo: " + ld.getProcesso().getNumeroProcesso() +
						"\nNome Processo: " + ld.getProcesso().getDescricaoProcesso() +
						"\nData Despesa: " + ld.getDataDespesa() +
						"\nValor Despesa: " + ld.getValorDespesa() +
						"\nObservações: " + ld.getObservacao()
						);
			}
			
			
			
		}catch(Exception e){
			throw new Excecao(e);
		}
		
	}

}
