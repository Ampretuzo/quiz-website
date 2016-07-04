<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="classes.*" %>
<%@ page import="java.util.*" %>
<%@ page import="classes.question.Abstract.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/quizpages.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript" src="javascript/submitquiz.js"></script>
<%
	Quiz quiz = (Quiz) request.getSession().getAttribute("Quiz");
	int size = ((List<Question>) request.getSession().getAttribute("Questions")).size();
%>
<title><%= quiz.getQuizName() %></title>
</head>
<body>
	<div id="toppanel">
		<span id="quizname"><%= quiz.getQuizName() %></span>
		<span id="clock">
			<span id="hours"></span>hours,
			<span id="mins"></span>mins and 
			<span id="secs"></span>secs remaining
		</span>
	</div>
	
	<div id="bottompanel">
		<button id="submitquiz" onclick="submitQuiz();">Submit Quiz</button>
	</div>
	
	<div id="centerpanel">
	<br>
<%	
	for (int i=0;i<size;i++){
		out.print("<iframe name='question" + i + "' src='Question?id=" + i + "' id='" + i + "' ></iframe>");
		out.print("<br><br>");
	}
%>

	</div>
	<input type="hidden" id="timeleft" value="<%= quiz.getQuizTime() %>">
	<input type="hidden" id="num" value="<%= size %>">
	
	<script type="text/javascript">
		var remaining = 60*1000 * document.getElementById("timeleft").value;
		var startTime = new Date().getTime();
	</script>
</body>
</html>