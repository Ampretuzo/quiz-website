<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/toppanel.css">
</head>
<body>
	<div id="toppanel">
		<a href="index">
			<img id="i" src="images/qmark.png">
		</a>
		<span id="searchbar">
			<form id="searchform" action="Search" method="post">
				<input type="text" id="searchfield" placeholder="Search">
				<button type="submit" id="searchbutton">Search</button>
			</form>
		</span>
		
		<span id="loginbox">
			<form  id="loginform" action="Login" method="post">
				Login:
				<input type="text" id="username" name="username" placeholder="Username">
				<input type="password" id="password" name="password" placeholder="Password">
				<input class="button" type="submit" id="submit" value="Login">
			</form>
		</span>
		<span id="signupbox">
			Not a member yet?
			<input type="submit" id="signupbutton" class="button" value="Sign Up" 
					onclick="signUp()">
		</span>
	
		 
	</div>
	<script> function signUp(){ window.location = "signup.jsp";} </script>
</body>
</html>