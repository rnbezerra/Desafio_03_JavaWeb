<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${turma.nome} - Nova Aula</title>
</head>
<body>

<h1>Pauta</h1>

<br>

<h2>${turma.nome} - Inserir Aula</h2>

<br>
	<form method="post" action="InserirAula">
		<table>
			<tr>
				<td>ID Turma:</td>
				<td><input type="text"  id="turma" name="turma" value="${turma.id}" readonly/></td>
			</tr>
			<tr>
				<td>Aula:</td>
				<td><input type="text"  id="aula" name="aula"    /></td>
			</tr>
			<tr>
				<td>Data:</td>
				<td><input type="text" id="data" name="data"   /></td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="submit" value="Salvar">
			</td>
		</table>
	</form>
</body>
</html>