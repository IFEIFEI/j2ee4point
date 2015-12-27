/**
 * 
 */
$(document).ready(function () {
	$("input#tijiao").click(function () {
		div=$(this).parent().parent().parent();
		$.post(
			"artistUpdateInfo",
			{ 
				"realName":$("input#realName").val(),
				"userName":$("input#userName").val(),
				"email":$("input#email").val(),
				"phoneNumber":$("input#phoneNumber").val(),
				"education":$("input#education").val(),
				"description":$("#description").val(),
				"city":$("input#city").val(),
			},
			function (data) {
				if(data.state==1)
				{
					alert("修改成功");
					window.location.reload();
				}
				
			}, 'json');
	});
	
});