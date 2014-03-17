<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nova Aula</title>
</head>
<body>
	<form method="post" action="InserirAula">
		<table>
			<tr>
				<td>Turma:</td>
				<td><input type="text"  id="turma" name="turma" readonly/></td>
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