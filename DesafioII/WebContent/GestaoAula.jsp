<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerir Aula</title>
</head>
<body>
<h1>
${turma.nome}
</h1>

<h2>
${aula.nome}
</h2>
<ul>
        <c:forEach var="aluno" items="${alunolist}">
                <li>
                        ${aluno.nome}
                        
                        <c:if test="${aula.AlunoEstaPresent(presentalunolist, aluno.matricula) == true}  ">
                                <a href="GerenciarPresenca?id=${aula.id}&matricula=${aluno.matricula}&tipo=1">Presente</a>
                        </c:if>
                        
                        <c:if test="${aula.AlunoEstaPresent(presentalunolist, aluno.matricula) == false}">
                                <a href="GerenciarPresenca?id=${aula.id}&matricula=${aluno.matricula}&tipo=0">Ausente</a>
                        </c:if>
                        
                        <hr />
                </li>
        </c:forEach>
</ul>

</body>
</html>
