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
	Question:
	<textarea type="text" cols="60" rows="6" name="statement"></textarea> <br>
	
	<div id="leftfield">
		<input type="text" class="left" name="left0">
	</div>
	
	<div id="rightfield">
		<input type="text" class="right" name="right0"> 
		<input type="text" class="answer" name="answer0" size="3">
	</div>
	
	</form>
	
	<button onclick="addLeft();">Add Left</button>
	<button onclick="addRight();">Add Right</button>
	<br><br>
	
	<input id="submit" onclick="submit('CreateMCH');" type="hidden" />
	
	<script type="text/javascript">
		var countleft = 1;
		var countright = 1;
		function addLeft(){
			var field = document.createElement("input");
			field.name = "left" + countleft; field.type = "text"; field.className = "left";
			//document.getElementById('leftfield').appendChild(document.createElement("br"));
			document.getElementById('leftfield').appendChild(field);
			countleft++;
		}
		function addRight(){
			var field = document.createElement("input");
			field.name = "right" + countright; field.type = "text"; field.className = "right";
			var correct = document.createElement("input");
			correct.name = "answer" + countright; correct.type = "text"; correct.className = "answer"; correct.size = "3";
			//document.getElementById('rightfield').appendChild(document.createElement("br"));
			document.getElementById('rightfield').appendChild(field);
			document.getElementById('rightfield').appendChild(correct);
			countright++;
		}
	</script>
	
</body>
</html>