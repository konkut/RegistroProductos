
<%@page import="com.mycompany.sistemaregistroproductos.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Productos item = (Productos) request.getAttribute("miProducto");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="mainController" method="POST" id="contenedor">
		<p id="title"><%= (item.getId() != 0)? "EDITAR REGISTRO" : "NUEVO REGISTRO" %>Login</p>
                <p><br> <input type="hidden"  name="Id" value="<%= item.getId()%>" required></p>
                <p>Descripcion:<br> <input type="text"  name="Descripcion" value="<%= item.getDescripcion()%>"placeholder="Ingrese la descripcion" required></p>
                <p>Cantidad:<br> <input type="text"  name="Cantidad" value="<%= item.getCantidad() %>" placeholder="Ingrese la cantidad" required></p><br>
                <p>Precio:<br> <input type="text"  name="Precio" value="<%= item.getPrecio()%>" placeholder="Ingrese la precio" required></p><br>
                <p>Categoria:<br> <input type="text" name="Categoria" value="<%= item.getCategoria() %>" placeholder="Ingrese la categoria" required></p><br>
		<p><input type="submit" value="Enviar"></p>
	</form>
    </body>
</html>
