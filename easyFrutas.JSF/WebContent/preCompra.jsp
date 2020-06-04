<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.Numero"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>esta será tu compra:</p>

	datos de envío:
	<br> Destinatario: ${userLoged.getNombre()}
	${userLoged.getApellido()}
	<br> Direccion ${userLoged.getDireccion()}
	<br> Telefono ${userLoged.getTelefono()}
	<br> Artículos:
	<br>

	<table>
		<tr>
			<th>Producto</th>
			<th>Cantidad</th>
			<th>Precio</th>
		</tr>



<c:set var="count" value="0.0" scope="page" />




		<c:forEach items="${carrito.getCarrito()}" var="entry">
			<c:forEach items="${listaProductos}" var="producto"
				varStatus="status">
				<c:if test="${entry.key==producto.getK()}">
					<c:set var="count" value="${count + Numero.dosDecimales(producto.getPrecio()*entry.value)}" scope="page"/>
					<tr>
						<td>${producto.getNombre()}</td>
						<td>${entry.value}</td>
						<td>${Numero.dosDecimales(producto.getPrecio()*entry.value)}</td>
						
					</tr>
					
					
				</c:if>
			</c:forEach>

		</c:forEach>
		<tr>
						<td>Total</td>
						<td></td>
						<td>${Numero.dosDecimales(count)}</td>
					</tr>

	</table>

	<button onclick="window.location.href='ZonaUsuario?accion=okCompra'">Confirma
		Compra</button>




</body>
</html>