<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form method="post" action="ZonaUsuario">
	<input type="hidden" id="accion" name="accion" value="actualizaDatos">
  <input type="hidden" id="id" name="id" value="${userLoged.getK()}">

  <label for="nombre">Nombre: </label><br>
  <input type="text" id="nombre" name="nombre" value="${userLoged.getNombre()}"><br><br>
  
  <label for="apellido">Apellido:</label><br>
  <input type="text" id="apellido" name="apellido" value="${userLoged.getApellido()}"><br><br>
  
  <label for="email">Email: </label><br>
  <input type="text" id="email" name="email" disabled value="${userLoged.getEmail()}"><br><br>
  
  <label for="direccion">Dirección: </label><br>
  <input type="text" id="direccion" name="direccion" value="${userLoged.getDireccion()}"><br><br>
  
  <label for="telefono">Teléfono: </label><br>
  <input type="text" id="telefono" name="telefono" value="${userLoged.getTelefono()}"><br><br>
  
  
  
  
  <input type="submit" value="Envía tus nuevos datos!">
</form> 







</body>
</html>