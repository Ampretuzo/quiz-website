/**
 * 
 */

function submit(questionID){
	$.ajax(
		{
			async: false,
			url: "../Submit",
			type: "POST",
			data: $("#form").serialize() + "&questionPosition=" + questionID
		}		
	);
}