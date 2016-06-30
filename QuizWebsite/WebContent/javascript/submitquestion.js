/**
 * 
 */

function submit(questionID){
	$.ajax(
		{
			async: false,
			url: "Submit",
			type: "POST",
			data: $("#form").serialize() + "&questionPosition=" + questionID,
			success: function(data){
				if (data == "") return; else {
					window.location = data;
				} 
			}
		}		
	);
}