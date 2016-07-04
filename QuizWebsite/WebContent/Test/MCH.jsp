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
		QuestionMCH question = (QuestionMCH) ((ArrayList<Question>) request.getSession().getAttribute("Questions")).get(questionID);
	%>
	
	<h2><%= question.getProblem() %></h2>
	<form id="form"  onkeypress="return event.keyCode != 13;">
		<%	
			List<String> left = question.getQuestions();
			List<String> right = question.getRightAnswers();
			right.addAll(question.getWrongAnswers());
			Collections.shuffle(right);
			out.print("<span id='leftt' style='display:inline;'>");
			int i = 0;
			for (String l : left) {
				out.print("<select name='answer" + i + "'>");
				for (int j=1;j<=right.size();j++){
					out.print("<option value='" + right.get(j-1) + "'>" + j + "</option>");
				}
				out.print("</select>");
				out.println("    " + l + "<br><br>");
				i++;
			}
			out.print("</span>");
			
			out.print("<span id='rightt'>");
			int k = 1;
			for (String r : right) {
				out.println(k + ")   " + r + "<br><br>");
				k++;
			}
			out.print("</span>");
		%>
	</form>
	<input id="submit" onclick="submitZ('<%= questionID %>')" type="hidden" />
	<script type="text/javascript">
		function submitZ(id){
			
			
			submit(id);
		}
	</script>
</body>
</html>