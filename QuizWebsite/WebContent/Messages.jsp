<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="classes.*" %>
    <%@ page import="dao.*" %>
    <%@ page import="classes.Message.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/messages.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<title>Messages</title>
</head>
<body>
	<%
		String toppanel; 
		if (request.getSession().getAttribute("MasterUser") == null) toppanel = "toppanel-loggedout.jsp";
		else toppanel = "toppanel-loggedin.jsp";
		User user = (User) session.getAttribute("MasterUser");
		QuizDAO qD = (QuizDAO) request.getServletContext().getAttribute("quizDAO");
	%>
	<div id="centerpanel">
		<div id="notebox">
		<div class="title">Notes:</div>
			
			<%
				List<Note> notes = (List<Note>)request.getAttribute("Notes");
				for (int i=0;i<notes.size();i++){
					String seen = "noteSeen";
					if (!notes.get(i).isSeen()) seen = "note";
					out.print("<div id='Note" + notes.get(i).getId() + "'  class='" + seen + "' onclick=\"alert('" + notes.get(i).getNote() + "'); seen('" + notes.get(i).getId() +"'); \">");
					out.print("<div class='from'>FROM: " + notes.get(i).getSenderUserName() + " TO: " + notes.get(i).getGetterUserName() + " (" + notes.get(i).getDateSent() + ")</div>");
					out.print("<div class='text'>NOTE: " + notes.get(i).getNote() + "</div>");
					if (!user.getUserName().equals(notes.get(i).getSenderUserName())) 
						out.print("<button id='reply' onclick=\"reply('" + notes.get(i).getSenderUserName() + "');\">Reply</button>");
					out.print("</div>");
				}
			%>
		</div>
		<div id="friendrequestbox">
		<div class="title">Active Friend Requests:</div>
		
			<%
				List<FriendRequest> req = (List<FriendRequest>)request.getAttribute("FriendRequests");
				for (int i=0;i<req.size();i++){
					String seen = "requestSeen";
					if (!req.get(i).isSeen()) seen = "request";
					out.print("<div class='" + seen + "'>");
					out.print("Friend Request FROM: <a href='Profile?username=" + req.get(i).getSenderUserName() + "'>" + req.get(i).getSenderUserName() + "</a><br>");
					//out.print("<div class='from'>FROM: " + req.get(i).getSenderUserName() + " TO: " + req.get(i).getGetterUserName() + "</div>");
					if (!((User)request.getSession().getAttribute("MasterUser")).getUserName().equals(req.get(i).getSenderUserName())){
						out.print("<form action=\"AcceptFriendRequest\" method=\"post\">");
						out.print("<input name=\"requestId\" value='" + req.get(i).getId() + "' type=\"hidden\">");
						out.print("<input name=\"status\" class=\"accept\" type=\"submit\" value=\"Accept\"></form>");
					
						out.print("<form action=\"AcceptFriendRequest\" method=\"post\">");
						out.print("<input name=\"requestId\" value='" + req.get(i).getId() + "' type=\"hidden\">");
						out.print("<input name=\"status\" class=\"decline\" type=\"submit\" value=\"Decline\"></form>");
					}
					out.print("</div>");
				}
			%>
		</div>
		<div id="challengebox">
		<div class="title">Active Challenges:</div>
			<%
			List<Challenge> ch = (List<Challenge>)request.getAttribute("Challenges");
			for (int i=0;i<ch.size();i++){
				String seen = "challengeSeen";
				if (!ch.get(i).isSeen()) seen = "challenge";
				out.print("<div class='" + seen + "'>");
				out.print("FROM: <a href='Profile?username=" + ch.get(i).getSenderUserName() + "'>" + ch.get(i).getSenderUserName() + "</a><br>");
				//out.print("<div class='from'>FROM: " + req.get(i).getSenderUserName() + " TO: " + req.get(i).getGetterUserName() + "</div>");
				out.print("QUIZ: <a href='Quiz?id=" + ch.get(i).getQuizId() + "'>"  + qD.getQuiz(ch.get(i).getQuizId()).getQuizName() + "</a><br>");
				if (!((User)request.getSession().getAttribute("MasterUser")).getUserName().equals(ch.get(i).getSenderUserName())){
					out.print("<form action=\"AcceptChallenge\" method=\"post\">");
					out.print("<input name=\"challengeId\" value='" + ch.get(i).getId() + "' type=\"hidden\">");
					out.print("<input name=\"status\" class=\"accept\" type=\"submit\" value=\"Accept\"></form>");
				
					out.print("<form action=\"AcceptChallenge\" method=\"post\">");
					out.print("<input name=\"challengeId\" value='" + ch.get(i).getId() + "' type=\"hidden\">");
					out.print("<input name=\"status\" class=\"decline\" type=\"submit\" value=\"Decline\"></form>");
				}
				out.print("</div>");
			}
				
			%>
		</div>
	</div>
	
	<script type="text/javascript">
		function reply(to){
			window.alert = function(){};
			window.location = "CreateNote.jsp?getter=" + to;
		}
		function seen(id){
			$.ajax(
					{
						url: "MarkAsSeen",
						type: "POST",
						data: "&type=Note&id=" + id
					}		
				);
			document.getElementById("Note" + id).backgroundColor = "white";
		}
	</script>
	
	<div id="toppanel">
		<jsp:include page='<%= toppanel %>' />
	</div>
</body>
</html>