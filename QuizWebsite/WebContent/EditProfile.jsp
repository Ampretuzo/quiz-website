<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="classes.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/editprofile.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<title>Edit Your Profile</title>
</head>
<body>
	<%
		String toppanel; 
		User master = (User) request.getSession().getAttribute("MasterUser");
		if (master == null) toppanel = "toppanel-loggedout.jsp";
		else toppanel = "toppanel-loggedin.jsp";
	%>
	

	<div id="centerpanel">
	<div id="left">
	<form id="edit" action="EditProfile" method="post" onkeypress="return event.keyCode != 13;">
		Edit Profile Info: <br>
		<input name="imageURL" id="url" type="text" value=<%= master.getImage() %>> <br>
		<textarea name="description" rows="6" cols="60" value=<%= master.getDescription() %>></textarea> <br>
		Change Password? <input type="checkbox" id="change" name="changepassword"> <br>
		<input type="password" id="oldpass"  name="oldpass" Placeholder="Old Password"> <br>
		<input type="password" id="newpass" name="newpass" Placeholder="New Password"> <br>
		<input type="password" id="newpass2" Placeholder="Re-enter New Password"> <br>
		<input type="submit" id="subm" value="Change Info">
	</form>
	</div>
	</div>
	
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
	
	<script type="text/javascript">
		function checkPass(){
			if (document.getElementById("oldpass").value.length == 0){
				alert("Enter Old Password!");
				return false;
			} else {
				var k = false;
				$.ajax({
					async: false,
					url: "CheckPassword",
					type: "POST",
					data: {
						password: document.getElementById("oldpass").value,
					},
					success: function(data){
						if (data.trim() == "NO") k = true;
					}
				});
				if (k) {
					alert("Old Password Doesn't Match!");
					return false;
				}
			}
			if (document.getElementById("newpass").value.length == 0){
				alert("Enter New Password!");
				return false;
			}
			if (document.getElementById("newpass").value != document.getElementById("newpass2").value) {
				alert("Re-enter Password Correctly!");
				return false;
			}
			return true;
		}
		document.getElementById("edit").addEventListener("submit", function(event){
		   	if (document.getElementById("change").checked) {
		   		if (!checkPass()) event.preventDefault();
		   	}
		});
	</script>
	
</body>
</html>