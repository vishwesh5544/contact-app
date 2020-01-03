<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>

<body>
	<div class="container">
		<div class="card grey lighten-2">
			<div class="row">
				<h4 class="left col s3">Login</h4>
			</div>
			<div class="row">
				<form class="col s12" action="login" method="post">
					<div class="row">
						<div class="input-field col s12 l6">
							<input id="email" type="email" class="validate" name="email"
								required> <label for="email">Email</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12 l6">
							<input type="password" class="validate" name="password" required>
							<label for="password">Password</label>
							<p id="checker1"></p>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s3">
							<button class="btn waves-effect waves-light" type="submit"
								name="action">
								Login <i class="material-icons right">lock</i>
							</button>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>