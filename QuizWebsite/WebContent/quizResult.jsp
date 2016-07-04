<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="classes.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Results</title>
</head>
<body>
	<%
		Result result = (Result) request.getAttribute("Result");
		Quiz quiz = (Quiz) request.getAttribute("Quiz");
	%>
	<h1>Your Score: <%= result.getFinalGrade() %>/<%= quiz.getMaxScore() %> </h1>
	<h2>Time Taken: <%= result.getTimeTaken()/(1000*60) %>mins</h2>
	
	<%
		if (session.getAttribute("Challenger")!=null) out.print("<h2>" +session.getAttribute("Challenger") + "'s Hight Score was: " +
				session.getAttribute("ChallengerScore") + "/" + quiz.getMaxScore()  +" </h2>");
	%>
</body>
</html>