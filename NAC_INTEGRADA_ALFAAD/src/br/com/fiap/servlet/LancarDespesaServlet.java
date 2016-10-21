package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.LancamentoDespesa;
import br.com.fiap.beans.Processo;
import br.com.fiap.beans.TipoDespesa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoDespesaDAO;
import br.com.fiap.dao.TipoDespesaDAO;



@WebServlet("/LancarDespesaServlet")
public class LancarDespesaServlet extends HttpServlet{
	

	private static final long serialVersionUID = 1L;
	private LancamentoDespesaDAO ldDAO = new LancamentoDespesaDAO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Connection con = ConexaoFactory.controlarInstancia().getConnection(null,null);
		

			String acao = request.getParameter("acao");
			String retorno = "";
			switch (acao){
			
			case "carregar":
				carregaOpcao(request,con);
				retorno = "lancarDespesa.jsp";
						break;
			
			
			case "cadastrar":
				cadastrar(request,con); carregaOpcao(request,con);
				retorno = "lancarDespesa.jsp";
				break;
			
			case "listar":
				listarDespesa(request,con);
				retorno = "listarDespesa.jsp";
				break;
			
			case "exibir": 
				editar(request,con); carregaOpcao(request,con);
				retorno = "lancarDespesa.jsp";
				break;
			
			case "atualizar":
				atualizar(request,con);
				retorno = "lancarDespesa.jsp";
				
			}
			






			request.getRequestDispatcher(retorno).forward(request, response);

			//Bloco Exceção
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void editar(HttpServletRequest request, Connection con) throws Exception {
		LancamentoDespesaDAO ldDAO = new LancamentoDespesaDAO();
		int codigoTipoDespesa = Integer.parseInt(request.getParameter("cdDespesa"));
		LancamentoDespesa ld = ldDAO.getDespesa(con, codigoTipoDespesa);
		request.setAttribute("despesa", ld);
		int nrProcesso = Integer.parseInt(request.getParameter("nrProcesso"));
		Processo processo = new Processo();
		processo.setNumeroProcesso(nrProcesso);
		request.setAttribute("processo", processo);
	}


	private void listarDespesa(HttpServletRequest request, Connection con) throws Exception{
		LancamentoDespesaDAO ldDAO = new LancamentoDespesaDAO();
		int nrProcesso = Integer.parseInt(request.getParameter("nrProcesso")); 
		Processo p = new Processo();
		p.setNumeroProcesso(nrProcesso);
		request.setAttribute("despesa", ldDAO.getLista(con,nrProcesso));
		request.setAttribute("processo", p);
		
	}


	private void cadastrar(HttpServletRequest request, Connection con) throws Exception {
		int codigoTipoDespesa = Integer.parseInt(request.getParameter("tpDespesa"));
		int nrProcesso = Integer.parseInt(request.getParameter("nrProcesso"));
		String dataDespesa = request.getParameter("data");
		double valorDespesa = Double.parseDouble(request.getParameter("valor"));
		String obs = request.getParameter("observacao");
		
		
		
		
		Processo processo = new Processo();
		processo.setNumeroProcesso(nrProcesso);
		
		TipoDespesa tpDespesa = new TipoDespesa();
		tpDespesa.setCodigoTipoDespesa(codigoTipoDespesa);
		
		LancamentoDespesa ld = new LancamentoDespesa();
		ld.setDataDespesa(dataDespesa);
		ld.setObservacao(obs);
		ld.setProcesso(processo);
		ld.setTipoDespesa(tpDespesa);
		ld.setValorDespesa(valorDespesa);

		ldDAO.gravar(ld, con);
		
		request.setAttribute("msg", "Despesa Cadastrada");
		
	}


	private void carregaOpcao(HttpServletRequest request, Connection con) throws Exception{
		TipoDespesaDAO tdDAO = new TipoDespesaDAO();
		request.setAttribute("tipoDespesa", tdDAO.getListaTipo(con));
		
	}

	
	private void atualizar(HttpServletRequest request, Connection con) throws Exception {
		int codigoTipoDespesa = Integer.parseInt(request.getParameter("tpDespesa"));
		int nrProcesso = Integer.parseInt(request.getParameter("nrProcesso"));
		String dataDespesa = request.getParameter("data");
		double valorDespesa = Double.parseDouble(request.getParameter("valor"));
		String obs = request.getParameter("observacao");
		
		
		
		
		Processo processo = new Processo();
		processo.setNumeroProcesso(nrProcesso);
		
		TipoDespesa tpDespesa = new TipoDespesa();
		tpDespesa.setCodigoTipoDespesa(codigoTipoDespesa);
		
		LancamentoDespesa ld = new LancamentoDespesa();
		ld.setDataDespesa(dataDespesa);
		ld.setObservacao(obs);
		ld.setProcesso(processo);
		ld.setTipoDespesa(tpDespesa);
		ld.setValorDespesa(valorDespesa);

		ldDAO.atualizar(ld, con);
		
		request.setAttribute("msg", "Despesa Cadastrada");
		
	}

	
	
	
	
}
