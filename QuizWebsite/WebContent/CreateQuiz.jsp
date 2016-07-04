<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="classes.question.Abstract.Question" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/createquiz.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript" src="javascript/createquiz.js"></script>
<title>Quiz Creation</title>
</head>
<body>
<%
	String toppanel;
	if (request.getSession().getAttribute("MasterUser") == null) toppanel = "toppanel-loggedout.jsp";
	else toppanel = "toppanel-loggedin.jsp";
	
	request.getSession().setAttribute("createdQuestions", new ArrayList<Question>());
%>
	<div id="centerpanel">j
		<form id="infoform" action="CreateQuiz" method="post">
			<input type="text" id="name" name="name" Placeholder="  Quiz Name"> <br> <br>
			<textarea cols="60" rows="4" name="description" id="desc" Placeholder=" Description"></textarea> <br> <br> 
			Random?              :<input type="checkbox" id="random" name="random"> <br>
			Display on One Page? :<input type="checkbox" id="onepage" name="onepage"> <br>
			Practice mode?       :<input type="checkbox" id="practice" name="practice"> <br>
			Immediate Correction?: <input type="checkbox" id="imcorr" name="correction"> <br> <br>
			Max Time: <input type="text" id="time" name="time">minutes <br> <br> <br> <br>
		</form>
		<div id="questions"></div>
	</div>
	<div id="bottompanel">
		<button class="questionbuttons" onclick="addQuestion('CreateFB')">Fill in the Blanks</button>
		<button class="questionbuttons" onclick="addQuestion('CreateMA')">Multiple Answer</button>
		<button class="questionbuttons" onclick="addQuestion('CreateMC')">Multiple Choice</button>
		<!--  <button class="questionbuttons" onclick="addQuestion('CreateMCH')">Matching</button> -->
		<button class="questionbuttons" onclick="addQuestion('CreateMCMA')">Multi-Choice Multi-Answer</button> 
		<button class="questionbuttons" onclick="addQuestion('CreatePR')">Picture-Response</button> 
		<button class="questionbuttons" onclick="addQuestion('CreateQR')">Question-Response</button> 
	
		<button id="submitbutton" onclick="submitQuiz();">Submit Quiz</button>
	</div>
	
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
	
</body>
</html>