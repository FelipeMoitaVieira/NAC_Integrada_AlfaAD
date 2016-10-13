package br.com.fiap.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Advogado;
import br.com.fiap.beans.LancamentoDespesa;
import br.com.fiap.beans.Processo;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoDespesaDAO;
import br.com.fiap.excecao.Excecao;

public class TesteLancaDespesa {

	public static void main(String[] args) throws Excecao{

		try{

			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));

			Advogado ad = new Advogado();
			Processo proc = new Processo();

			ad.setCodigo(10);
			ad.setCpf("78945612323");
			ad.setEmail("teste@teste");
			ad.setEndereco(null);
			ad.setEspecialidade("Trabalhista");
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
			proc.setNumeroProcesso(123456);
			proc.setObservacao("Teste");
			proc.setResultado((short) 1);
			proc.setSituacao((short) 1);

			LancamentoDespesa ld = new LancamentoDespesa();
			ld.setCodigo(500);
			ld.setDataDespesa("12/10/2016");
			ld.setObservacao("Testando");
			ld.setProcesso(proc);
			ld.setTipoDespesa("Xerox");
			ld.setValorDespesa(10);

			LancamentoDespesaDAO ldDAO = new LancamentoDespesaDAO();
			ldDAO.gravar(ld, con);
		}
		catch(Exception e){
			throw new Excecao("Erro",e);
		}


	}

}
