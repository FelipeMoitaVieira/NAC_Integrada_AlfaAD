<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lançar Honorário</title>
<%@ include file="header.jsp"%>

</head>
<body>
	<%@ include file="menu.jsp"%>


	<div class="container">

		<br>


		<div class="container">
			<h3>LANÇAR HONORÁRIO</h3>
		</div>

		<br> <br>


		<form action="LancarHonorarioServlet" id="campo"
			class="form-horizontal" method="post">

			<input type="hidden" name="acao" value="cadastrar"> 
			<input	type="hidden" name="numeroProcesso"	value="${processo.numeroProcesso }">

			<div class="form-group">
			
				<label class="col-sm-2 control-label">Número Processo </label>
				<div class="col-sm-2">
				
					<c:url value="ProcessoServlet" var="link2">
						<c:param name="acao" value="lancarHonorario"></c:param>
						<c:param name="nrProcesso" value="${processo.numeroProcesso }"></c:param>

					</c:url>
					<input type="text" readonly="readonly"
						value="${processo.numeroProcesso }" class="form-control">
				</div>


			</div>



			<div class="form-group">
				<label for="idTpTarefa" class="col-sm-2 control-label">Tipo
					Tarefa:</label>
				<div class="col-sm-3">
					<select id="idTpTarefa" name="tpTarefa" class="form-control">
						<option value="0">Selecione</option>
						<c:forEach items="${tipoTarefa}" var="t">

							<option value="${t.codigoTipoTarefa }">${t.descricaoTipoTarefa }</option>

						</c:forEach>
					</select> <span class="erro" id="erroNome"></span>

				</div>
			</div>
			<!-- Fechamento da form-group -->
			

			<div class="form-group">
				<label for="idData" class="col-sm-2 control-label"> Data: </label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="data" id="idData"
						placeholder="Digite a data" maxlength="10"
						OnKeyPress="formatar('##/##/####', this) "
						onblur="validarData (this ,'erroData' );"> <span
						class="erro" id="erroData"></span>

				</div>
			</div>
			<!-- Fechamento da form-group -->

			<div class="form-group">
				<label for="idHora" class="col-sm-2 control-label">
					Quantidade de Horas: </label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="hora" id="idHora"
						placeholder="Digite a hora" maxlength="5"
						OnKeyPress="formatar('##.##', this)"
						onblur="validarHora (this ,'erroHora' );"> <span
						class="erro" id="erroHora"></span>
				</div>
			</div>
			<!-- Fechamento da form-group -->


			<div class="form-group ">

				<label class="col-sm-2 control-label">Observações:</label>
				<div class="col-sm-5">
					<textarea rows="5" name="observacao" id="observacao"
						class="form-control" placeholder="Digite aqui sua observação..."></textarea>
				</div>
			</div>
			<!-- Fechamento da form-group -->

			<p class="text-right">
			<div class="form-group">

				<p class="text-center">

					<input id="btnCadastrar" type="submit" class="btn btn-warning"
						value="Cadastrar"> <input class="btn btn-danger"
						id="btnVoltar" type="button" value="Voltar">
				</p>
			</div>

		</form>

	</div>
	<!-- Fechamento da container -->
	<h4 style="color: red;">${msg}</h4>

	<script type="text/javascript" src="js/script.js" charset="utf-8"></script>

</body>
</html>
