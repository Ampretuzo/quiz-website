/**
 * 
 */

function submitQuiz(){
	if (document.getElementById("iframe") != null) {
		var url = document.getElementById("iframe").src;
		var num = parseInt(url.substring(url.indexOf("?id=") + 4)) + 1;
		if (num >= document.getElementById("num").value) {$(window).unbind(); window.location = "FinishQuiz"; return;}
	} 
	var questions = document.getElementsByTagName("iframe");
	for (var i=0;i<questions.length;i++){
		var doc = questions[i].contentDocument;
		var button = doc.getElementById("submit");
		button.click();
	}
	$(window).unbind();
	window.location = "FinishQuiz";
}

function nextQuestion(){
	var url = document.getElementById("iframe").src;
	var num = parseInt(url.substring(url.indexOf("?id=") + 4)) + 1;
	var doc = document.getElementById("iframe").contentDocument;
	
	doc.getElementById("submit").click();
	setTimeout(function(){
		document.getElementById("iframe").src = "Question?id=" + num;
	}, 2000);	
}

$(window).bind('beforeunload', function() {
	return 'Submit Quiz or Prepare to Lose Everything(ha ha ha ha) \n Still Want to Quit?';
});

function countDown(){
	var d = new Date().getTime();
	var k = remaining - (d - startTime);
	var kk = k;
	var h = Math.floor(k / (60*60*1000)); k %= (60*60*1000); 
	var m = Math.floor(k / (60*1000)); k %= (60*1000);
	var s = Math.floor(k / 1000); 
	updateTime(h,m,s);
	return kk;
}
function updateTime(h,m,s){
	document.getElementById("hours").innerHTML = h;
	document.getElementById("mins").innerHTML = m;
	document.getElementById("secs").innerHTML = s;
}
var j = setInterval(function(){
	if (countDown()<1000) {
		clearInterval(j); 
		$(window).unbind();
		window.location = "notSaved.html";		
	}
},100);