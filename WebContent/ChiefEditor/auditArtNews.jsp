<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>主编后台-审核资讯</title>
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
			<li><span class="active">待审核列表</span></li>
			<!--<li><a href="ChifeEditor-CheckAdsList.html">待审核广告</a></li>-->
			<li><a href="getArtNewsByChiefEditor">我的审核记录</a></li>
		</ul>
			<div id="content" class="container_16 clearfix">
			<div class="grid_16">
				<p><a href="getCheckPendingList">返回待审核资讯</a><br/></p>
			</div>
			
		<form name="newArticle" id="draftform"  onsubmit="return validate_form(this)" method="post"  enctype="multipart/form-data">
			<div>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;文章类型<br/>&nbsp;&nbsp;
					<c:if test="${artNews.type!='article' }">
					<input type="radio" name="Advertorialtype" id="Advertorialtype" checked="checked" value="ads"/>
					</>
					广告&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="Advertorialtype" id="Advertorialtype" value="article" />资讯</c:if>
					<c:if test="${artNews.type=='article'}">
					<input type="radio" name="Advertorialtype" id="Advertorialtype"  value="ads"/>
					</>
					广告&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="Advertorialtype" id="Advertorialtype" checked="checked" value="article" />资讯</c:if>
				</p>
			</div>
						
			<div class="grid_5" name="startdate">
				<p name="reg_testdate">
				上线时间<br/>

  				<input type="date" name="startDate" value="${dateAndPositionList[0].publishDate }"/>
				<br />
				</p>
			</div>
			
			<div class="grid_5" name="enddate" >
				<p name="reg_testdate">
				下线时间<br/>

  				<input type="date" name="endDate" value="${dateAndPositionList[fn:length(dateAndPositionList)-1].publishDate }"/>
				<br />
				</p>
			</div>
			
			<div class="grid_3" name="article_div1" id="article_div1">
				<p>
				所在栏目
				<select id="article_type" name="columnID" style="width:140px" >
				 <c:choose>
				    <c:when test="${dateAndPositionList[0].columnID=='artist' }">
					<option selected="selected">artist</option>
					<option>artwork</option>
					<option>show</option>
					<option>other</option>
					</c:when>
					<c:when test="${dateAndPositionList[0].columnID=='artwork' }">
					<option >artist</option>
					<option selected="selected">artwork</option>
					<option>show</option>
					<option>other</option>
					</c:when>
					<c:when test="${dateAndPositionList[0].columnID=='show' }">
					<option>artist</option>
					<option>artwork</option>
					<option selected="selected">show</option>
					<option>other</option>
					</c:when>
					<c:when test="${dateAndPositionList[0].columnID=='other' }">
					<option>artist</option>
					<option>artwork</option>
					<option>show</option>
					<option selected="selected">other</option>
					</c:when>
					</c:choose>
				</select>
				</p>
			</div>
			
			<div class="grid_3" name="article_div2" id="article_div2">
				<p>
				资讯/广告顺序
				<input type="text" id="article_pos" name="article_pos" value="${dateAndPositionList[0].priority }" oninput="checkAticle_pos()" style="width:140px">
				<lable><small id="err" style="color:red">&nbsp;</small></lable>
				</p>
			</div>
			
			<div class="grid_9">
				<p>
				<label>标题</label>
				<input type="text" name="title" id="title"  style="width:460px; height:25px;" value="${artNews.title }"/>
				<br/><br/>
				</p>
			</div>
			
			<div class="grid_16">
				<p>
				<label>文章简介</label>
				<textarea name="adv_dis" id="adv_dis" rows="4" style="resize:none">${artNews.summary}</textarea>
				<br/>
				</p>
			</div>
			
			<div class="grid_16">	
			<p>
				<label>内容</label>
       		 	<!-- 加载编辑器的容器 
        		<script id="container" name="content" type="text/plain">
           
        		</script>
-->
				<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
    <script id="ueditor"   name="ueditor" type="text/plain" style="width:1024px;height:500px;"></script>
<script type="text/javascript">
//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
var ue = UE.getEditor('ueditor');
ue.ready(function(){
    ue.setContent('${artNewsContent.content}');    
})
</script>
			</p>
			</div>
				
			<div class="grid_16">
			<p align="right">
				<input type="submit" class="btn" style="width:100px;height:30px;" value="审核通过" onclick="buttonapprove()"/>
				&nbsp;&nbsp;
				<input type="submit" class="btn" style="width:100px;height:30px;" value="退回修改" onclick="buttondisapprove()"/>
			</p>
			</div>	
			
		</form>
		</div>
		
		<div id="foot">
					<a href="#">联系我们</a>
		</div>
	</body>
	
	<script type="text/javascript">
	
		function Type(){
			var selects = document.getElementsByName("Advertorialtype");  
   				 for (var i=0; i<selects.length; i++){  
       				 if (selects[i].value=="${Advertorial.type}") {  
            			selects[i].checked= true;  
            			break;  
        			}  
    			}
    		if(document.getElementsByName("Advertorialtype")[0].checked){
      			document.getElementById("ads_div").style.display="";
      			document.getElementById("article_div1").style.display="none";
				document.getElementById("article_div2").style.display="none";
				
    			var ads_options = document.getElementById("ads_pos").options;
				for (i=0; i<ads_options.length; i++){
					if (ads_options[i].id == "${Advertorial.adsPos}") // 根据option标签的ID来进行判断
						ads_options[i].selected = true;
				}  
   			}else{
     		  	document.getElementById("ads_div").style.display="none";
       			document.getElementById("article_div1").style.display="";
				document.getElementById("article_div2").style.display="";
				
				var art_options = document.getElementById("article_type").options;
				for (i=0; i<art_options.length; i++){
					if (art_options[i].id == "${Advertorial.articleType}") // 根据option标签的ID来进行判断
						art_options[i].selected = true;
				}
				var article_pos = document.getElementById("article_pos");
				article_pos.value = "${Advertorial.articlePos}";
				
    		}
		}
		if(document.attachEvent)   
       		window.attachEvent("onload", Type);   
   		else   
       		window.addEventListener('load', Type, false);
			   
		function selectType(){
	
    		if(document.getElementsByName("Advertorialtype")[0].checked){
      			document.getElementById("ads_div").style.display="";
      			document.getElementById("article_div1").style.display="none";
				document.getElementById("article_div2").style.display="none";

   			}else{
     		  	document.getElementById("ads_div").style.display="none";
       			document.getElementById("article_div1").style.display="";
				document.getElementById("article_div2").style.display="";
    		}
		}
	</script>
	<script type="text/javascript">
		function checkAticle_pos(){
			var pos = document.getElementById("article_pos").value;
			var patt = new RegExp("^[0-9]+$");
			if(!patt.test(pos)){
				document.getElementById("err").innerHTML="非法输入";
				return false;
			}
			else{
				document.getElementById("err").innerHTML=" ";
				return true;
			}
		}
		function validate_required(field,alerttxt)
		{
			with (field)
 		 	{
  				if (value==null||value==""||!checkAticle_pos())
    				{alert(alerttxt);return false}
  				else {return true}
 		 	}
		}

		function validate_form(thisform)
		{
			if(document.getElementsByName("Advertorialtype")[0].checked)
				return true;
			with (thisform)
  			{
  				if (validate_required(article_pos,"有非法输入!")==false)
    				{article_pos.focus();return false}
  			}
		}
		function buttonapprove()
	     {
	    	 alert("发布成功");
	document.getElementById("draftform").action="approveArtNews?artNewsId=${artNews.id}";
	document.getElementById("draftform").submit();
	     }
	     function buttondisapprove()
	     {
	    	 alert("退回成功");
	document.getElementById("draftform").action="disapproveArtNews?artNewsId=${artNews.id}";
	document.getElementById("draftform").submit();
	     }
	</script>
	<script type="text/javascript">  
   		function YYYYMMDDstart()   
  	 	{   
           MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];   
    
           //先给年下拉框赋内容   
           var y  = new Date().getFullYear();
		   var startY = document.getElementById("SYYYY");
		   var endY = document.getElementById("EYYYY");   
           for (var i = y; i < (y+5); i++) {//以今年为准,后5年   
                   startY.options.add(new Option(" "+ i +" 年", i));
				   endY.options.add(new Option(" "+ i +" 年", i));   
		   }
    
           //赋月份的下拉框   
		   var startM = document.getElementById("SMM");
		   var endM = document.getElementById("EMM");
           for (var i = 1; i < 13; i++) {  
                   startM.options.add(new Option(" " + i + " 月", i));
				   endM.options.add(new Option(" " + i + " 月", i));  
		   } 
    
           startY.value = "${Advertorial.starty}";   
           startM.value = "${Advertorial.startm}";
		   endY.value = "${Advertorial.endy}";   
           endM.value = "${Advertorial.endm}";
		      
           var n = MonHead[new Date().getMonth()];
		   var startD = document.getElementById("SDD");
		   var endD = document.getElementById("EDD");   
           if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;   
                writeSDD(n); writeEDD(n);//赋日期下拉框Author:meizz   
           startD.value = "${Advertorial.startd}";
		   endD.value = "${Advertorial.endd}";   
   		}   
   		if(document.attachEvent)   
       		window.attachEvent("onload", YYYYMMDDstart);   
   		else   
       		window.addEventListener('load', YYYYMMDDstart, false); 
			     
   		function SYYYYDD(str) //年发生变化时日期发生变化(主要是判断闰平年)   
   		{   
			var startM = document.getElementById("SMM");
           	var MMvalue = startM.options[startM.selectedIndex].value;   
           	if (MMvalue == ""){ var e = document.getElementById("SDD"); optionsClear(e); return;}   
           	var n = MonHead[MMvalue - 1];   
           	if (MMvalue ==2 && IsPinYear(str)) n++;   
                writeSDD(n);   
   		}   
   		function SMMDD(str)   //月发生变化时日期联动   
   		{   
			var startY = document.getElementById("SYYYY");
        	var YYYYvalue = startY.options[startY.selectedIndex].value;   
        	if (YYYYvalue == ""){ var e = document.getElementById("SDD"); optionsClear(e); return;}   
        	var n = MonHead[str - 1];   
        	if (str ==2 && IsPinYear(YYYYvalue)) n++;   
       			writeSDD(n);   
   		} 
		   
		function EYYYYDD(str) //年发生变化时日期发生变化(主要是判断闰平年)   
   		{   
           	var endM = document.getElementById("EMM");
           	var MMvalue = endM.options[endM.selectedIndex].value;   
           	if (MMvalue == ""){ var e = document.getElementById("EDD"); optionsClear(e); return;}   
           	var n = MonHead[MMvalue - 1];   
           	if (MMvalue ==2 && IsPinYear(str)) n++;   
                writeEDD(n);   
   		}   
   		function EMMDD(str)   //月发生变化时日期联动   
   		{   
        	var endY = document.getElementById("EYYYY");
        	var YYYYvalue = endY.options[endY.selectedIndex].value;   
        	if (YYYYvalue == ""){ var e = document.getElementById("EDD"); optionsClear(e); return;}   
        	var n = MonHead[str - 1];   
        	if (str ==2 && IsPinYear(YYYYvalue)) n++;   
       			writeEDD(n);   
   		}  
		   
   		function writeSDD(n)   //据条件写日期的下拉框   
   		{   
           var e = document.getElementById("SDD"); optionsClear(e);   
           for (var i=1; i<(n+1); i++)   
                e.options.add(new Option(" "+ i + " 日", i));   
   		}
		function writeEDD(n)   //据条件写日期的下拉框   
   		{   
           var e = document.getElementById("EDD"); optionsClear(e);   
           for (var i=1; i<(n+1); i++)   
                e.options.add(new Option(" "+ i + " 日", i));   
   		}  
   		function IsPinYear(year)//判断是否闰平年   
   		{     return(0 == year%4 && (year%100 !=0 || year%400 == 0));}   
   		
		function optionsClear(e)   
   		{   
        	e.options.length = 1;   
   		}   
   </script>

</html>