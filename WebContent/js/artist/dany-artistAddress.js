/**
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
$(document).ready(function () {
	$("#tijiao").click(function () {
		$.post(
			"artistUpdateAddress",
			{ 
				"country":$("input#country").val(),
				"province":$("input#province").val(),
				"city":$("input#city").val(),
				"detailedAddress":$("#detailedAddress").val(),
			},
			function (data) {
				if(data.state==1)
				{
					alert("地址修改成功");
				}
				
			}, 'json');
	});
	
});