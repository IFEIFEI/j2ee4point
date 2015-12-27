/**
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
$(document).ready(function () {
		$("a.delete").click(function () {
			div=$(this).parent().parent().parent();
			$.post(
				"deleteOneRecordFormShopCar",
				{ 
					"artworkId":$(this).attr("artworkId")
				},
				function (data) {
					if(data.state==1)
					{
						alert("删除成功");
						$(div).hide();
					}
					
				}, 'json');
		});
		
		$("input#gotopay").click(function (){
			$.post(
					"windUpAnAccount",
					{},
					function (data){
						if(data.state==1)
						{
							alert("订单提交成功！等待管理员确认订单");
							$("div#cartArtwork").hide();
							window.location.href="userCenter";
						}
					},"json");
		});
});