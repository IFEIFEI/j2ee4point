$(document).ready(function () {
	$("#tijiao").click(function () {
		$.post(
			"userUpdateAddress",
			{ 
				"country":$("input#country").val(),
				"province":$("input#province").val(),
				"city":$("input#city").val(),
				"detailedAddress":$("textarea#detailedAddress").val(),
			},
			function (data) {
				if(data.state==1)
				{
					alert("地址修改成功");
				}
				
			}, 'json');
	});
	
});