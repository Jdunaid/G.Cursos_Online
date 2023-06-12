<%-- 
    Document   : listCurso
    Created on : 01/06/2023, 21:29:51
    Author     : LIGIA
--%>


<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Show All Users</title>
    </head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>codigo</th>
                <th>nome</th>
                <th>area</th>
                <th>duracao</th>
                 <th>cadeira</th>
                <th>videoaula</th>
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${Curso}" var="curso">
                <tr>
                    <td><c:out value="${curso.codigo}" /></td>
                    <td><c:out value="${curso.nome}" /></td>
                    <td><c:out value="${curso.area}" /></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${curso.duracao}" /></td>
                    <td><c:out value="${curso.cadeira}" /></td>
                    <td><c:out value="${curso.videoaula}" /></td>
                    <td><a href="CursoController?action=edit&codigo=<c:out value="${curso.codigo}"/>">Update</a></td>
                    <td><a href="CursoController?action=delete&codigo=<c:out value="${user.codigo}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="CursoController?action=insert">Add Curso</a></p>
</body>
</html>