package br.com.fiap.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.LancamentoHonorario;
import br.com.fiap.beans.Processo;
import br.com.fiap.beans.TipoTarefa;
import br.com.fiap.conexao.ConexaoFactory;
import br.com.fiap.dao.LancamentoHonorarioDAO;
import br.com.fiap.dao.TipoTarefaDAO;


@WebServlet("/LancarHonorarioServlet")
public class LancarHonorarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LancamentoHonorarioDAO lhDAO = new LancamentoHonorarioDAO();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{

			Connection con = ConexaoFactory.controlarInstancia().getConnection(null,null);

			String acao = request.getParameter("acao");
			String retorno = "";
			switch (acao) {

			case "carregar":
				carregarOpcao(request, con);
				retorno = "lancarHonorario.jsp";
				break;


			case "cadastrar":
				cadastrar (request, con);
				carregarOpcao (request, con);
				retorno = "lancarHonorario.jsp";
				break;

			}

			request.getRequestDispatcher(retorno).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	private void carregarOpcao(HttpServletRequest request, Connection con) throws Exception {

		TipoTarefaDAO tptDAO = new TipoTarefaDAO();
		request.setAttribute("tipoTarefa", tptDAO.getListaTipo(con));

	}

	private void cadastrar(HttpServletRequest request, Connection con) throws Exception {

		int codigoTipoTarefa =  Integer.parseInt(request.getParameter("tpTarefa"));
		int nrProcesso = Integer.parseInt(request.getParameter("numeroProcesso"));
		String dataHonorario = request.getParameter("data");
		double qtdeHora = Double.parseDouble(request.getParameter("hora"));
		String obs = request.getParameter("observacao");

		Processo processo = new Processo();
		processo.setNumeroProcesso(nrProcesso);

		TipoTarefa tpTarefa = new TipoTarefa();
		tpTarefa.setCodigoTipoTarefa(codigoTipoTarefa);

		LancamentoHonorario lh = new LancamentoHonorario();
		lh.setDataHonorario(dataHonorario);
		lh.setObservacao(obs);
		lh.setProcesso(processo);
		lh.setQtdeHora(qtdeHora);
		lh.setTipoTarefa(tpTarefa);


		lhDAO.gravar(lh, con);

		request.setAttribute("msg", "Honorário Cadastrado");

	}


}
