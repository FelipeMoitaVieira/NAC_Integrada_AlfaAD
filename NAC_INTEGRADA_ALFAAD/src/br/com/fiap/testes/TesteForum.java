package br.com.fiap.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Forum;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.ForumDAO;
import br.com.fiap.excecao.Excecao;

public class TesteForum {

public static void main(String[] args) throws Excecao {
		
		try{

			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));

			Forum fo = new Forum();
			

			
			fo.setDescricao("2º Forum Distrital");
			fo.setEndereco(null);
			fo.setNome("Pão de Açúcar");
			fo.setTelefone(null);
			

			ForumDAO foDAO = new ForumDAO();
			foDAO.gravar(fo, con);
		}
		catch(Exception e){
			throw new Excecao("Erro",e);
		}

	}

}
