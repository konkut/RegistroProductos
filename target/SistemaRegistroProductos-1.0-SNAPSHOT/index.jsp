<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.sistemaregistroproductos.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    ArrayList<Productos> lista = (ArrayList<Productos>) session.getAttribute("listaProd");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenedor">
            <h3 id="title">PRIMER PARCIAL TEM-742</h3>
            <p id="title"><span >Nombre: Pedro Luis Condori Cutile</span></p>
            <p id="title"><span >Carnet: 9934509</span></p>
        </div>    
        <h1 id="title">PRODUCTOS</h1>
        <p id="title"><a href="mainController?op=nuevo">Nuevo Producto</a></p>
        <div id="contenedor">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Descripcion</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Categoria</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>

                <%
                    if (lista != null) {
                        for (Productos item : lista) {
                %>
                <tr>
                    <td><%= item.getId()%></td> 
                    <td><%= item.getDescripcion()%></td> 
                    <td><%= item.getCantidad()%></td> 
                    <td><%= item.getPrecio()%></td> 
                    <td><%= item.getCategoria()%></td> 
                    <td><a href="mainController?op=editar&cod=<%= item.getId()%>">Editar</a></td> 
                    <td><a href="mainController?op=eliminar&cod=<%= item.getId()%>" onclick='return confirm("Esta seguro de eliminar el registro?");'>Eliminar</a></td> 
                </tr>
                <%
                        }
                    }
                %>

            </table>
        </div>
    </body>
</html>
