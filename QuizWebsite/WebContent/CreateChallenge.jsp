<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="classes.*" %>
    <%@ page import="dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/createmessages.css">
<title></title>
</head>
<body>	
<%
		String toppanel; 
		if (request.getSession().getAttribute("MasterUser") == null) toppanel = "toppanel-loggedout.jsp";
		else toppanel = "toppanel-loggedin.jsp";
	%>
	<div id="centerpanel">
	<div id="field">
	<form action="SendChallenge" method="post">
		<input type="hidden" name="quizId" value='<%= request.getParameter("quizId") %>'>	
		Choose Friends to Send a Challenge to: <br> <br>
		<div id="friends">
			<%
				User me = (User) request.getSession().getAttribute("MasterUser");
				
				Set<String> friends = ((UserDAO) request.getServletContext().getAttribute("userDAO")).getFriends(me.getUserName());
				int i =0;
				
				for (String friend : friends){
					if (friend != null){
						out.println("<input type='checkbox' name='" + i + "' value='" + friend + "'> <a href='Profile?username='>" + friend + "</a> <br>");
						i++;
					}
					
				}
			%>
		</div>
		<br>
		<input type="submit" id="send" value="Send">
	</form>
	</div>
	</div>
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
	
</body>
</html>