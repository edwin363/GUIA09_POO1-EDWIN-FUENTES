<%-- 
    Document   : index
    Created on : 18-abr-2018, 20:36:40
    Author     : edwin
--%>

<%@page import="com.sv.udb.controlador.PiezasCtrl"%>
<%@page import="com.sv.udb.modelos.Piezas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <title>Repuestos</title>
        <link rel="stylesheet" href="webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Bienvenido a repuestoss</h1>
        
        <div class="container">
            <div class="alert alert-success">
                <strong>Indicaciones:</strong> Usando Bootstrap con la Guía 09 Edwin.
            </div>
            
            <div class="row">
                <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Piezas</div>
                        <div class="panel-body">
                            <c:if test = "${resp}">
                                <div class="alert alert-success">
                                    ${mensAler}
                                </div
                            </c:if>
                            <div class="alert alert-success">
                                ${mensAler}
                            </div>
                            <form method="post" action="procesar.jsp" name="Demo">
                                <input type="hidden" name="codi" id="codi" value="${codi}"/>
                                
                                <div class="form-group">
                                    <label for="nomb">Nombre de la pieza:</label>
                                    <input type="text" class="form-control" name="nomPiez" id="nomb" value="${nomb}"/>
                                </div>
                                
                                <div class="form-group">
                                    <label for="marca">Marca de la pieza:</label>
                                    <input type="text" class="form-control" name="marcPiez" id="marca" value="${marca}"/>
                                </div>
                                
                                <div class="form-group">
                                    <label for="tipo">Tipo de pieza:</label>
                                    <input type="text" class="form-control" name="tipoPiez" id="tipo" value="${tipo}"/>
                                </div>
                                    <c:choose>
                                        <c:when test="${mensAler != false}">
                                            <input type="submit" class="btn btn-default" name="btnPie" value="Guardar"/>
                                        </c:when>

                                        <c:otherwise>
                                            <input type="submit" class="btn btn-default" name="btnPie" value="Nuevo"/>
                                            <input type="submit" class="btn btn-primary" name="btnPie" value="Modificar"/>
                                            <input type="submit" class="btn btn-danger" name="btnPie" value="Eliminar"/>
                                        </c:otherwise>
                                    </c:choose>
                            </form>
                        </div>
                    </div>
                </div>
                                <div class="col-md-7">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading">La Tabla</div>
                                        <div class="panel-body">
                                            <form method="POST" action="PiezasServ" name="Tabl">
                                                <display:table export="true" id="tablPiez" name="<%= new PiezasCtrl().tabla() %>">
                                                    <display:column title="Cons">
                                                        <input type="radio" name="codiPiezRadi" value="${tablPiez.codiPiez}"/>
                                                    </display:column>
                                                    <display:column property="nomPiez" title="Nombre de pieza" sortable="true"/>
                                                    <display:column property="tipoPiez" title="Tipo de pieza" sortable="true"/>
                                                    <display:column property="marcPiez" title="Marca de pieza" sortable="true"/>
                                                </display:table>
                                            </form>
                                        </div>
                                    </div>
                                </div>
            </div>
        </div>
        
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>
