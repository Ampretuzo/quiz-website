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
			<input type="text" id="searchfield" name="search" placeholder="Search">
				<button type="submit" id="searchquiz" onclick="searchQuiz()">Search Quiz</button>
				<button type="submit" id="searchprofile" onclick="searchProfile()">Search Profile</button>
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
	
	<script type="text/javascript">
		function signUp(){ window.location = "signup.jsp";} 
		function searchProfile(){
			window.location = "Profile?username=" + document.getElementById("searchfield").value;
		}
		function searchQuiz(parameter){
			window.location = "Quiz?quizname=" + document.getElementById("searchfield").value;
		}
		</script>
</body>
</html>