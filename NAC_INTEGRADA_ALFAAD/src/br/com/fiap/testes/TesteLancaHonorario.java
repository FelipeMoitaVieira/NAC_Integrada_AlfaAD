package br.com.fiap.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Advogado;
import br.com.fiap.beans.LancamentoHonorario;
import br.com.fiap.beans.Processo;
import br.com.fiap.beans.TipoCausa;
import br.com.fiap.beans.TipoTarefa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoHonorarioDAO;
import br.com.fiap.excecao.Excecao;

public class TesteLancaHonorario {

	public static void main(String[] args) throws Excecao{
		
		
		try{

			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));

			Advogado ad = new Advogado();
			Processo proc = new Processo();
			LancamentoHonorario lh = new LancamentoHonorario();
			TipoCausa tp = new TipoCausa(1,"Comercial");
			TipoTarefa tf = new TipoTarefa(3,"Estudo do Processo");
			
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
			proc.setNumeroProcesso(2);
			proc.setObservacao("Teste");
			proc.setResultado((byte) 1);
			proc.setSituacao( (byte)1);

			lh.setDataHonorario("14/10/2016");
			lh.setObservacao("Teste Honorario");
			lh.setProcesso(proc);
			lh.setQtdeHora(1.2);
			lh.setTipoTarefa(tf);
			
			

			LancamentoHonorarioDAO lhDAO = new LancamentoHonorarioDAO();
			lhDAO.gravar(lh, con);
		}
		catch(Exception e){
			throw new Excecao("Erro",e);
		}

	}

}
