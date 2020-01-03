<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function()
	{
		$('select').formSelect();
	})
</script>
<body>

	<div class="container">
		<div class="card grey lighten-2">
			<div class="row">
				<h4 class="left col s6 l3">Add Contact</h4>
			</div>
			<div class="row">
				<form class="col s12" action="addcontact" method="post">
					<div class="row">
						<div class="input-field col m6 s12 ">
							<input id="contact_name" type="text" class="validate"
								name="contactname" required> <label for="contact_name">Contact
								Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col m6 s12">
							<input id="email" type="email" class="validate" name="email"
								required> <label for="email">Email</label><span
								class="helper-text"
								data-error="Wrong! Example: something@gmail.com"
								data-success="Alright!">Hint</span>
						</div>
					</div>
					<div class="row">
						<div class="input-field col m3 s6">
							<select name="countrycode">
								<option value="" disabled selected>Choose country code</option>
								<option value="+91">India (+91)</option>
								<option value="+1">USA (+1)</option>
								<option value="+61">Australia (+61)</option>
							</select> <label>Country code</label>
						</div>
						<div class="input-field col m3 s6">
							<input id="phone" type="text" class="validate" name="number"
								required> <label for="phone">Phone Number</label>
						</div>
					</div>
					<div class="row">
						<div class="col m1  s3">
							<p>Favourite:</p>
						</div>
						<div class="input-field col m3 s6">
							<div class="switch">
								<label>Off <input type="checkbox" value="1 " name="fav">
									<span class="lever"></span>On
								</label> <input type="hidden" value="0" name="fav">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s3">
							<button class="btn waves-effect waves-light" type="submit"
								name="action">
								Add Contact <i class="material-icons right">send</i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>