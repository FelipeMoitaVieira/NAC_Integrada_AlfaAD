<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Processos</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<br>
		<h3>LISTAR PROCESSOS</h3>
		<br> <br>
		<c:if test="${not empty msg}">
			<div class="alert alert-success">${msg}</div>

		</c:if>

		<form action="listarProcessoServlet" class="form-horizontal"
			method="post"  id="campo" >

			<div class="form-group">
				<label for="idNome" class="col-sm-2 control-label">Número do
					Processo:</label>
		
				<div class="col-sm-3">
		
					<input type="text" name="processo" id="idProcesso" size="10"
						maxlength="5" class="form-control"
						placeholder="Digite o Num. do Processo"
						onblur="validarProcesso (this ,'erroProcesso' );"> <span
						class="erro" id="erroProcesso"></span>
				</div>

			</div>



			<div class="form-group">
				<label for="idNome" class="col-sm-2 control-label">Nome do
					Cliente:</label>
				<div class="col-sm-5">

					<input type="text" name="nome" id="idNome" size="20" maxlength="50"
						class="form-control" placeholder="Digite o Nome"
						onblur="validarNome (this ,'erroNome' );" onkeyup="alteraMaiusculo()"> <span
						class="erro" id="erroNome"></span>
				</div>

			</div>


			<div class="form-group">
				<label for="idData" class="col-sm-2 control-label"> Período:
				</label>
				<div class="col-sm-2">


					<input type="text" class="form-control" name="data" id="idData"
						placeholder="De" maxlength="10"
						OnKeyPress="formatar('##/##/####', this) "
						onblur="validarData (this ,'erroData' );"><br> <input
						type="text" class="form-control" name="data2" id="idData2"
						placeholder="Até" maxlength="10"
						OnKeyPress="formatar('##/##/####', this) "
						onblur="validarData (this ,'erroData' );">


				</div>
			</div>
			<p class="text-center">
				<input type="submit" value="Buscar" class="btn btn-danger" />
			</p>
		</form>
		<!-- Fechamento do form -->


		<br> <br>
		<h3>Lista de Processos</h3>


		<table class="table table-bordered">
			<tr>
				<th class= "active">Número</th>
				<th class= "active">Cliente</th>
				<th class= "active">Descrição</th>
				<th class= "active"></th>
				<th class= "active"></th>
			</tr>

			
			
			
			<c:forEach items="${processo}" var="processo">
			
			
			 <tr>
					<td class="active">${processo.numeroProcesso}</td>
					<td class="success">${processo.cliente.nome}</td>
					<td class="warning">${processo.descricaoProcesso}</td>
					
					
					<td class="lancarDespesa">
						<c:url value="ProcessoServlet" var="link1">
							<c:param name="acao" value="lancarDespesa"></c:param>
							<c:param name="nrProcesso" value="${processo.numeroProcesso }"></c:param>
						</c:url>
					<a href="${link1 }" class="btn btn-info"> Lançar Despesa</a></td>
					 
					 
					 <td class="lancarHonorario">
						<c:url value="ProcessoServlet" var="link2">
							<c:param name="acao" value="lancarHonorario"></c:param>
							<c:param name="nrProcesso" value="${processo.numeroProcesso }"></c:param>
						</c:url>
					 
					 <a href="#"class=" btn btn-danger">Lançar Honorário</a></td>
				
					
				</tr>
				</c:forEach>
	
		
		
			
			
		</table>
	</div>


	<script type="text/javascript" src="js/script.js" charset="utf-8"></script>

</body>
</html>