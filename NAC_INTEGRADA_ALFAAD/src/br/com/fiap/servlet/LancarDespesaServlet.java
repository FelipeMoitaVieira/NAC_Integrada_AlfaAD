package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.fiap.beans.LancamentoDespesa;
import br.com.fiap.beans.TipoDespesa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoDespesaDAO;
import br.com.fiap.dao.TipoDespesaDAO;
import jdk.internal.org.objectweb.asm.commons.SimpleRemapper;
import jdk.nashorn.internal.runtime.ListAdapter;


/**
 * Servlet implementation class LancarDespesaServlet
 */
@WebServlet("/LancarDespesaServlet")
public class LancarDespesaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		try{
			Connection con = ConexaoFactory.controlarInstancia().getConnection(JOptionPane.showInputDialog("Digite o usuário:"),
					JOptionPane.showInputDialog("Digite a senha:"));
			}catch(Exception e) {
				try {
					throw new Exception(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		
		
		String acao = request.getParameter("acao");
		String retorno = "";
		
		switch (acao) {
		case "cadastrar":

			try {
				cadastrar(request);
				retorno = "listarProcesso.jsp";
				
			} catch (ParseException e) {
				
				request.setAttribute("erro", "Data Inválida");
				carregarCombo (request);
				retorno = "LancarDespesa.jsp";
				
			}catch (Exception e) {
				carregarCombo(request);
				request.setAttribute("erro", e.getMessage());
				retorno = "LancarDespesa.jsp";
			}
			break;
			
		       case "listar":
			try {
				
				listar(request, null);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				retorno = "listaAluno.jsp";
				break;
			
			
			
			
		}

			
		request.getRequestDispatcher(retorno).forward(request, response);
		
	}

	
	private void listar(HttpServletRequest request, Connection con) throws Exception {
		
		
		LancamentoDespesaDAO dao = new LancamentoDespesaDAO();
		TipoDespesaDAO tipoDespesaDAO = new TipoDespesaDAO();
		List<TipoDespesa> tipoDespesas = tipoDespesaDAO.getLista(con);
		request.setAttribute("tipoDespesas", tipoDespesas);
		request.setAttribute("lista", dao.getLista(con));
		
		
	}

	private void carregarCombo(HttpServletRequest request) {
	 
	 
		
	}

	private void cadastrar(HttpServletRequest request) {
		
	 String tipoDespesa = request.getParameter("mod");
     double valorDepesa = Double.parseDouble(request.getParameter("valorDespesa"));
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
     
     
	}

	
	
	
	
}
