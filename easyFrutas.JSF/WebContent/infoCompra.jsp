<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	tu compra!

	<p>precio: ${compra.getPrecio()}</p>
	<p>Fecha: ${compra.getFecha()}</p>
	<p>Hora: ${compra.getHora()}</p>

	<table>
		<tr>
			<th>Producto</th>
			<th>Precio por KG</th>
			<th>cantidad (KG)</th>
			<th>Coste (€)</th>
		</tr>

		<c:forEach items="${compra.getArts()}" var="item" varStatus="status">




			<tr>

				<td>${item.getArticulo()}</td>

				<td>${item.getPrecioKG()}</td>
				<td>${item.getCantidad()}</td>
				<td>${item.getCoste()}</td>
			</tr>




		</c:forEach>

	</table>
</body>
</html>