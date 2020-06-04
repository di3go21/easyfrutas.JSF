<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

</head>

<body>

			<h1>Bienvenido a EASYFRUTAS.ES</h1>
			
			
			
			
				<ul>
					<li><a href="HOME">Inicio</a></li>
					<li><a href="ZonaUsuario?accion=verCarrito">Ver Carrito</a></li>
					<c:choose>
						<c:when test="${userLoged.getK() > '0' }">
							<li><a href="Login?action=logout">log OUT</a></li>
							<li><a href="ZonaUsuario?accion=personal">area personal!</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="Login?action=login">Log In</a></li>
							<li><a href="Registro?action=nuevoReg">REGÍSTRATE!!</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			
	

		
		<form method="get" action="buscar">
				<input type="text" name="busqueda" required	placeholder="Buscar fruta...">
			
			<button type="submit" >Buscar</button>
		</form>

		<div>
			<h2>${userLoged.getNombre()} ¡PIDE TU FRUTITA
				BUENA!</h2>
			
			<p >
				Bienvenido, aquí podrás encontrar la mejor frutita para el consumo
				diario. Haz clic en una fruta para ver sus características. No dudes
				en preparar tu pedido para tener tu fruta lista en la puerta de tu
				casa! Cualquier duda no dudes en ponerte en contacto con nosotros!
			
			<p>
		</div>
		
		<h1>Regístrate para poder añadir cosas a tu carrito!!</h1>

		<h1 class="text-center">FRUTAS</h1>

	

			<c:forEach items="${listaProductos}" var="producto"
				varStatus="status">

				<div style="float: left; margin: 10px 10px;" >
					<h3 >${producto.getNombre()}</h3>
					<p >Precio ${producto.getPrecio()} €/Kg</p>
					<p >Stock: ${producto.getStock()} Kg</p>
					
						<a href="Producto?action=ver&id=${producto.getK()}">Ver
							Detalles</a>
					<form method="get" action="ZonaUsuario">
					<label for="cantidad"></label>
						<input type="hidden" name="accion" value="addProd">
						<input type="hidden" name="idprod" value="${producto.getK()}">
						<input type="number" value="0.5" id="cantidad" step="0.01"  name="cantidad" min="0.5" max="${producto.getStock()}">
						<input type="submit" value="añade a la cesta!">
					</form>
					
					
				</div>

			</c:forEach>

		
		

</body>
</html>