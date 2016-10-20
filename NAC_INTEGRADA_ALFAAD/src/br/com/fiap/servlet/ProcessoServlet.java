package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.LancamentoDespesa;
import br.com.fiap.beans.Processo;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoDespesaDAO;
import br.com.fiap.dao.LancamentoHonorarioDAO;
import br.com.fiap.dao.ProcessoDAO;

/**
 * Servlet implementation class ProcessoServlet
 */
@WebServlet("/ProcessoServlet")
public class ProcessoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ProcessoDAO processoDAO = new ProcessoDAO();
    private LancamentoDespesaDAO ldDAO = new LancamentoDespesaDAO();
    private LancamentoHonorarioDAO lhDAO = new LancamentoHonorarioDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = ConexaoFactory.controlarInstancia().getConnection(null,null);
		

			String acao = request.getParameter("acao");
			String retorno = "";
			switch (acao){
			
			case "listar":
				listar(request,con);
				retorno = "listarProcesso.jsp";
						break;
			
			case "lancarDespesa":
				lancarDespesa(request,con);
				retorno = "LancarDespesaServlet?acao=carregar";
				break;
			
			case "lancarHonorario":
				
				
				break;
			}





		




			request.getRequestDispatcher(retorno).forward(request, response);

			//Bloco Exceção
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void listar(HttpServletRequest request, Connection con) throws Exception{
		ProcessoDAO pDAO = new ProcessoDAO();
		request.setAttribute("processo", pDAO.getProcessos(con));
		
	}
	
	private void lancarDespesa(HttpServletRequest request, Connection con) throws Exception{
		if(request.getParameter("nrProcesso") != null){
			int nrProcesso = Integer.parseInt(request.getParameter("nrProcesso"));
			Processo processo = processoDAO.pesquisarProcessoNumero(nrProcesso, con);
			request.setAttribute("processo", processo);
			request.getRequestDispatcher("LancarDespesaServlet?acao=carregar");
		}
		
	}

}
