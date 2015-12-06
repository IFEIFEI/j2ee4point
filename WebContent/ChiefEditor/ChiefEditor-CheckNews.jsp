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
		<title>主编后台-审核资讯</title>
		<style type="text/css">
			h1 {line-height: 300%}
		</style>
		<link rel="stylesheet" href="../css/admin/960.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="../css/admin/template.css" type="text/css" media="screen" charset="utf-8" />
		<link rel="stylesheet" href="../css/admin/colour.css" type="text/css" media="screen" charset="utf-8" />
		
	</head>
	<body>
	<h1 id="head">艺术品定制网站后台管理系统</h1>
	
	<ul id="navigation">
			<li><span class="active">待审核</span></li>
			<!--<li><a href="ChifeEditor-CheckAdsList.html">待审核广告</a></li>-->
			<li><a href="ChiefEditor-History.html">我的审核记录</a></li>
		</ul>
			<div id="content" class="container_16 clearfix">
			<div class="grid_16">
				<p><a href="ChiefEditor-CheckPendingList.html">返回待审核资讯</a><br/></p>
			</div>
			<div class="grid_8">
				<p>
				<label>题目</label>
				<input type="text" value="呵呵哒" style="width:460px;"/>
				<br />
				</p>
			</div>

			<div class="grid_2">
				<br />		
			</div>
			
			<div class="grid_6">
					<p>
						<label for="title">资讯类型</label>
						<select>
							<option>艺术家</option>
							<option>艺术品</option>
							<option>艺术活动</option>
						</select>
					</p>
			</div>
				
			<div class="grid_16">	
			<p>
				<label>资讯内容</label>
				<!-- 加载编辑器的容器 -->
				<script id="container" name="content" type="text/plain" style="width:950px;height:500px;">
				啦啦啦啦啦啦
				</script>
				<!-- 配置文件 -->
				<script type="text/javascript" src="../htmledit/ueditor.config.js"></script>
				<!-- 编辑器源码文件 -->
				<script type="text/javascript" src="../htmledit/ueditor.all.js"></script>
				<!-- 实例化编辑器 -->
				<script type="text/javascript" >
				var ue = UE.getEditor('container');
				</script>
			</p>
			</div>
				
			<div class="grid_16">
			<p align="right">
				<button class="btn" style="width:100px;height:30px;">上传</button>
				&nbsp;&nbsp;
				<button class="btn" style="width:100px;height:30px;">删除</button>
			</p>
			</div>	
			</div>
		
		<div id="foot">
					<a href="#">联系我们</a>
		</div>
	</body>
</html>