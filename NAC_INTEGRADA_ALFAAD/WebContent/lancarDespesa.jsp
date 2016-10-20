<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lançar Despesa</title>
<%@ include file="header.jsp"%>
</head>

<body>
	<%@ include file="menu.jsp"%>

	<br>

	<div class="container">
		<h3>LANÇAR DESPESA</h3>
		<br> 
		<br>
		<form action="LancarDespesaServlet" class="form-horizontal"	method="post" id="campo" >
			
			<input type="hidden" name="acao" value="cadastrar">
			<input type="hidden" name="numeroProcesso" value="${processo.numeroProcesso }">
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Número Processo: </label>
				<div div class="col-sm-2">
				
				<c:url value="ProcessoServlet" var="link1">
							<c:param name="acao" value="lancarDespesa"></c:param>
							<c:param name="nrProcesso" value="${processo.numeroProcesso }"></c:param>
							
				</c:url>
				<input type="text" readonly="readonly" value="${processo.numeroProcesso }" class="form-control">
				</div>
			</div>
				<div class="form-group">
				
				<label for="idTpDespesa" class="col-sm-2 control-label">Tipo Despesa:</label>

				<div class="col-sm-3">
				<select id= "idTpDespesa" name= "tpDespesa" class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${tipoDespesa}" var= "t">
				
						<option value="${t.codigoTipoDespesa }">${t.descricaoTipoDespesa }</option>
				
					</c:forEach>
				</select>
						 <span class="erro" id="erroNome"></span>
				
				</div>
			</div>
			<!-- Fechamento do form-group-->

			<div class="form-group">
				<label for="idData" class="col-sm-2 control-label"> Data: </label>
				<div class="col-sm-2">
					<input type="text" class="form-control"
						OnKeyPress="formatar('##/##/####', this)" maxlength="10"
						name="data" id="idData" placeholder="Digite a Data"
						onblur="validarData (this, 'erroData');" > <span
						class="erro" id="erroData"></span>

				</div>
			</div>
			<!-- Fechamento do form-group-->


			<div class="form-group">

				<label for="idValor" class="col-sm-2 control-label">Valor:</label>
				<div class="input-group col-sm-2">
					<div class="input-group-addon">R$</div>
					<input type="text" name="valor" class="form-control" id="idValor"
						size="20" placeholder="Valor"
						onblur="validarValor (this, 'erroValor');">

					<div class="input-group-addon">.00</div>
				</div>
			</div>
			<!-- Fechamento do form-group-->

			<div class="form-group ">

				<label class="col-sm-2 control-label">Observações:</label>
				<div class="col-sm-5">
					<textarea rows="5"  name="observacao" id="idObservacao"
						class="form-control" placeholder="Digite aqui sua observação..."></textarea>
				</div>
			</div>



			<div class="form-group">
				<p class="text-center">
					<input id="btnCadastrar" type="submit" class="btn btn-warning"
						value="Cadastrar"> <a href="ListarProcesso.html"><input
						class="btn btn-danger" id="btnVoltar" type="button" value="Voltar"></a>
				</p>
			</div>

		</form>
	</div>
	<!-- Fechamento do container-->
	<h4 style="color:red;">${msg}</h4>

	<script type="text/javascript" src="js/script.js" charset="utf-8"></script>

</body>
</html>
