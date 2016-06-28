/**
 * 
 */

function submit(servlet){
	$.ajax(
		{
			async: false,
			url: "../" + servlet,
			type: "POST",
			data: $("#form").serialize() 
		}		
	);
}s