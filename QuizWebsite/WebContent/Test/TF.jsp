<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="classes.*" %>
<%@ page import="classes.question.*" %>
<%@ page import="classes.question.Abstract.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Main.*" %>
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
		QuestionTF question = (QuestionTF) ((ArrayList<Question>) request.getSession().getAttribute("Questions")).get(questionID);
	%>
	<h2><%= question.getProblem() %></h2>
	<form id="form"  onkeypress="return event.keyCode != 13;">
		<%	
			List<String> prop = question.getPropositions();
			int i = 0;
			for (String s : prop){
				out.print(s); 
				out.print("<input type='radio' name='answer" + i + "' checked value='True' />True");
				out.print("<input type='radio' name='answer" + i + "' value='False' />False");
				out.print("<br>");
				i++;
			}
		%>
	</form>
	<input id="submit" onclick="submit('<%= questionID %>')" type="hidden" />
</body>
</html>