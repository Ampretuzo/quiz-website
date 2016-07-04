<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/createtest.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript" src="../javascript/createquestion.js"></script>
</head>
<body>
	<form id="form" onkeypress="return event.keyCode != 13;">
		Question Grade: <input type="text" name="grade" id="grade"> <br> <br>
		Text:
		<textarea type="text" cols="60" rows="6" name="statement" id="stmnt"></textarea> <br>
		Questions:<br>
		<span id="answerfield">
			
		</span>
	</form>
	<br><br>
	<button onclick="addQuestion();">Add Statement</button>
	
	<input id="submit" onclick="submit('CreateTF');" type="hidden" />
	
	<script type="text/javascript">
		var count = 0;
		function addQuestion(){
			var i = count;
			var field = document.createElement("input");
			field.name = "question" + i; field.className = "que"; field.type = "text";
			document.getElementById("answerfield").appendChild(field);
			
			field = document.createElement("input");
			field.name = "answer" + i; field.className = "ans"; field.type = "radio"; field.checked = true; field.value = "True";
			document.getElementById("answerfield").appendChild(field);
			document.getElementById("answerfield").appendChild(document.createTextNode("True"));
			
			field = document.createElement("input");
			field.name = "answer" + i; field.className = "ans"; field.type = "radio"; field.value = "False";
			document.getElementById("answerfield").appendChild(field);
			document.getElementById("answerfield").appendChild(document.createTextNode("False"));
			
			field = document.createElement("br");
			document.getElementById("answerfield").appendChild(field);
			count++;
		}
		addQuestion();
	</script>
</body>
</html>