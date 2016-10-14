package br.com.fiap.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Advogado;
import br.com.fiap.beans.HoraAdvogado;
import br.com.fiap.beans.TipoCausa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.HoraAdvogadoDAO;
import br.com.fiap.excecao.Excecao;

public class TesteHoraAdvogado {

	public static void main(String[] args) throws Excecao {

		try{
		Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
				JOptionPane.showInputDialog("Digite a senha:"));
		
		
		TipoCausa tp = new TipoCausa(1,"Comercial");
		Advogado ad = new Advogado();
		
		ad.setCodigo(2);
		ad.setCpf("78945612323");
		ad.setEmail("teste@teste");
		ad.setEndereco(null);
		ad.setEspecialidade(tp);
		ad.setNome("Berenice");
		ad.setNumeroOAB("123456");
		ad.setRg("445556666");
		ad.setSenha("1234");
		ad.setTelefone(null);
		
		HoraAdvogado ha = new HoraAdvogado();
		
		ha.setAdvogado(ad);
		ha.setCodigoHistorico(12);
		ha.setDataVigencia("01/12/2014");
		ha.setValorHora(99.32);
		
		HoraAdvogadoDAO haDAO = new HoraAdvogadoDAO();
		haDAO.gravar(ha, con);
		
		}
		catch(Exception e){
			throw new Excecao("Erro",e);
		}
	}

}
