<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="classes.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/profile.css">
<%

	String toppanel; 
	if (request.getSession().getAttribute("MasterUser") == null) toppanel = "toppanel-loggedout.jsp";
		else toppanel = "toppanel-loggedin.jsp";
	User masterUser = (User)request.getSession().getAttribute("MasterUser");
	User user = (User)request.getAttribute("User");
	String disabled = "";
	if (user.equals(masterUser)) disabled = "disabled";
%>
<title><% out.print(user.getUserName() + "'s Profile"); %></title>
</head>
<body>
	<div id="centerpanel">
		<img id="profileimage" src="<%=  %>">
		<span id="profilename"><%= user.getUserName() %></span>
		<span id="description"><%= user.getDescription() %></span>
		<a href="SendFriendRequest?getter=<%= user.getUserName() %>"  >
		<button id="addfriendb"  <%= disabled %>>
			<% 
				if (disabled.equals("disabled")) out.print("Already your friend!"); 
					else out.print("Add as a friend!"); 
			%>
		</button>
		</a>
		
		<%
			if (request.getSession().getAttribute("MasterUser")!=null && !user.equals(masterUser)) {
				out.println("<a href='CreateNote.jsp?getter=" + user.getUserName() + "'>");
				out.println("<button id='sendnote'>Send Note</button></a>");
			}
			
			if (masterUser.equals(user)){
				out.println("<button id='editdescr'>Edit Status</button>");
			}
		%>
		<div id="achievements">
			<%
				// achevements
			%>
		</div>
		
		<div id="friendslist">
			<div class="divtitle">Friends:</div>
			<div class="list">
			<%
				Set<String> friends = user.getFriends();
				for (String friend : friends){
					out.println("<a href=\"Profile?username=" + friend + "\" ><div class=\"listentry\">" + friend + "</div></a>");	
				}
			%>
			</div>
		</div>
		<div id="createdquizzes">
			<div class="divtitle">Created Quizzes:</div>
			<div class="list">
			<%
				List<Quiz> quizzes = (List<Quiz>)request.getAttribute("createdQuizzes");
				for (Quiz quiz : quizzes){ 
					out.println("<a href=\"Quiz?id=" + quiz.getId() + "\" ><div class=\"listentry\">" + quiz.getQuizName() + "</div></a>");	
				}
			%>
			</div>
		</div>
	</div>
	
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
</body>
</html>