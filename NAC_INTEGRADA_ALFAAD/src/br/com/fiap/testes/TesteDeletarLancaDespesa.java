package br.com.fiap.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Advogado;
import br.com.fiap.beans.LancamentoDespesa;
import br.com.fiap.beans.Processo;
import br.com.fiap.beans.TipoCausa;
import br.com.fiap.beans.TipoDespesa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoDespesaDAO;
import br.com.fiap.excecao.Excecao;

public class TesteDeletarLancaDespesa {

	public static void main(String[] args) throws Excecao{
		
		
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));
			
			
			LancamentoDespesaDAO ldDAO = new LancamentoDespesaDAO();
			
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual despesa deletar?"));
			
			ldDAO.deletar(codigo, con);
			
			Advogado ad = new Advogado();
			Processo proc = new Processo();
			LancamentoDespesa ld = new LancamentoDespesa();
			TipoCausa tp = new TipoCausa(1,"Comercial");
			TipoDespesa td = new TipoDespesa(3,"Autenticação");
			
			ad.setCodigo(10);
			ad.setCpf("78945612323");
			ad.setEmail("teste@teste");
			ad.setEndereco(null);
			ad.setEspecialidade(tp);
			ad.setNome("Josefino Aragão");
			ad.setNumeroOAB("123456");
			ad.setRg("445556666");
			ad.setSenha("1234");
			ad.setTelefone(null);


			proc.setAdvogado(ad);
			proc.setCliente(null);
			proc.setDataAbertura("10/10/2016");
			proc.setDataDiaVencimento("05");
			proc.setDataFechamento(null);
			proc.setDescricaoProcesso("Processo Trabalhista");
			proc.setForum(null);
			proc.setNumeroProcesso(20);
			proc.setObservacao("Teste");
			proc.setResultado((byte) 1);
			proc.setSituacao( (byte)1);

			
			ld.setCodigo(98);
			ld.setDataDespesa("07/10/2016");
			ld.setObservacao("Atualizando 2 ");
			ld.setProcesso(proc);
			ld.setTipoDespesa(td);
			ld.setValorDespesa(55);

			
			ldDAO.atualizar(ld, con);
			
		}catch(Exception e){
			throw new Excecao("Errro",e);
		}

	}

}
