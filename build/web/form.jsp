<%-- 
    Document   : form
    Created on : 26/05/2023, 02:44:13
    Author     : LIGIA
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Curso</title>
</head>
<body>
    <h1>Formulário de Curso</h1>
    <form action="CursoServlet" method="post">
        <input type="hidden" name="action" value="${curso == null ? 'create' : 'update'}">
        <c:if test="${curso != null}">
            <input type="hidden" name="index" value="${index}">
        </c:if>
        <label for="nome">Nome:</label>
        <input type="text" name="nome" id="nome" value="${curso == null ? '' : curso.nome}"><br>
        <label for="curso">Curso:</label>
        <input type="text" name="curso" id="curso" value="${curso == null ? '' : curso.curso}"><br>
        <label for="area">Área:</label>
        <input type="text" name="area" id="area" value="${curso == null ? '' : curso.area}"><br>
        <label for="aula">Aula:</label>
        <input type="number" name="aula" id="aula" value="${curso == null ? '' : curso.aula}"><br>
        <label for="duracao">Duração:</label>
        <input type="number" name="duracao" id="duracao" value="${curso == null ? '' : curso.duracao}"><br>
        <label for="cadeira">Cadeira:</label>
        <input type="number" name="cadeira" id="cadeira" value="${curso == null ? '' : curso.cadeira}"><br>
        <label for="videoaula">Videoaula:</label>
        <input type="number" name="videoaula" id="videoaula" value="${curso == null ? '' : curso.videoaula}"><br>
        <input type="submit" value="${curso == null ? 'Criar Curso' : 'Atualizar Curso'}">
    </form>
    <a href="CursoServlet">Voltar para a Lista</a>
</body>
</html>

