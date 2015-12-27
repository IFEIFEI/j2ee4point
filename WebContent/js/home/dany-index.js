/**
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
$(document).ready(function () {
		$("a.getArtwork").click(function () {	
			$.post(
				"getArtwork",
				{ "hello":"hello"
				},
				function (data) {
					
					//window.location.href="/getCheckPendingList";
					alert("hello");
				}, 'json');
		});
	});