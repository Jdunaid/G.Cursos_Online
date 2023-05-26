<%-- 
    Document   : list
    Created on : 26/05/2023, 02:40:34
    Author     : LIGIA
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Cursos</title>
</head>
<body>
    <h1>Listagem de Cursos</h1>
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Curso</th>
                <th>Área</th>
                <th>Aula</th>
                <th>Duração</th>
                <th>Cadeira</th>
                <th>Videoaula</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="curso" items="${cursos}">
                <tr>
                    <td>${curso.nome}</td>
                    <td>${curso.curso}</td>
                    <td>${curso.area}</td>
                    <td>${curso.aula}</td>
                    <td>${curso.duracao}</td>
                    <td>${curso.cadeira}</td>
                    <td>${curso.videoaula}</td>
                    <td>
                        <a href="CursoServlet?action=edit&index=${cursos.indexOf(curso)}">Editar</a>
                        <a href="CursoServlet?action=delete&index=${cursos.indexOf(curso)}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="CursoServlet?action=showForm">Adicionar Curso</a>
</body>
</html>

