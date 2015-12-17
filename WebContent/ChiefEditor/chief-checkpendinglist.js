/**
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
$(document).ready(function () {
		$("a.edit").click(function () {
			$.post(
				"checkArtNews",
				{ 	"artNewsId":"1" ,
					"state":"approved"
				},
				function (data) {
					if(data.state==1)
						{
							alert("successed");
						}
				}, 'json');
		});
	});