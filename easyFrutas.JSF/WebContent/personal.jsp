<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Carrito"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	tus datos son los siguientes! ${userLoged.getNombre()}
	<br> ${userLoged.getApellido()}
	<br> ${userLoged.getEmail()}
	<br> ${userLoged.getDireccion()}
	<br> ${userLoged.getTelefono()}
	<br> ${userLoged.getFechaReg()}
	<br>

	<button
		onclick="window.location.href='ZonaUsuario?accion=modificarDatos'">Actualiza
		tus datos</button>


	compras realizadas:

<table>	<tr>
				<th>Fecha</th>
				<th>Precio</th>
				<th>ver Compra</th>
			</tr>

	<c:forEach items="${compras}" var="compra" varStatus="status">


		
		
			<tr>
				<td>${compra.getFecha()}</td>
				<td>${compra.getPrecio()}</td>
		 		<td><a href="ZonaUsuario?accion=verCompra&id=${compra.getId()}&precio=${compra.getPrecio()}&fecha=${compra.getFecha()}&hora=${compra.getHora()}">Ver Detalles</a></td>
			

			

</tr>
			
	</c:forEach>
	</table>

</body>
</html>