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
		<h3>Despesa</h3>

		<input type="hidden" name="nrProcesso" value="${processo.numeroProcesso }">
		<table class="table table-bordered">
			<tr>
				<th class= "active">Código Despesa</th>
				<th class= "active">Despesa</th>
				<th class= "active">Valor</th>
				<th class= "active">Data</th>
				<th class= "active">Observação</th>
				<th class= "active"></th>
				<th class= "active"></th>
				
			</tr>

			
			
			
			<c:forEach items="${despesa}" var="despesa">
			
			
			 <tr>
					<td class="active">${despesa.codigo}</td>
					<td class="success">${despesa.tipoDespesa.descricaoTipoDespesa}</td>
					<td class="warning">${despesa.valorDespesa}</td>
					<td class="active">${despesa.dataDespesa}</td>
					<td class="success">${despesa.observacao}</td>
					
					
					<td class="alterarDespesa">
						<c:url value="LancarDespesaServlet" var="link1">
							<c:param name="acao" value="exibir"></c:param>
							<c:param name="cdDespesa" value="${despesa.codigo }"></c:param>
							<c:param name="nrProcesso" value="${processo.numeroProcesso }"></c:param>
						</c:url>
					<a href="${link1 }" class="btn btn-warning btn-block"> Alterar</a></td>
					
					
					
					<td class="excluirDespesa">
						<c:url value="LancarDespesaServlet" var="link2">
							<c:param name="acao" value="listar"></c:param>
							<c:param name="nrProcesso" value="${processo.numeroProcesso }"></c:param>
						</c:url>
					<a href="${link2 }" class="btn btn-danger btn-block"> Excluir</a></td>
					 
					 
					 
					
				</tr>
				</c:forEach>
			
		
		
			
			
		</table>
	
	</div>
	<!-- Fechamento do container-->
	<h4 style="color:red;">${msg}</h4>

	<script type="text/javascript" src="js/script.js" charset="utf-8"></script>