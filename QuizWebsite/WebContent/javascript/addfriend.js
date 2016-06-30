/**
 * 
 */

function addFriend(user){
	$.ajax(
		{
			async: true,
			url: "SendFriendRequest",
			type: "POST",
			data: "&getter=" + user,
			success: function(data){
				document.getElementById("addfriendb").innerHTML = "Sent!";
				document.getElementById("addfriendb").disabled = true;
			}
		}		
	);
}s