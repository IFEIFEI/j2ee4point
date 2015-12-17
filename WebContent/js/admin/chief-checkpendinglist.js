/**
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
$(document).ready(function () {
		$("a.tong").click(function () {
			$tr=$(this).parent().parent();
			$td=$(this);
			$.post(
				"checkArtNews",
				{ 	"artNewsId":$(this).parent().parent().attr("artNewsid") ,
					"state":"approved"
				},
				function (data) {
					if(data.state==1)
						{
							$td.text("已通过");
							$td.parent().next("td").hide();
						}
				}, 'json');
		});
		
		$("a.notong").click(function () {
			$tr=$(this).parent().parent();
			$td=$(this);
			$.post(
				"checkArtNews",
				{ 	"artNewsId":$(this).parent().parent().attr("artNewsid") ,
					"state":"disapproved"
				},
				function (data) {
					if(data.state==1)
						{
							$td.text("已否决");
							$td.parent().prev().children().hide();
						}
				}, 'json');
		});
	});