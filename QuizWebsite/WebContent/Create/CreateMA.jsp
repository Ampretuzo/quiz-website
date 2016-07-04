<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
	Parameters: 'statement' - problem statement;
				'answernum' - how many answers are required by author;
				'order'(checkbox) - checked if order is required;
				'answer' + i - correct answers; 
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
	Number of desired input fields: <input type="text" id="answernum" name="answernum"> <br>
	Does order matter? <input type="checkbox" id="order" name="order"> <br> <br> <br>
	Correct Answers:<br>
	<span id="answerfield">
		<span id="0" class="entry">
			1. <button type="button" onclick="addAnswer(0)">Add</button>
			<input type="text" class="ans" name="answer0/0">
		</span>
	</span>
	</form>
	<br>
	<button onclick="addAnsField();">Add Answer</button> 
	<input id="submit" onclick="submit('CreateMA');" type="hidden" />
	<script type="text/javascript">
		var count = 1;
		var a = [1];
		function addAnswer(i){
			var field = document.createElement("input");
			field.name = "answer" + i + "/" + a[i]; a[i]++; 
			field.className = "ans"; field.type = "text";
			document.getElementById(i).appendChild(field);
		}
		function addAnsField(){
			var field = document.createElement("span");
			field.className = "entry"; field.id = count;
			document.getElementById('answerfield').appendChild(document.createElement("br"));
			document.getElementById('answerfield').appendChild(field);
			a.push(1);
			field.innerHTML += (count+1) + ". <button type='button' onclick='addAnswer(" + count + ")'>Add</button>";
			field.innerHTML += "<input type='text' name='answer" + count + "/0' class='ans'>";
			count++;
		}
	</script>
</body>
</html>