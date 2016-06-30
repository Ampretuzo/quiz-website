<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Main.*" %>

<%@ page import="classes.*" %>
<%@ page import="classes.Message.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<title><% out.print("Welcome to " + Constants.SITE_NAME); %></title>
</head>
<body>
	<%
		String toppanel; 
		if (request.getSession().getAttribute("MasterUser") == null) toppanel = "toppanel-loggedout.jsp";
		else toppanel = "toppanel-loggedin.jsp";
	%>
	
	
	<div id="centerpanel">
		
			<span id="announcements">
				<div class="divtitle">Announcements</div>
				<div class="list">
				<% 
					List<Announcement> ann = (List<Announcement> )request.getAttribute("Announcements");
					for (int i=0;i<ann.size();i++){
						out.println("<div class=\"listentry\" onclick=\"alert('" + ann.get(i).getAnnouncement() + "');\">" + ann.get(i).getAnnouncement() + "</div>");	
					}
				%>
				</div>
			</span>
			<span class="quizzes" id="recentquizzes">
				<div class="divtitle">Recent Quizzes</div>
				<div class="list">
				<%
					List<Quiz> quizzes = (List<Quiz> )request.getAttribute("RecentQuizzes");
					for (int i=0;i<quizzes.size();i++){
						out.println("<div class=\"listentry\"><a href='Quiz?id="+ quizzes.get(i).getId() + "'>" + quizzes.get(i).getQuizName() + "</a></div>");	
					}
				%>
				</div>
			</span>
			<span class="quizzes" id="popularquizzes">
				<div class="divtitle">Popular Quizzes</div>
				<div class="list">
				<%
					quizzes = (List<Quiz> )request.getAttribute("PopularQuizzes");
					for (int i=0;i<quizzes.size();i++){
						out.println("<div class=\"listentry\"><a href='Quiz?id="+ quizzes.get(i).getId() + "'>" + quizzes.get(i).getQuizName() + "</a></div>");	
					}
				%>
				</div>
			</span>
		<%
			if (request.getSession().getAttribute("MasterUser") != null){
				out.println("<a href=\"CreateQuiz.jsp\"><button id=\"createaquiz\">Create a Quiz!</button></a>");		
			}
		%>
		
	</div>
	
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
</body>
</html>