<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="classes.*" %>
<%@ page import="classes.question.*" %>
<%@ page import="classes.question.Abstract.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript" src="/QuizWebsite/javascript/submitquestion.js"></script>
</head>
<body>
	<% 
	int questionID = Integer.parseInt(request.getParameter("id"));
	QuestionMC question = (QuestionMC) ((ArrayList<Question>) request.getSession().getAttribute("Questions")).get(questionID);
%>
	<h2><%= question.getProblem() %></h2>
	<form id="form"  onkeypress="return event.keyCode != 13;">
		<%	
			Set<String> ans = question.getAllAnswers();
			Iterator<String> it = ans.iterator();
			int i = 0;
			while(it.hasNext()){
				String choice = it.next();
				out.print("<input type='radio' id='answer" + i + "' name='answer0' value='" + choice +"'>" );
				out.print(choice + "<br>");
			}
		%>
	</form>
	<input id="submit" onclick="submit('<%= questionID %>')" type="hidden" />
</body>
</html>