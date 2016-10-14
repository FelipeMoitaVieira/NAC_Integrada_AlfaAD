package br.com.fiap.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Advogado;
import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Forum;
import br.com.fiap.beans.Processo;
import br.com.fiap.beans.TipoCausa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.ProcessoDAO;
import br.com.fiap.excecao.Excecao;

public class TesteProcesso {

	public static void main(String[] args) throws Excecao{


		try{

			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));

			Advogado ad = new Advogado();
			Forum fo = new Forum();
			Cliente cli = new Cliente();
			Processo proc = new Processo();
			TipoCausa tp = new TipoCausa(3,"Tributária");
			
			
			ad.setCodigo(2);
			ad.setEspecialidade(tp);
			
			fo.setCodigo(13);
			cli.setCodigo(8);
			


			proc.setAdvogado(ad);
			proc.setCliente(cli);
			proc.setDataAbertura("14/04/2016");
			proc.setDataDiaVencimento("05");
			proc.setDataFechamento(null);
			proc.setDescricaoProcesso("Processo Imposto de Renda Teste");
			proc.setForum(fo);
			proc.setNumeroProcesso(2);
			proc.setObservacao("Teste Processo");
			proc.setResultado((byte) 1);
			proc.setSituacao( (byte)1);

			
			
			

			ProcessoDAO pDAO = new ProcessoDAO();
			pDAO.gravar(proc, con);
		}
		catch(Exception e){
			throw new Excecao("Erro",e);
		}

	}

}
