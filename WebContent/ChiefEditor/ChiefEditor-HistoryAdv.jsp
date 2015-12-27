<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>主编后台-软文</title>
		<style type="text/css">
			h1 {line-height: 300%}
		</style>
		<link rel="stylesheet" href="css/admin/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/admin/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="css/admin/colour.css" type="text/css" media="screen" charset="utf-8" />
		
	</head>
	<body>
	<h1 id="head">艺术品定制网站后台管理系统</h1>
	
	<ul id="navigation">
			<li><a href="ReportingStaffs-SubmitNews.html">我要写稿</a></li>
			<li><span class="active">提交记录</span></li>
			<li><a href="ReportingStaffs-Drafts.html">草稿箱</a></li>
		</ul>
		<div id="content" class="container_16 clearfix">

				<div class="grid_16">
					<h2 align="center">${Advertorial.title}</h2>
				</div>
				
				<div class="grid_16">
					<p align="center"><small>类型：${Advertorial.type}&nbsp;&nbsp;作者:${Advertorial.author}&nbsp;&nbsp;时间:${Advertorial.submitTime}</small></p>
				</div>
				
				<div class="grid_16">
					<p>${Advertorial.context}</p>
				</div>
				
			<div class="grid_16">
				<br/>
				<a href="ChiefEditor-History.html"><button class="btn" style="width:150px;height:30px;">返回记录列表</button></a>
			</div>
			
		</div>
		
		<div id="foot">
					<a href="#">联系我们</a>
		</div>
	</body>
</html>