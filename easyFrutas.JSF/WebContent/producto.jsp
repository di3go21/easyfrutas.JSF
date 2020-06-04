<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>producto indivivual</title>
</head>
<body>
el producto es

${prodInd.getK()}

${prodInd.getNombre()}
${prodInd.getPrecio()}
<form method="get" action="ZonaUsuario">
					<label for="cantidad"></label>
						<input type="hidden" name="idprod" value="${prodInd.getK()}">
						<input type="hidden" name="accion" value="addProd">
					
						<input type="number" value="0.5" id="cantidad" step="0.01"  name="cantidad" min="0.5" max="${prodInd.getStock()}">
						<input type="submit" value="añade a la cesta!">
					</form>

</body>
</html>