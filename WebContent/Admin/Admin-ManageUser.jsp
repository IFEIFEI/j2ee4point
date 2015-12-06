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
		<title>管理员后台-用户管理</title>
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
			<li><a href="Admin-AddUser.html">添加新用户</a></li>
			<li><span class="active">用户管理</span></li>
			<li><a href="Admin-CheckArtist.html">待审核艺术家</a></li>
		</ul>
		
			<div id="content" class="container_16 clearfix">
				<div class="grid_4">
					<p>
						<label>用户名</label>
						<input type="text" />
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>邮箱</label>
						<input type="text" />
					</p>
				</div>
				<div class="grid_5">
					<p>
						<label>用户身份</label>
						<select>
							<option>普通用户</option>
							<option>艺术家</option>
							<option>主编</option>
							<option>采编</option>
							<option>后台服务人员</option>
						</select>
					</p>
				</div>
				<div class="grid_2">
					<p>
						<label>&nbsp;</label>
						<input type="submit" value="&nbsp;&nbsp;搜索&nbsp;&nbsp;" />
					</p>
				</div>
				<div class="grid_16">
					<table>
						<thead>
							<tr>
								<th>用户名</th>
								<th>邮箱</th>
								<th>用户身份</th>
								<th colspan="2" width="20%">操作</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td colspan="5" class="pagination">
									<span class="active curved">1</span><a href="#" class="curved">2</a><a href="#" class="curved">3</a><a href="#" class="curved">4</a> ... <a href="#" class="curved">10 million</a>
								</td>
							</tr>
						</tfoot>
						<tbody>
							<tr>
								<td>Philip</td>
								<td>Philip@163.com</td>
								<td>普通用户</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr class="alt">
								<td>Thomas</td>
								<td>Thomas@163.com</td>
								<td>普通用户</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr>
								<td>Ben</td>
								<td>Ben@163.com</td>
								<td>普通用户</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr class="alt">
								<td>Richard</td>
								<td>Ben@163.com</td>
								<td>普通用户</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr>
								<td>Alon</td>
								<td>Richard@163.com</td>
								<td>普通用户</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr class="alt">
								<td>Alex</td>
								<td>Alon@163.com</td>
								<td>普通用户</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr>
								<td>Nathan</td>
								<td>Alex@163.com</td>
								<td>普通用户</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr class="alt">
								<td>Habib</td>
								<td>Nathan@163.com</td>
								<td>艺术家</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr>
								<td>Jeremy</td>
								<td>Habib@163.com</td>
								<td>艺术家</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr class="alt">
								<td>Ed</td>
								<td>Jeremy@163.com</td>
								<td>艺术家</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr class="alt">
								<td>Claire</td>
								<td>Ed@163.com</td>
								<td>艺术家</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr>
								<td>Philip</td>
								<td>Tom@163.com</td>
								<td>采编</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr class="alt">
								<td>Thomas</td>
								<td>Claire@163.com</td>
								<td>采编</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
							</tr>
							<tr>
								<td>Ben</td>
								<td>Thomas@163.com</td>
								<td>采编</td>
								<td><a href="Admin-UpdateUser.html" class="edit">修改</a></td>
								<td><a href="#" class="delete">删除</a></td>
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