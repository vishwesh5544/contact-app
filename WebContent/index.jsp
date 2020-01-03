<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="controllers.DBConnection"%>
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

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>
<body>

	<%
		if (request.getSession(false) == null || session.getAttribute("email") == null) {
	%>
	<div class="container">
		<div class="card grey lighten-2">
			<h2>Welcome!</h2>
			<p>Hello there. Welcome to the Contact Management Project
				designed and developed by Vishwesh Shukla.</p>

			<p>You can add contacts, read them, delete them and update their
				data.</p>
			<p>
				To execute all the above mentioned, you will have to first <a
					href="link?ref=register">register</a> to this program.
			</p>
		</div>
	</div>

	<%
		} else if (session.getAttribute("email") != null) {
	%>


	<div class="container">
		<div class="row">

			<div class="col s12 l3 grey lighten-2">
				<h4 class="show-on-large hide-on-med-and-down">Recently Added</h4>
				<h5 class="show-on-medium-and-down hide-on-med-and-up">Recently
					Added</h5>
				<hr />
				<table class="highlight">
					<tbody>
						<tr>
							<%
								Connection con = null;
									PreparedStatement pstmt = null;
									String userid = session.getAttribute("userid").toString();

									try {
										Boolean empty = true;
										con = DBConnection.createConnection();
										pstmt = con.prepareStatement(
												"SELECT ContactName FROM (SELECT * FROM contacts WHERE ContactOf = ? ORDER BY ContactID DESC LIMIT 5) ContactID ORDER BY ContactID DESC");
										pstmt.setString(1, userid);
										ResultSet rs = pstmt.executeQuery();

										while (rs.next()) {
											String recentContactName = rs.getString("ContactName");
							%>
							<td><%=recentContactName%></td>
						</tr>
						<%
							empty = false;
									}
						%>

					</tbody>
				</table>
				<%
					if (empty) {
				%>

				<p class="flow-text red-text text-accent-4">*No recently added
					contacts</p>
				<%
					System.out.println("No recently added contacts found");
							} else {
								System.out.println("Recently added contacts retrieved");
							}
						} catch (Exception e) {
							e.printStackTrace();

						} finally {
							con.close();

						}
				%>
				<h4 class="show-on-large hide-on-med-and-down">Favourites</h4>
				<h5 class="show-on-medium-and-down hide-on-med-and-up">
					Favourites</h5>
				<hr class="show-on-medium-and-down hide-on-large" />
				<div id="favcontact">
					<table class="highlight">
						<tbody>
							<tr>
								<%
									try {

											Boolean empty = true;
											con = DBConnection.createConnection();
											pstmt = con.prepareStatement(
													"SELECT ContactName FROM contacts WHERE ContactOf = ? AND IsFavourite = 1");
											pstmt.setString(1, userid);
											ResultSet rs = pstmt.executeQuery();

											while (rs.next()) {
												String favContactName = rs.getString("ContactName");
								%>
								<td><%=favContactName%></td>
							</tr>
							<%
								empty = false;
										}
							%>
						</tbody>
					</table>

					<%
						if (empty) {
					%>
					<p class="flow-text red-text text-accent-4">*No favourite
						contacts found</p>
					<%
						System.out.println("No favourite contacts retrieved");
								} else {
									System.out.println("Favourite contacts retrieved");
								}
							} catch (Exception e) {
								e.printStackTrace();

							} finally {
								con.close();
							}
					%>
				</div>



			</div>
			<div class="col s12 l9 grey lighten-1">
				<h4 class="show-on-large hide-on-med-and-down">All contacts</h4>
				<h5 class="hide-on-med-and-up">My contacts</h5>
				<table class="highlight">
					<thead>
						<tr>
							<th>ContactID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Phone Number</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<%
								try {
										con = DBConnection.createConnection();
										Boolean empty = true;

										pstmt = con.prepareStatement("SELECT * FROM contacts WHERE ContactOf = ?");
										pstmt.setString(1, userid);
										ResultSet rs = pstmt.executeQuery();

										while (rs.next()) {
											String contactId = rs.getString("ContactID");
											String contactName = rs.getString("ContactName");
											String contactEmail = rs.getString("ContactEmail");
											String contactPhone = rs.getString("ContactPhone");
											String isFav = rs.getString("IsFavourite");
							%>
							<td><%=contactId%></td>
							<td><%=contactName%></td>
							<td><%=contactEmail%></td>
							<td><%=contactPhone%></td>
							<td><a href="#contact" class="btn z-depth-2"
								onclick="getUser('<%=contactId%>', '<%=contactName%>', '<%=contactEmail%>', '<%=contactPhone%>', '<%=isFav%>'); return false;">View
							</a></td>
						</tr>
						<%
							empty = false;

									}
						%>
					</tbody>
				</table>

				<%
					if (empty) {
								System.out.println("Zero contacts Retrieved");
				%>
				<p class="flow-text red-text text-accent-4">*No Contacts</p>
				<%
					} else {
								System.out.println("All contacts retrieved");
							}
						} catch (Exception e) {
							e.printStackTrace();

						} finally {
							con.close();

						}
				%>

				<a id="contact"></a>
				<div id="contactview" class="card-panel grey lighten-1 z-depth-4">
					<div class="row">
						<h5 id="contactname" class="col l3 left"></h5>
						<i class="material-icons small right"
							onclick="$('#contactview').hide();">cancel</i>
					</div>
					<div class="row">
						<div class="col l3">
							<h6 class="legend">Contact ID:</h6>
						</div>
						<div class="col l3">
							<p id="contactid"></p>
						</div>
					</div>
					<div class="row">
						<div class="col l3">
							<h6 class="legend">Email:</h6>
						</div>
						<div class="col l3">
							<p id="contactemail"></p>
						</div>
					</div>
					<div class="row">
						<div class="col l3">
							<h6 class="legend">Phone:</h6>
						</div>
						<div class="col l3">
							<p id="contactphone"></p>
						</div>
					</div>
					<div class="row">
						<div class="col l6" id="favbox"></div>
					</div>
					<div class="row">
						<div class="col l6" id="removeText"></div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<%
		}
	%>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#contactview').hide();
		$('.refreshButton').click(function() {
			$('#favcontact').load(" #favcontact");
		});
	});

	var contactId;

	function getUser(contactid, contactname, contactemail, contactphone, isfav) {

		$('#contactview').show();
		$('.legend').css('font-weight', 'bold');
		$('#contactname').html(contactname);
		$('#contactid').html(contactid);
		$('#contactemail').html(contactemail);
		$('#contactphone').html(contactphone);
		$('#removeText')
				.html(
						"<a href='#!' onclick='removeContact(); return false;' class='red-text'>Remove contact?</a>");

		contactId = contactid

		if (isfav == 1) {
			var html = "Marked as favourite. <a href='#!' onclick='notFav()'>Not favourite?</a>"
			$('#favbox').html(html);
		} else {
			var html = "Not marked as favourite. <a href='#!' onclick='fav()'>Mark as favourite?</a>"
			$('#favbox').html(html);
		}
	}

	function notFav() {
		var confirmNotFav = confirm("Confirm marking as not favourite?");

		if (confirmNotFav == 1) {
			$
					.ajax({
						url : 'NotFav',
						type : 'post',
						data : {
							contactid : contactId
						}
					})
					.done(
							function() {
								var html = "Not marked as favourite. <a href='#!' onclick='fav(); return false;'>Mark as favourite?</a>";
								var contactid = contactId;
								$('#favbox').html(html);
								$('#favcontact').load(" #favcontact");
								location.reload();
							});

		}
	}

	function fav() {
		var confirmFav = confirm("Confirm marking as favourite?");

		if (confirmFav == 1) {
			$
					.ajax({
						url : 'Fav',
						type : 'post',
						data : {
							contactid : contactId
						}
					})
					.done(
							function() {
								var html = "Marked as favourite. <a href='#!' onclick='notFav(); return false;'>Not favourite?</a>"
								$('#favbox').html(html);
								$('#favcontact').load(" #favcontact");
								location.reload();
							});
		}
	}

	function removeContact() {
		var removeContact = confirm("Are you sure you want to remove this contact?");

		if (removeContact == 1) {

			$.ajax({
				url : 'RemoveContact',
				type : 'post',
				data : {
					contactid : contactId
				}
			}).done(function() {
				location.reload();
			})

		}
	}
</script>
</html>