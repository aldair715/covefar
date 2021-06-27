<%-- 
    Document   : buscarProductoPorCategoria
    Created on : 08-jun-2021, 21:06:37
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%! String salidaTabla=""; %>
    </head>
    <body>
        <jsp:useBean id="categoriaBean" scope="session" class="com.test.bean.CategoriaBean"/>
        <jsp:useBean id="productoBean" scope="session" class="com.test.bean.ProductoBean"/>
        <%
        if(request.getParameter("buscar")!=null)
        {
            int codCat=Integer.parseInt(request.getParameter("codCategoria"));
            //llamando al metodo torticolis.
            salidaTabla=productoBean.buscarProductosPorCategoria(codCat);
            
        }
        %>
        <h1>Hello World!</h1>
        <form method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">CATEGORIA</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <select name="codCategoria">
                                <%=categoriaBean.listarCategoriasSelect()%>
                            </select>
                        </td>
                        <td>
                            <label></label>
                            <button type="submit" name="buscar">BUSCAR</button>
                        </td>
                    </tr>
                    
                </tbody>
            </table>
                            <table border="1">
                                <thead>
                                    <th>PRODUCTO</th>
                                    <th>DESCRIPCION</th>
                                    <th>COSTO UNITARIO COMPRA</th>
                                    <th>COSTO UNITARIO VENTA</th>
                                    <th>STOCK</th>
                                    <th>PROVEEDOR</th>
                                </thead>
                                <tbody>
                                    
                                    <%=salidaTabla%>
                                </tbody>
                            </table>
        </form>
    </body>
    
</html>
