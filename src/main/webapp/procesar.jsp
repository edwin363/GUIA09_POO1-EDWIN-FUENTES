<%-- 
    Document   : procesar.jsp
    Created on : 19-abr-2018, 16:47:47
    Author     : edwin
    Ver 
--%>
<%@page import="com.sv.udb.modelos.Piezas"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="myBean" class="com.sv.udb.modelos.Piezas" scope="request">
            <jsp:setProperty name="myBean" property="*"/>
        </jsp:useBean>
        
        <%
            //Piezas objTemp = (Piezas)request
        %>
        
        <h2>
            <c:out value="${myBean.nomPiez}"/>
            <c:out value="${myBean.marcPiez}"/>
            <c:out value="${myBean.tipoPiez}"/>
        </h2>
    </body>
</html>
