<%@page import="Listeners.SessionListener"%>
<%@page import="classes.User"%>
<%@page import="dao.*"%>
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
	MessageDAO resultDao = (MessageDAO)request.getServletContext().getAttribute("messageDAO");
	int unseenN = resultDao.numUnseenNotes(userName);
	int unseenC = resultDao.numPendingChallenges(userName);
	int unseenF = resultDao.numPendingFriendRequests(userName);
	
%>
	<div id="toppanel">
		<a href="index">
			<img id="i" src="images/qmark.png">
		</a>
		<span id="searchbar">
				<input type="text" id="searchfield" name="search" placeholder="Search">
				<button type="submit" id="searchquiz" onclick="searchQuiz()">Search Quiz</button>
				<button type="submit" id="searchprofile" onclick="searchProfile()">Search Profile</button>
		</span>
		 
		 <span id="loggedinbox">
		 	<p id="welcome"><% out.print("Welcome Home, " + userName); %></p>
		 	<form id="messagebox" action="Messages" method="get">
		 		<button class="loggedinbuttons" id="notes" style='background:<% if (unseenN>0) out.print("red"); %>'>Notes<% if (unseenN>0) out.print(" (" +  unseenN + ")");%></button>
				<button class="loggedinbuttons" id="challenges" style='background:<% if (unseenC>0) out.print("red"); %>'>Challenges<% if (unseenC>0) out.print(" (" +  unseenC + ")");%></button>
			<button class="loggedinbuttons" id="friendrequests" style='background:<% if (unseenF>0) out.print("red"); %>'>Friend Requests<% if (unseenF>0) out.print(" (" +  unseenF + ")");%></button>
			</form>
		 	<form action="Logout" method="post">
		 		<button class="loggedinbuttons" id="logout">Logout</button>
		 	</form>
		 </span>
	</div>
	
	<script type="text/javascript">
		function searchProfile(){
			window.location = "Profile?username=" + document.getElementById("searchfield").value;
		}
		function searchQuiz(parameter){
			window.location = "Quiz?quizname=" + document.getElementById("searchfield").value;
		}
	</script>
</body>
</html>