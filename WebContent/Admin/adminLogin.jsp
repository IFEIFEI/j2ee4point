<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
-->

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>RMS-Login</title>
		<style type="text/css">
			h1 {line-height: 300%}
			p.f  {font-size: 16px}
		</style>
		<link rel="stylesheet" href="css/admin/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/admin/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/admin/colour.css" type="text/css" media="screen" charset="utf-8" />
	</head>
	<body>

		<h1 id="head">艺术品定制网站后台管理系统</h1>
		
		<div id="content" class="container_16 clearfix">
		<br/> <br/> <br/>
			<div class="grid_1">
				<br/>
			</div>
			<div class="grid_8">
				<h3>登&nbsp&nbsp录</h3>
				<!--
					<s:form action="Login">
					<s:textfield key="username"/>
					<s:password name="password" label="Password"/>
					<s:submit/>
					</s:form>
					-->
					
					<br/><br/>
					
					<form action="adminLogin">
						<p>
							<label>Username:</label>
							<input type="text" name="username" id="username" value="" style="width:350px; height:25px;" />
							<br />
						</p>
						<p>
							<label for="password">Password:</label>
							<input type="password" name="password" id="password" value="" style="width:350px; height:25px;" />
							<br />
						</p>
						<p>
							<br/>
							<input type="submit" value="  Login  " style="width:200px; height:40px;" />
							<br/>
						</p>
					</form>
			</div>
			<div class="grid_1">
				<br/>
			</div>
			<div class="grid_6">
				<br/>
				<p class="f"><a href="template.html" target="view_window">点此进入XX艺术品定制网站</a></p>	
				<img src="images/admin/LOGO.jpg" width="250px" height="250px"/>
			</div>
		</div>
		
	</body>
</html>

.