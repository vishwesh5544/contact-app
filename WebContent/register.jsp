<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<script src="js/passwordchecker.js"></script>
<body>
	<div class="container">
		<div class="card grey lighten-2">
			<div class="row">
				<h4 class="left col s3">Register</h4>
			</div>
			<div class="row">
				<form class="col s12" action="register" method="post">
					<div class="row">
						<div class="input-field col s6">
							<input id="first_name" type="text" class="validate"
								name="firstname" required> <label for="first_name">First
								Name</label>
						</div>
						<div class="input-field col s6">
							<input id="last_name" type="text" class="validate"
								name="lastname" required> <label for="last_name">Last
								Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="email" type="email" class="validate" name="email"
								required> <label for="email">Email</label><span
								class="helper-text"
								data-error="Wrong! Example: something@gmail.com"
								data-success="Alright!">Hint</span>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="password" class="validate" id="pass1"
								onkeyup="checkStrength(); return false;" name="pwd1" required>
							<label for="password">Password</label>
							<p id="checker1"></p>
						</div>

						<div class="input-field col s6">
							<input type="password" class="validate" id="pass2"
								onkeyup="checkMatch(); return false;" name="pwd2" required>
							<label for="password">Confirm Password</label>
							<p id="checker2"></p>
						</div>

					</div>
					<div class="row">
						<div class="input-field col s3">
							<button class="btn waves-effect waves-light" type="submit"
								name="action">
								Submit <i class="material-icons right">send</i>
							</button>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>