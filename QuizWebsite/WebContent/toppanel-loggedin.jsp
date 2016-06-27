<%@page import="Listeners.SessionListener"%>
<%@page import="classes.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/toppanel.css">
</head>
<body>

<%
	User masterUser = (User)session.getAttribute("MasterUser");
	String userName = masterUser.getUserName();
%>
	<div id="toppanel">
		<a href="index.jsp">
			<img id="i" src="images/qmark.png">
		</a>
		<span id="searchbar">
			<form id="searchform" action="Search" method="post">
				<input type="text" id="searchfield" placeholder="Search">
				<button type="submit" id="searchbutton">Search</button>
			</form>
		</span>
		 
		 <span id="loggedinbox">
		 	<p id="welcome"><% out.print("Welcome Home, " + userName); %></p>
		 	<div id="messagesbox">
		 		<button class="loggedinbuttons" id="messages">Messages</button>
				<div class="messages-dropdown">
					<a href="">Jandaba3</a>
					<a href="">Jandaba3</a>
					<a href="">Jandaba3</a>
				</div>
			</div>
			<div id="friendsbox">
				<button class="loggedinbuttons" id="friends">Friends</button>
				<div class="friends-dropdown">
					<a href="">Jandaba1</a>
					<a href="">Jandaba1</a>
					<a href="">Jandaba1</a>
				</div>
			</div>
			<div id="achievementsbox">
				<button class="loggedinbuttons" id="achievements">Achievements</button>
		 		<div class="achievements-dropdown">
					<a href="">Jandaba2</a>
					<a href="">Jandaba2</a>
					<a href="">Jandaba2</a>
				</div>
		 	</div>
		 	<form action="Logout" method="post" style="width: 0px;height:0px;display:inline-block;">
		 		<button class="loggedinbuttons" id="logout">Logout</button>
		 	</form>
		 </span>
	</div>
</body>
</html>