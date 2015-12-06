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
		<title>管理员后台-添加新用户</title>
		<style type="text/css">
			h1 {line-height: 300%}
			a.add {text-decoration:none}
			p {text-indent: 2em}
		</style>
		<link rel="stylesheet" href="../css/admin/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="../css/admin/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="../css/admin/colour.css" type="text/css" media="screen" charset="utf-8" />
		
	</head>
	<body>
		<h1 id="head">艺术品定制网站后台管理系统</h1>
	
		<ul id="navigation">
			<li><span class="active">添加新用户</span></li>
			<li><a href="Admin-ManageUser.html">用户管理</a></li>
			<li><a href="Admin-CheckArtist.html">待审核艺术家</a></li>
		</ul>
		
			<div id="content" class="container_16 clearfix">
				<div class="grid_16">
					<h4>
						选择要添加的用户类型：	
					</h4>
					<p><a href="Admin-AddCommonUser.html" class="add">添加一个新的普通用户</a></p>
					<p><a href="Admin-AddArtist.html" class="add">添加一个新的艺术家</a></p>
					<p><a href="Admin-AddEditor.html" class="add">添加一个新的采编</a></p>
					<p><a href="Admin-AddChiefEditor.html" class="add">添加一个新的主编</a></p>
					<p><a href="Admin-AddServer.html" class="add">添加一个新的后台服务人员</a></p>
				</div>
			</div>
		
		<div id="foot">
					<a href="#">联系我们</a>
				
		</div>
	</body>
</html>