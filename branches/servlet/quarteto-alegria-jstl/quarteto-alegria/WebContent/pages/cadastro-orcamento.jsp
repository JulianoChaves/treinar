<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="qal" uri="../WEB-INF/quarteto-alegria.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Or�amento</title>
</head>
<body>

	<form action="cadastroOrcamento.qal" method="post">
		<input name="comando" type="hidden" value="br.com.quartetoalegreto.orcamento.controle.OrcamentoCommand">
		
		<label for="nomeCliente">Nome:&#160;</label>
		<input type="text" name="nomeCliente">
		<br />
		<label for="telefone">Telefone:&#160;</label>
		<input type="text" name="telefone">
		<br />		
		<label for="email">Email:&#160;</label>
		<input type="text" name="email">
		<br />	
		<label for="enderecoEvento">Endere�o do Evento:&#160;</label>
		<input type="text" name="enderecoEvento">
		<br />		
		<label for="inicioEvento">Data e Hora do Evento:&#160;</label>
		<input type="text" name="inicioEvento">
		<br />		
		<label for="terminoEvento">Date e HOra de t�rmino do Evento:&#160;</label>
		<input type="text" name="terminoEvento">
		<br />
		<qal:tipoEvento id="tipoEvento" name="tipoEvento" />
		<br />	
		<input type="submit" value="Enviar Or�amento">
		
	</form>

</body>
</html>