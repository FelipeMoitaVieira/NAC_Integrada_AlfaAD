package br.com.fiap.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Processo;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.ProcessoDAO;
import br.com.fiap.excecao.Excecao;

public class TesteListarProcesso {

	public static void main(String[] args) throws Excecao{


		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usu�rio:"),
					JOptionPane.showInputDialog("Digite a senha:"));
			
			
			ProcessoDAO pDAO = new ProcessoDAO();
			List<Processo> lstProcesso = new ArrayList<Processo>();
			lstProcesso = pDAO.getProcessos(con);
			
			for (Processo p: lstProcesso){
				System.out.println("N�mero Processo: " + p.getNumeroProcesso() + 
						"\nCliente: " + p.getCliente().getNome() +
						"\nAdvogado: " + p.getAdvogado().getNome() +
						"\nFor�m: " + p.getForum().getNome() +
						"\nCausa: " + p.getAdvogado().getEspecialidade().getDescricaoTipoCausa() +
						"\nProcesso: " + p.getDescricaoProcesso() +
						"\nData Abertura: " + p.getDataAbertura() +
						"\nData Fechamento: " + p.getDataFechamento() +
						"\nDia Vencimento: " + p.getDataDiaVencimento() +
						"\nResultado: " + p.getResultado() +
						"\nSitua��o: " + p.getSituacao() +
						"\nObserva��es: " + p.getObservacao()
						);
			}
			
			/*
			int intBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero do processo que deseja pesquisar"));
			Processo p = new Processo();
			p = pDAO.pesquisarProcessoNumero(intBusca, con);
			System.out.println("N�mero Processo: " + p.getNumeroProcesso() + 
					"\nCliente: " + p.getCliente().getNome() +
					"\nAdvogado: " + p.getAdvogado().getNome() +
					"\nFor�m: " + p.getForum().getNome() +
					"\nCausa: " + p.getAdvogado().getEspecialidade().getDescricaoTipoCausa() +
					"\nProcesso: " + p.getDescricaoProcesso() +
					"\nData Abertura: " + p.getDataAbertura() +
					"\nData Fechamento: " + p.getDataFechamento() +
					"\nDia Vencimento: " + p.getDataDiaVencimento() +
					"\nResultado: " + p.getResultado() +
					"\nSitua��o: " + p.getSituacao() +
					"\nObserva��es: " + p.getObservacao()
					);
			
			String strBusca = JOptionPane.showInputDialog("Digite o nome do cliente que deseja pesquisar");
			
			lstProcesso = pDAO.pesquisarProcessoNome(strBusca, con);
			for (Processo p1: lstProcesso){
				System.out.println("N�mero Processo: " + p1.getNumeroProcesso() + 
						"\nCliente: " + p1.getCliente().getNome() +
						"\nAdvogado: " + p1.getAdvogado().getNome() +
						"\nFor�m: " + p1.getForum().getNome() +
						"\nCausa: " + p1.getAdvogado().getEspecialidade().getDescricaoTipoCausa() +
						"\nProcesso: " + p1.getDescricaoProcesso() +
						"\nData Abertura: " + p1.getDataAbertura() +
						"\nData Fechamento: " + p1.getDataFechamento() +
						"\nDia Vencimento: " + p1.getDataDiaVencimento() +
						"\nResultado: " + p1.getResultado() +
						"\nSitua��o: " + p1.getSituacao() +
						"\nObserva��es: " + p1.getObservacao()
						);
			}
			*/
		}catch(Exception e){
			throw new Excecao(e);
		}

	}

}
