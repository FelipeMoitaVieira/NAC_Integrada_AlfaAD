package br.com.fiap.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import br.com.fiap.beans.LancamentoHonorario;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoHonorarioDAO;
import br.com.fiap.excecao.Excecao;

public class TesteListarHonorario {

	public static void main(String[] args) throws Excecao {
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));
			
			
			LancamentoHonorarioDAO lhDAO = new LancamentoHonorarioDAO();
			
			List<LancamentoHonorario> lstHonorario = new ArrayList<LancamentoHonorario>();
			lstHonorario = lhDAO.getLista(con);
			
			for (LancamentoHonorario lh: lstHonorario){
				System.out.println("Código Lançamento: " + lh.getCodigo() + 
						"\nCódigo Tipo Tarefa: " + lh.getTipoTarefa().getCodigoTipoTarefa() +
						"\nNome Despesa: " + lh.getTipoTarefa().getDescricaoTipoTarefa() +
						"\nNúmero Processo: " + lh.getProcesso().getNumeroProcesso() +
						"\nNome Processo: " + lh.getProcesso().getDescricaoProcesso() +
						"\nData Despesa: " + lh.getDataHonorario() +
						"\nQuantidade Hora: " + lh.getQtdeHora() +
						"\nValor Hora: " + lh.getVlHoraAdvogado()+
						"\n\n"
						);
			}
			
			
			
		}catch(Exception e){
			throw new Excecao(e);
		}
	}

}
