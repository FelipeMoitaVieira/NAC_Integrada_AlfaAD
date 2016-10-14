package br.com.fiap.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Advogado;
import br.com.fiap.beans.TipoCausa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.AdvogadoDAO;
import br.com.fiap.excecao.Excecao;

public class TesteAdvogado {

	public static void main(String[] args) throws Excecao {
		
		try{

			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));

			Advogado ad = new Advogado();
			
			TipoCausa tp = new TipoCausa(1,"Comercial");
			
			ad.setCpf("9");
			ad.setEmail("tipoCausa@teste");
			ad.setEndereco(null);
			ad.setEspecialidade(tp);
			ad.setNome("Cacilda");
			ad.setNumeroOAB("123456");
			ad.setRg("5");
			ad.setSenha("1234");
			ad.setTelefone(null);


		

			AdvogadoDAO adDAO = new AdvogadoDAO();
			adDAO.gravar(ad, con);
		}
		catch(Exception e){
			throw new Excecao("Erro",e);
		}

	}

}
