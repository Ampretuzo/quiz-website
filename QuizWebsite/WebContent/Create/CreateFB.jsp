<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
	Parameters: 'statement' - problem statement;
				'answer' + i + '/' + j - possible answer to i-th blank(ex: answer0/12, means blank 0 has at least 13 correct answers);

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
		Question Grade: <input type="text" name="grade" id="grade"> <br> <br>
		Text:
		<textarea type="text" cols="60" rows="6" name="statement" id="stmnt"></textarea> <br>
		Correct Answers:<br>
		<span id="answerfield">
		
		</span>
	</form>
	<br><br>
	<button onclick="addAnsField();">Add Blank</button>
	
	<input id="submit" onclick="submit('CreateFB');" type="hidden" />
	
	<script type="text/javascript">
		var count = 0;
		var a = [];
		function addAnswer(i){
			var field = document.createElement("input");
			field.name = "answer" + i + "/" + a[i]; a[i]++; 
			field.className = "ans"; field.type = "text";
			document.getElementById(i).appendChild(field);
		}
		function addAnsField(){
			document.getElementById('stmnt').value += " _____ ";
			document.getElementById('stmnt').focus();
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