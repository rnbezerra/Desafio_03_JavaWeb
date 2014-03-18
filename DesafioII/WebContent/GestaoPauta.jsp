<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pauta</title>
</head>
<body>
<h1>Pauta</h1>

<h2 align="center">${turma.nome}</h2>
<h2>${aula.nome}</h2>

<a href="AddAula.jsp">Incluir Aula</a>

<c:forEach var="aula" items="${aulalist}">
${aula.nome} - <a href="GestaoAula?id=${aula.id}">Visualizar Presença</a>
</c:forEach>

</body>
</html>