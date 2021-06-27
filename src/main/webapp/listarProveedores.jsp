<%-- 
    Document   : listarProveedores
    Created on : 25-jun-2021, 20:41:12
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            .centrado{
                display:block;
                margin-left:auto;
                margin-right: auto;
                text-align: center;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:useBean id="listarProveedores" scope="session" class="com.test.bean.ProveedoresBean" />
        <h1 class="centrado">BUSQUEDA DE USUARIOS POR EL ROL EN EL SISTEMA</h1>
        <a type="button" href="index.jsp" class="btn btn-success centrado">VOLVER</a><br>
        <table class="table table-dark table-hover">
            <thead>
                <tr>
                    <td>Nº</td>
                    <td>Razón Social</td>
                    <td>Dirección</td>
                    <td>Telefono</td>
                    <td>Email</td>
                    <td>ACCIONES</td>
                </tr>
            </thead>
            <tbody>
                <%=listarProveedores.mostrarProveedores() %>
            </tbody>
        </table>
    </body>
</html>
