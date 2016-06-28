<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="classes.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/quiz.css">
<%

	String toppanel; 
	if (request.getSession().getAttribute("MasterUser") == null) toppanel = "toppanel-loggedout.jsp";
		else toppanel = "toppanel-loggedin.jsp";
	
	Quiz quiz = (Quiz)request.getSession().getAttribute("Quiz");
%>
<title><%= quiz.getQuizName() %></title>
</head>
<body>
	<div id="centerpanel">
		<span id="qname"><%= quiz.getQuizName() %></span>
		<span id="qdescription"><%= quiz.getDescription() %></span>
		<span id="qauthor"><a href='Profile?username=<%= quiz.getUserName() %>'>Author: <%= quiz.getUserName() %></a></span>
		<%
			if (quiz.getUserName().equals(request.getSession().getAttribute("MasterUser"))){
				out.print("<button id='editdescr'>Edit Description</button>");
			}
		%>
		
		<div id="topscores">
			<div class="divtitle">Top Scores:</div>
			<div class="inf">
			<span class="usrname">Username</span>
			<span class="scr">Score</span>
			<span class="timetaken">Time</span>
			</div>
			<div class="list">
			<%
				out.println("<div class=\"listentry\">");
				out.println("<span class='profile'> <a href=\"Profile?username=" + 1 + "\" >" + "jandaba" + "</a></span>");
				out.println("<span class='score'>" + 5 + "</span>");
				out.println("<span class='time'>" + 5 + "</span>");
				out.println("</div>");
			%>
			</div>
		</div>
		<div id="recentscores">
			<div class="divtitle">Recent Scores:</div>
			<div class="inf">
			<span class="usrname">Username</span>
			<span class="scr">Score</span>
			<span class="timetaken">Time</span>
			</div>
			<div class="list">
			<%
				
			%>
			</div>
		</div>
		
		<form action="TakeQuiz" method="post">
			<input name="id" value='<%= quiz.getId() %>'>
			<button id="startquiz">Start Quiz</button>
		</form>
	</div>
	
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
</body>
</html>