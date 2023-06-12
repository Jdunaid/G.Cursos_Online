<%-- 
    Document   : curso
    Created on : 01/06/2023, 21:30:06
    Author     : LIGIA
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add novo curso</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=duracao]').datepicker();
        });
    </script>

    <form method="POST" action='CursoController' name="frmAddCurso">
        Curso codigo : <input type="text" readonly="readonly" name="codigo"
            value="<c:out value="${curso.codigo}" />" /> <br /> 
        nome : <input
            type="text" name="nome"
            value="<c:out value="${curso.nome}" />" /> <br /> 
        area : <input
            type="text" name="area"
            value="<c:out value="${curso.area}" />" /> <br /> 
        duracao: <input
            type="text" placeholder="dd/MM/yyyy" name="dob" data-date-format="dd/MM/yyyy"
            value="<fmt:formatDate pattern="dd/MM/yyyy" value="${curso.duracao}" />" /> <br /> 
        cadeira : <input type="text" name="cadeira"
            value="<c:out value="${user.cadeira}" />" /> <br /> 
        Curso videoaula : <input type="text" readonly="readonly" name="videoaula"
            value="<c:out value="${curso.videoaula}" />" /> <br /> 
        <input
            type="submit" value="Submit" />
    </form>
</body>
</html>
