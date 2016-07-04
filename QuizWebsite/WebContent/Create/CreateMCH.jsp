<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--Two buttons.
	Parameters: 'statement' - problem statement;
				'question' + i - left column
				'rightanswer' + i - right answer for each 
				'wronganswer' + i - wrong answers('right' + i)(ex: 'wronganswer0')

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
	
	<div id="leftfield">
		<input type="text" class="left" name="question0">
	</div>
	
	<div id="rightfield">
		<input type="text" class="right" name="rightanswer0"> 
	</div>
	
	<div id="wrongfield">
		
	</div>
	
	</form>
	
	<button id="addl" onclick="addPair();">Add Pair</button>
	<button id="addw" onclick="addWrong();">Add Wrong</button>
	<br><br>
	
	<input id="submit" onclick="submit('CreateMCH');" type="hidden" />
	
	
	
	<script type="text/javascript">
		var countPair = 1;
		var wrong = 0;
		function addPair(){
			var field = document.createElement("input");
			field.name = "question" + countPair; field.type = "text"; field.className = "left";
			document.getElementById('leftfield').appendChild(field);
			
			field = document.createElement("input");
			field.name = "rightanswer" + countPair; field.type = "text"; field.className = "right";
			document.getElementById('rightfield').appendChild(field);
			
			countPair++;
		}
		function addWrong(){
			var field = document.createElement("input");
			field.name = "wronganswer" + wrong; field.type = "text"; field.className = "wrong";
			document.getElementById('wrongfield').appendChild(field);
			
			wrong++;
		}
	</script>
	
</body>
</html>