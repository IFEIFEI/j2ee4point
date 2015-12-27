<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>主编后台-审核记录</title>
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
			<li><a href="getCheckPendingList">待审核列表</a></li>
			<!--<li><a href="ChifeEditor-CheckAdsList.html">待审核广告</a></li>-->
			<li><span class="active">我的审核记录</span></li>
		</ul>
			<div id="content" class="container_16 clearfix">
				
				<div class="grid_16">
					<form action="" method="post">
					<p>
						<input name="searchbykey" type="text" placeholder="输入关键字进行查找" style="width:300px; height:25px"/>
						<input type="submit" value="查找"/>
					</p>
					</form>
				</div>
				
				<div class="grid_16">
					<table>
						<thead>
							<tr>
								<th>题目</th>
								<th>软文类型</th>
								<th>作者</th>
								<th>审核时间</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<!--jsp分页;查看艺术资讯-->
						<tbody id="htable">
							<c:forEach items='${ artNewsList }' var="result">

							<tr class="alt">
								<td>${result.title}</td>
								<td>${result.type}</td>
								<td>${result.editor.userName}</td>
								<td>${result.editTime}</td>
								<td>${result.state}</td>
								<td><a href="getArtNewsDetailById?artNewsId=${result.id} }" class="edit">查看</a></td>
							</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="5" class="pagination">
									<span id="spanFirst">首页</span> 
									<span id="spanPre">上一页</span> 
									<span id="spanNext">下一页</span> 
									<span id="spanLast">尾页</span> 
									第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页      
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
				
			</div>
		
		<div id="foot">
					<a href="#">联系我们</a>
		</div>
	</body>
	<script>
	var theTable = document.getElementById("htable");    
	var totalPage = document.getElementById("spanTotalPage");    
	var pageNum = document.getElementById("spanPageNum");    
   
	var spanPre = document.getElementById("spanPre");    
	var spanNext = document.getElementById("spanNext");    
	var spanFirst = document.getElementById("spanFirst");    
	var spanLast = document.getElementById("spanLast");    
   
	var numberRowsInTable = theTable.rows.length;    
	var pageSize = 10;    
	var page = 1;

	//下一页    
	function next(){    
   
    	hideTable();    
        
    	currentRow = pageSize * page;    
    	maxRow = currentRow + pageSize;    
    	if ( maxRow > numberRowsInTable ) maxRow = numberRowsInTable;    
    	for ( var i = currentRow; i< maxRow; i++ ){    
        	theTable.rows[i].style.display = '';    
    	}    
    	page++;    
        
    	if ( maxRow == numberRowsInTable ) 
			{ nextText(); lastText(); }  
    	showPage();    
    	preLink();    
    	firstLink();    
	}    
   
	//上一页    
	function pre(){    
   
    	hideTable();    
        
    	page--;    
        
    	currentRow = pageSize * page;    
    	maxRow = currentRow - pageSize;    
    	if ( currentRow > numberRowsInTable ) currentRow = numberRowsInTable;    
    	for ( var i = maxRow; i< currentRow; i++ ){    
        	theTable.rows[i].style.display = '';    
    	}    
        
        
    	if ( maxRow == 0 ){ preText(); firstText(); }    
    		showPage();   
    		nextLink();    
    		lastLink();  
	}    
   
	//第一页    
	function first(){    
    	hideTable();    
    	page = 1;    
    	for ( var i = 0; i<pageSize; i++ ){    
        	theTable.rows[i].style.display = '';    
    	}    
    	showPage();    
        
    	preText();    
    	nextLink();    
    	lastLink();    
	}    
   
	//最后一页    
	function last(){    
    	hideTable();    
    	page = pageCount();    
    	currentRow = pageSize * (page - 1);    
    	for ( var i = currentRow; i<numberRowsInTable; i++ ){    
        	theTable.rows[i].style.display = '';    
    	}    
    	showPage();    
        
    	preLink();    
    	nextText();    
    	firstLink();    
	}    
   
	function hideTable(){    
    	for ( var i = 0; i<numberRowsInTable; i++ ){    
        	theTable.rows[i].style.display = 'none';    
    	}    
	}    
   
	function showPage(){     
 		pageNum.innerHTML = page;
	}    
   
	//总共页数    
	function pageCount(){    
    	var count = 0;    
    	if ( numberRowsInTable%pageSize != 0 ) count = 1;     
    	return parseInt(numberRowsInTable/pageSize) + count;    
	}    
   
	//显示链接    
	function preLink(){ spanPre.innerHTML = "<a href='javascript:pre();'>上一页</a>";}    
	function preText(){ spanPre.innerHTML = "上一页";}    
   
	function nextLink(){ spanNext.innerHTML = "<a href='javascript:next();'>下一页</a>";}    
	function nextText(){ spanNext.innerHTML = "下一页";}    
   
	function firstLink(){ spanFirst.innerHTML = "<a href='javascript:first();'>首页</a>";}    
	function firstText(){ spanFirst.innerHTML = "首页";}    
   
	function lastLink(){ spanLast.innerHTML = "<a href='javascript:last();'>尾页</a>";}    
	function lastText(){ spanLast.innerHTML = "尾页";}    
   
	//隐藏表格    
	function hide(){    
    	for ( var i = pageSize; i<numberRowsInTable; i++ ){    
        	theTable.rows[i].style.display = 'none';    
    	}    
        
    	totalPage.innerHTML = pageCount();    
    	pageNum.innerHTML = '1';    
        
		if(pageCount()==1) {
			spanPre.innerHTML = " ";
			spanNext.innerHTML = " ";
			spanFirst.innerHTML = " ";
			spanLast.innerHTML = " ";
			return;
		}
		
    	nextLink();    
    	lastLink();    
	}    
   
	hide();
	</script>
</html>