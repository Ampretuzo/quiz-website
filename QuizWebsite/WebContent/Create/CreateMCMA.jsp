<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
	Parameters: 'statement' - problem statement;
				'correctanswer' + i - correct answers (ex: 'correctanswer0')
				'answer' + i - other answers(ex: 'answer0')
 -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/createtest.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript" src="../javascript/createquestion.js"></script>
</head>
<body>
	<form id="form" onkeypress="return event.keyCode != 13;">
	Question Grade: <input type="text" name="grade" id="grade"> <br><br>
	Question:
	<textarea type="text" cols="60" rows="6" name="statement"></textarea> <br>
	Correct Answer:
	<span id="correctanswerfield">
		<input type="text"  name="correctanswer0">
	</span>
	<br> <br> <br>
	Other Answers:
	<span id="otheranswerfield">
		<input type="text"  name="answer0">
	</span>
	</form>
	<br>
	<button onclick="addCorrectAnswer();">Add Correct Answer</button>
	<br>
	<button onclick="addAnswer();">Add Answer</button>
	<input id="submit" onclick="submit('CreateMCMA');" type="hidden" />
	<script type="text/javascript">
		var count = 1;
		var countCorrect = 1;
		function addAnswer(){
			var field = document.createElement("input");
			field.name = "answer" + count; field.type = "text";
			document.getElementById('otheranswerfield').appendChild(field);
			count++;
		}
		function addCorrectAnswer(){
			var field = document.createElement("input");
			field.name = "correctanswer" + countCorrect; field.type = "text";
			document.getElementById('correctanswerfield').appendChild(field);
			countCorrect++;
		}
	</script>
</body>
</html>