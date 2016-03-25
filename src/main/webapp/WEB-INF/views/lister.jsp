<%-- 
    Document   : lister
    Created on : 24 mars 2016, 12:29:09
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <a href="<c:url value="/effacemoi/effaceMoiAjouterGet"></c:url>">Ajouter un record</a>
        <c:forEach items="${maListe}" var="effaceMoi">
            <a href="<c:url value="/effacemoi/detail"></c:url>/${effaceMoi.id}">${effaceMoi.id}</a><br/>
        </c:forEach>
    </body>
</html>
