<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8" />
		<title>艺术品资讯测试</title>

		<script src="js/jquery.js"></script>
	</head>
	<body>
		<form>
			<input class="in1" type="text" name="title" value="">
			<input class="in2" type="text" name="type" value="">
			<input class="in3" type="text" name="article" value="">
			<input class="sub1" type="button" value="submit">
		</form>
	</body>
	<script type="text/javascript">
	$(document).ready(function () {
		$("input.sub1").click(function () {
			$.post(
				"jstest",
				{ "jstest":"get it?" },
				function (data) {
						alert(data.title+data.type+data.article);
						$("input.in1").val(data.title);
						$("input.in2").val(data.type);
						$("input.in3").val(data.article);			
				}, 'json');
		});
	});
	</script>
</html>