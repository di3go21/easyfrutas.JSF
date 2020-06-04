<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Logueate en easyfrutas!</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="Signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<form class="form-signin" method="POST" action="Login">
		<img class="mb-4" src="/img/logoEF.png" alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Introduce tus datos!</h1>
		<label for="inputEmail" class="sr-only">Email</label> <input
			type="email" id="inputEmail" class="form-control" name="email"
			placeholder="Email address" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword" class="form-control"
			placeholder="Password" name="password" required>
		<div class="checkbox mb-3">
			<p class="text-danger">
				<c:if test='${logFailed.length() >0}'>
				Email o contraseña incorrecto
				</c:if>
			</p>
			<label> <input type="checkbox" value="remember-me">
				Recuerda email
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted"></p>
	</form>
</body>
</html>