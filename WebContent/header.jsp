<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="controllers.DBConnection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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

	<%
		if (request.getSession(false) == null || session.getAttribute("email") == null) {
	%>

	<nav>
		<div class="nav-wrapper blue-grey darken-3">
			<a href="index.jsp" class="brand-logo">Contacts App</a> <a href="#"
				data-target="mobile-demo" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">
				<li><a href="link?ref=home">Home</a></li>
				<li><a href="link?ref=login">Login</a></li>
				<li><a href="link?ref=register">Register</a></li>
			</ul>
		</div>
	</nav>

	<ul class="sidenav" id="mobile-demo">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="link?ref=login">Login</a></li>
		<li><a href="link?ref=register">Register</a></li>
	</ul>

	<%
		} else if (session.getAttribute("email") != null) {
	%>



	<ul id="user-dropdown" class="dropdown-content">
		<li><a href="link?ref=add-contact">Add Contact</a></li>
		<li><a class="modal-trigger" href="#modal1">Settings</a></li>
		<li class="divider"></li>
		<li><a href="#" onclick="Logout(); return false;">Logout</a></li>
	</ul>
	<nav>
		<div class="nav-wrapper blue-grey darken-3">
			<a href="index.jsp" class="brand-logo">Contacts App</a> <a href="#"
				data-target="mobile-demo" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">
				<li><a href="link?ref=home">Home</a></li>
				<li><a class="dropdown-trigger" href="#!"
					data-target="user-dropdown">Hi, <%=session.getAttribute("firstname")%><i
						class="material-icons right">arrow_drop_down</i></a></li>
			</ul>
		</div>
	</nav>

	<ul class="sidenav" id="mobile-demo">
		<li><a href="#!">Hello, <%=session.getAttribute("firstname")%></a></li>
		<li class="divider"></li>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="link?ref=add-contact">Add Contact</a></li>
		<li><a class="modal-trigger" href="#modal1">Settings</a></li>
		<li class="divider"></li>
		<li><a href="#" onclick="Logout(); return false;">Logout</a></li>
	</ul>


	<%
		}
	%>
	<div id="modal1" class="modal">
		<div class="modal-content">
			<div class="row">
				<h4 class="left">Profile Settings</h4>
				<i class="right material-icons modal-close">close</i>
			</div>

			<%
				try {
					Boolean empty = true;
					Connection con = DBConnection.createConnection();

					PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE UserID = ?");
					pstmt.setString(1, session.getAttribute("userid").toString());

					ResultSet rs = pstmt.executeQuery();

					String firstname, lastname, phone = null;
					while (rs.next()) {
						firstname = rs.getString("firstname");
						lastname = rs.getString("lastname");
						empty = false;
			%>
			<div class="row">
				<form action="UserUpdate" method="post" id="update_form">
					<div class="row">
						<div class="col	s6 m6 l6">
							<input type="text" placeholder="<%=firstname%>" name="firstname">
						</div>
						<div class="col s6 m6 l6">
							<input type="text" placeholder="<%=lastname%>" name="lastname">
						</div>
					</div>
					<div class="row">
						<div class="col s12 m12 l12">
							<input type="email"
								placeholder="<%=session.getAttribute("email")%>" name="email">
						</div>
					</div>
					<div class="row">
						<div class="col l12">
							<h6>Change password:</h6>
						</div>
					</div>
					<div class="row">
						<div class="col l6">
							<input type="password" placeholder="Enter new password"
								name="pwd">
						</div>
						<div class="col l6">
							<input type="password" placeholder="Confirm new password"
								name="cpwd">
						</div>
					</div>
					<div class="row">
						<div class="col l6">
							<input type="submit" class="btn" value="update">
							<!-- Start from here. -->
						</div>
					</div>
				</form>
			</div>

			<%
				}

					if (empty) {

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</div>
	</div>

</body>

<script type="text/javascript">
	$(document).ready(function() {
		$(".dropdown-trigger").dropdown({
			hover : true
		});

		$('.sidenav').sidenav();

		$('.modal').modal();
	});

	function Logout() {
		var logout = confirm("Are you sure you want to logout?");

		if (logout) {
			location.href = "logout";
		}
	}
</script>
</html>