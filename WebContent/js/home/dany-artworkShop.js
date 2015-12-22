/**
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
$(document).ready(function () {
		$("p.test").click(function () {	
			alert("hello");
			$.post(
				"getArtworkByType",
				{ "type":"hello"
				},
				function (data) {
					
					//window.location.href="/getCheckPendingList";
					window.location.reload();
					alert("hello");
				}, 'json');
		});
	});