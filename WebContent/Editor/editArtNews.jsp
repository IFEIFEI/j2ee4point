<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>采编后台-新稿件</title>
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
			<li><span class="active">我要写稿</span></li>
			<li><a href="getAllCommittedArtNewsByEditor">提交记录</a></li>
			<li><a href="getAllDraftByEditor">草稿箱</a></li>
	</ul>
	<div id="content" name="content" class="container_16 clearfix">
		<div class="grid_16">
					<h2>编写新文章</h2>
		</div>
			
		<form name="newArticle" id="draftform"  onsubmit="return validate_form(this)" method="post"  enctype="multipart/form-data">
			<div>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;文章类型<br/>&nbsp;&nbsp;
					<input type="radio" name="Advertorialtype" id="Advertorialtype" checked="checked" value="ads"/>广告&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="Advertorialtype" id="Advertorialtype" value="article" />资讯
				</p>
			</div>
						
			<div class="grid_5" name="startdate">
				<p name="reg_testdate">
				上线时间<br/>
				  <!--  
				<select name="SYYYY" id="SYYYY" onchange="SYYYYDD(this.value)" style="width:90px">
    				<option value="">请选择 年</option>
  				</select>
  				<select name="SMM" id="SMM" onchange="SMMDD(this.value)" style="width:80px">
    				<option value="">选择 月</option>
  				</select>
  				<select name="SDD" id="SDD" style="width:80px">
    				<option value="">选择 日</option>
  				</select>
  				-->
  				<input type="date" name="startDate"/>
				<br />
				</p>
			</div>
			
			<div class="grid_5" name="enddate">
				<p name="reg_testdate">
				下线时间<br/>
				<!--  
				<select name="EYYYY" id="EYYYY" onchange="EYYYYDD(this.value)" style="width:90px">
    				<option value="">请选择 年</option>
  				</select>
  				<select name="EMM" id="EMM" onchange="EMMDD(this.value)" style="width:80px">
    				<option value="">选择 月</option>
  				</select>
  				<select name="EDD" id="EDD" style="width:80px">
    				<option value="">选择 日</option>
  				</select>
  				-->
  				<input type="date" name="endDate"/>
				<br />
				</p>
			</div>
			
			<div class="grid_3" name="article_div1" id="article_div1">
				<p>
				所在栏目
				<select id="article_type" name="columnID" style="width:140px">
					<option>artist</option>
					<option>artwork</option>
					<option>show</option>
					<option>other</option>
				</select>
				</p>
			</div>
			
			<div class="grid_3" name="article_div2" id="article_div2">
				<p>
				资讯/广告顺序
				<input type="text" id="article_pos" name="article_pos" placeholder="请输入数字" oninput="checkAticle_pos()" style="width:140px">
				<lable><small id="err" style="color:red">&nbsp;</small></lable>
				</p>
			</div>
			
			<div class="grid_9">
				<p>
				<label>标题</label>
				<input type="text" name="title" id="title" placeholder="your title..." style="width:460px; height:25px;"/>
				<br/><br/>
				<label>标题图片</label>
				<!--
				<a href="javascript:;" class="file">选择文件
					<input type="file" name="thefile" id="doc" onchange="javascript:setImagePreview();"/> 
				</a>
				-->
				<asp:Image ID="img_name" runat="server" />
    			<input type="file" onchange="javascript:setImagePreview();" id="doc" name="thefile" style="width:460px; height:25px;"/>
				</p>
			</div>
			
			<div class="grid_7">
				<p>
				图片预览<br/>
				<img id="preview" name="preview" src=""/>
				<br/>
				</p>
			</div>
			
			<div class="grid_16">
				<p>
				<label>文章简介</label>
				<textarea name="adv_dis" id="adv_dis" rows="4" style="resize:none">
				</textarea>
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
                <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
                <script id="ueditor"   name="ueditor" type="text/plain" style="width:950px;height:500px;"></script>
                <script type="text/javascript">
//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                 var ue = UE.getEditor('ueditor');
                 </script>
			</p>
			</div>
				
			<div class="grid_16">
			<p align="right">
				<input type="submit" class="btn" style="width:100px;height:30px;" value="存入草稿箱" onclick="buttonsave()"/>
				&nbsp;&nbsp;
				<input type="submit" class="btn" style="width:100px;height:30px;" value="提交" onclick="buttonsubmit()"/>
			</p>
			</div>	
			
		</form>
		</div>
		
		<div id="foot">
					<a href="#">联系我们</a>
		</div>
	</body>
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
		function buttonsave()
	     {
	    	 alert("保存成功");
	document.getElementById("draftform").action="saveDraft";
	document.getElementById("draftform").submit();
	     }
	     function buttonsubmit()
	     {
	    	 alert("提交成功");
	document.getElementById("draftform").action="submitDraft";
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
    
           startY.value = y;   
           startM.value = new Date().getMonth() + 1;
		   endY.value = y;   
           endM.value = new Date().getMonth() + 1;
		      
           var n = MonHead[new Date().getMonth()];
		   var startD = document.getElementById("SDD");
		   var endD = document.getElementById("EDD");   
           if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;   
                writeSDD(n); writeEDD(n);//赋日期下拉框Author:meizz   
           startD.value = new Date().getDate();
		   endD.value = new Date().getDate();   
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
   <script type="text/javascript">
    function checkPic() {
            var picPath = document.getElementById("picPath").value;
            var type = picPath.substring(picPath.lastIndexOf(".") + 1, picPath.length).toLowerCase();
            if (type != "jpg" && type != "bmp" && type != "gif" && type != "png") {
                alert("请上传正确的图片格式");
                return false;
            }
            return true;
        }
        function showimg() {
            if(checkPic()){
            var img = document.getElementById("cardpic").value;
            document.getElementById("img_name").src =img;
        }
        }
  </script>
  
  <script type="text/javascript">
	//下面用于图片上传预览功能
	function setImagePreview(avalue) {
	var docObj=document.getElementById("doc");
 
	var imgObjPreview=document.getElementById("preview");
	if(docObj.files &&docObj.files[0])
	{
		//火狐下，直接设img属性
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '320px';
		imgObjPreview.style.height = '240px'; 
		//imgObjPreview.src = docObj.files[0].getAsDataURL();
 
		//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	}
	else
	{
		//IE下，使用滤镜
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		var localImagId = document.getElementById("localImag");
		//必须设置初始大小
		localImagId.style.width = "320px";
		localImagId.style.height = "240px";
		//图片异常的捕捉，防止用户修改后缀来伪造图片
		try{
		localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
		localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
	}
	catch(e)
	{
		alert("您上传的图片格式不正确，请重新选择!");
		return false;
	}
	imgObjPreview.style.display = 'none';
	document.selection.empty();
	}
	return true;
}
 
</script>

</html>