package br.com.fiap.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.excecao.Excecao;

public class TesteCliente {

public static void main(String[] args) throws Excecao {
		
		try{

			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));

			Cliente cl = new Cliente();
			

			
			cl.setCnpj("78945612323");
			cl.setEmail("teste@teste");
			cl.setEndereco(null);
			cl.setNome("Pão de Açúcar");
			cl.setInscricaoEstadual("9999999");
			cl.setRazaoSocial("LTDA");
			cl.setSenha("1234");
			cl.setTelefone(null);
			


		

			ClienteDAO clDAO = new ClienteDAO();
			clDAO.gravar(cl, con);
		}
		catch(Exception e){
			throw new Excecao("Erro",e);
		}

	}

}
