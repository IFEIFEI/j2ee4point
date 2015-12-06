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
		<title>主编后台-审核记录</title>
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
			<li><a href="ChiefEditor-CheckPendingList.html">待审核</a></li>
			<!--<li><a href="ChifeEditor-CheckAdsList.html">待审核广告</a></li>-->
			<li><span class="active">我的审核记录</span></li>
		</ul>
			<div id="content" class="container_16 clearfix">
				
				<div class="grid_16">
					<p>
						<input type="text" placeholder="输入关键字进行查找" style="width:300px; height:25px"/>
						<input type="submit" value="查找" />
					</p>
				</div>
				
				<div class="grid_16">
					<table>
						<thead>
							<tr>
								<th>题目</th>
								<th>类型</th>
								<th>提交时间</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<!--jsp分页;查看艺术资讯-->
						<tbody>
							<tr>
								<td>呵呵哒</td>
								<td>广告</td>
								<td>2015-11-30</td>
								<td>在线</td>
								<td><a href="ChifeEditor-CheckNews.html" class="edit">查看</a></td>
							</tr>
							<tr class="alt">
								<td>哦</td>
								<td>广告</td>
								<td>2015-11-29</td>
								<td>在线</td>
								<td><a href="ChifeEditor-CheckNews.html" class="edit">查看</a></td>
							</tr>
							<tr>
								<td>呵呵哒</td>
								<td>资讯</td>
								<td>2015-11-24</td>
								<td>已发布</td>
								<td><a href="ChifeEditor-CheckNews.html" class="edit">查看</a></td>
							</tr>
							<tr class="alt">
								<td>哦</td>
								<td>艺术品资讯</td>
								<td>2015-11-20</td>
								<td>已发布</td>
								<td><a href="ChifeEditor-CheckNews.html" class="edit">查看</a></td>
							</tr>
							<tr>
								<td>呵呵哒</td>
								<td>资讯</td>
								<td>2015-11-15</td>
								<td>已发布</td>
								<td><a href="ChifeEditor-CheckNews.html" class="edit">查看</a></td>
							</tr>
							<tr class="alt">
								<td>哦</td>
								<td>资讯</td>
								<td>2015-11-04</td>
								<td>已下线</td>
								<td><a href="ChifeEditor-CheckNews.html" class="edit">查看</a></td>
							</tr>
							<tr>
								<td>呵呵哒</td>
								<td>广告</td>
								<td>2015-10-24</td>
								<td>已下线</td>
								<td><a href="ChifeEditor-CheckNews.html" class="edit">查看</a></td>
							</tr>
							<tr class="alt">
								<td>哦</td>
								<td>广告</td>
								<td>2015-10-20</td>
								<td>已下线</td>
								<td><a href="ChifeEditor-CheckNews.html" class="edit">查看</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				
			</div>
		
		<div id="foot">
					<a href="#">联系我们</a>
		</div>
	</body>
</html>