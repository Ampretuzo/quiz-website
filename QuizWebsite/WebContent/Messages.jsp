<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="classes.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/messages.css">
<title>Messages</title>
</head>
<body>
	<%
		String toppanel; 
		if (request.getSession().getAttribute("MasterUser") == null) toppanel = "toppanel-loggedout.jsp";
		else toppanel = "toppanel-loggedin.jsp";
		User user = (User) session.getAttribute("MasterUser");
		
	%>
	<div id="centerpanel">
		<div id="notebox">
			<div class="noteSeen">
				FROM: <br>
				NOTE: ra jandaba ginda to?
			</div>
			<div class="note">
				
			</div>
		</div>
		<div id="friendrequestbox">
			<div class="requestSeen">
				
			</div>
			<div class="request">
				
			</div>
		</div>
		<div id="challengebox">
			<div class="challengeSeen">
				
			</div>
			<div class="challenge">
				
			</div>
		</div>
	</div>
	
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
</body>
</html>