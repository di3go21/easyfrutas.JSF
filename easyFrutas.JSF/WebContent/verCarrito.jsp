<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.Numero"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<c:forEach items="${carrito.getCarrito()}" var="entry">
		<c:forEach items="${listaProductos}" var="producto" varStatus="status">
			<!-- ${entry.key} ------    ${entry.value} <br> -->
			<c:if test="${entry.key==producto.getK()}">

				<p>producto ${producto.getNombre()} cantidad ${entry.value} kg
					precio ${Numero.dosDecimales(producto.getPrecio()*entry.value)}</p>
			</c:if>
		</c:forEach>

	</c:forEach>


	<c:if test="${empty userLoged.getK()}">
		Logueate para recuperar tu antiguo carrito!
	</c:if>
	
	
	
<button onclick="window.location.href='ZonaUsuario?accion=preCompra'">ir a precompra</button>


</body>
</html>