<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h2>Question?</h2>
	<%
		Integer num = 5;
		for (int i=0;i<num;i++){
			out.println("<input type=\"checkbox\" name=\"answer\" id=\"" +  i + "\">");
			out.print("<br><br>");
		}
		out.print("<input type=\"submit\" style=\"display: none;\">");
	%>
</body>
</html>