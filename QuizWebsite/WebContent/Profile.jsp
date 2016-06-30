<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="classes.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/profile.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript" src="javascript/addfriend.js"></script>
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
		<img id="profileimage" src="<%= "asd" %>">
		<span id="profilename"><%= user.getUserName() %></span>
		<span id="description"><%= user.getDescription() %></span>
		<button id="addfriendb"  onclick="addFriend('<%= user.getUserName() %>')" <%= disabled %>>
			<% 
				if (disabled.equals("disabled")) out.print("Already your friend!"); 
					else out.print("Add as a friend!"); 
			%>
		</button>
		
		<%
			if (request.getSession().getAttribute("MasterUser")!=null && !user.equals(masterUser)) {
				out.println("<a href='CreateNote.jsp?getter=" + user.getUserName() + "'>");
				out.println("<button id='sendnote'>Send Note</button></a>");
			}
			
			if (user.equals(masterUser)){
				out.println("<a href='EditDescription?username=" + masterUser.getUserName() + "'><button id='editdescr'>Change Status</button></a>");
				out.println("<a href='EditImage?username=" + masterUser.getUserName() + "'><button id='editpic'>Change Picture</button></a>");
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
			<%/*
				List<Quiz> quizzes = (List<Quiz>) request.getAttribute("createdQuizzes");
				for (Quiz quiz : quizzes){ 
					out.println("<a href=\"Quiz?id=" + quiz.getId() + "\" ><div class=\"listentry\">" + quiz.getQuizName() + "</div></a>");	
				}*/
			%>
			</div>
		</div>
	</div>
	<!-- 
	<div id="secondbox">
			<span id="friendsactivity">
				<div class="divtitle">Friends Activity</div>
				<div class="list">
				<%
					
				%>
				</div>
			</span>
			<span class="quizzes" id="recentlytakenquizzes">
				<div class="divtitle">Recently Taken Quizzes</div>
				<div class="list">
				<%
					
				%>
				</div>
			</span>
			<span class="quizzes" id="recentlycreatedquizzes">
				<div class="divtitle">Recently Created Quizzes</div>
				<div class="list">
				<%
					
				%>
				</div>
			</span>
			
			<% 
				if (request.getSession().getAttribute("MasterUser") == null){
					out.println("<span id=\"loginlabel\">Log In to See More!</span>");		
				}
			%>
			
		</div>
	 -->
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
</body>
</html>