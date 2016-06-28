/**
 * 
 */

function submitQuiz(){
	var questions = document.getElementsByTagName("iframe");
	for (var i=0;i<questions.length;i++){
		var doc = questions[i].contentDocument;
		var button = doc.getElementById("submit");
		button.click();
	}
	window.location = "FinishQuiz";
}

function nextQuestion(){
	var url = document.getElementById("iframe").src;
	var num = parseInt(url.substring(url.indexOf("?id=") + 4)) + 1;
	document.getElementById("iframe").src = "Question?id=" + num;
}

$(window).bind('beforeunload', function() {
	return 'Submit Quiz or Prepare to Lose Everything(ha ha ha ha) \n Still Want to Quit?';
});

var remaining = 60*60*1000 - 1;

var startTime = new Date().getTime();
function countDown(){
	var d = new Date().getTime();
	var k = remaining - (d - startTime);
	var h = Math.floor(k / (60*60*1000)); k %= (60*60*1000); 
	var m = Math.floor(k / (60*1000)); k %= (60*1000);
	var s = Math.floor(k / 1000); 
	updateTime(h,m,s);
}
function updateTime(h,m,s){
	document.getElementById("hours").innerHTML = h;
	document.getElementById("mins").innerHTML = m;
	document.getElementById("secs").innerHTML = s;
}
var j = setInterval("countDown()",100);