/**
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
$(document).ready(function () {
	$("a.delete").click(function () {
		div=$(this).parent().parent().parent();
		$.post(
			"deleteMyArtwork",
			{ 
				"artworkId":$(this).attr("artworkId")
			},
			function (data) {
				if(data.state==1)
				{
					alert("操作成功");
					$(div).hide();
				}
				
			}, 'json');
	});
	
});