<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>采编 - 编写新软文</title>

    <!-- Bootstrap Core CSS -->
    <link href="style/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="style/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="style/dist/css/admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="style/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="editorIndex">艺术品订制网站后台管理系统</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="editorIndex"><i class="fa fa-user fa-fw"></i> ${user.userName}</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="userLogout"><i class="fa fa-sign-out fa-fw"></i> 登出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <li>
                            <a href="editorIndex"><i class="fa fa-user fa-fw"></i> 个人中心</a>
                        </li>
                        <li>
                            <a href="editNewArticle"><i class="fa fa-edit fa-fw"></i> 新文章</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-list-alt fa-fw"></i> 我的提交记录<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="getAllUnderApprovalArtNewsByEditor">待审核列表</a>
                                </li>
                                <li>
                                    <a href="getAllCheckedArtNewsByEditor">已审核列表</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="getAllDraftByEditor"><i class="fa fa-file-text fa-fw"></i> 草稿箱</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">编写新文章</h2>
                </div>
            </div>
          
            <div class="row" id="edit_div">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            编辑软文
                            <div class="pull-right">
                                <button type="button" class="btn btn-default btn-xs" onclick="Preview()">
                                   <i class="fa fa-file-o fa-fw"></i>
                                </button>
                            </div>
                        </div>
                        <div class="panel-body">
                            
                            <form name="newArticle" id="draftform"  onsubmit="return validate_form(this)" method="post"  enctype="multipart/form-data">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label>文章类型</label><br/>
                                            <label class="radio-inline">
					                           <input type="radio" name="Advertorialtype" id="Advertorialtype" checked="checked" value="ads"/>广告
                                            </label>
                                            <label class="radio-inline">
                                               <input type="radio" name="Advertorialtype" id="Advertorialtype" value="article" />资讯
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-3">
                                       <div class="form-group" name="startdate">
                                            <label>上线时间</label>
                                            <!-- 
                                            <select name="SYYYY" id="SYYYY" onchange="SYYYYDD(this.value)" class="form-control">
    				                            <option value="">请选择 年</option>
  				                            </select>
                                            <select name="SMM" id="SMM" onchange="SMMDD(this.value)" class="form-control">
    				                            <option value="">选择 月</option>
  				                            </select>
  				                            <select name="SDD" id="SDD" class="form-control">
    				                            <option value="">选择 日</option>
  				                            </select>
  				                             -->
  				                             <input type="date" name="startDate"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="form-group" name="enddate">
                                            <label>下线时间</label>
                                            <!--  
                                            <select name="EYYYY" id="EYYYY" onchange="EYYYYDD(this.value)" class="form-control">
    				                            <option value="">请选择 年</option>
  				                            </select>
                                            <select name="EMM" id="EMM" onchange="EMMDD(this.value)" class="form-control">
    				                            <option value="">选择 月</option>
  				                            </select>
  				                            <select name="EDD" id="EDD" class="form-control">
    				                            <option value="">选择 日</option>
  				                            </select>
  				                            -->
  				                            <input type="date" name="endDate"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="form-group" name="article_div1" id="article_div1">
                                            <label>所在栏目</label>
                                            <select id="article_type" name="columnID" class="form-control">
					                                <option>artist</option>
					                                <option>artwork</option>
					                                <option>show</option>
					                                <option>other</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label>资讯/广告顺序</label>
                                            <input type="text" id="article_pos" name="article_pos" placeholder="请输入数字" oninput="checkAticle_pos()" class="form-control">
                                            <lable><small id="err" style="color:red" class="pull-right"> </small></lable>
                                        </div>
                                    </div>
                                </div>
                                    
                                <div class="row">    
                                    <div class="col-lg-8">
                                        <br/><br/>
                                        <div class="form-group">
                                            <label>软文标题</label>
                                            <input type="text" name="title" id="title" class="form-control">
                                        </div>
         
                                        <div class="form-group">
                                            <label>文章简介</label>
                                            <textarea name="adv_dis" id="adv_dis" class="form-control" rows="4"></textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-4">
                                        <br/><br/>
                                        <div class="form-group">
                                            <label>标题图片</label>
    			                            <input type="file" onchange="javascript:setImagePreview();" id="doc" name="thefile"/>
                                        </div>
                                        <div class="form-group">
                                            <img id="preview" name="preview" src=""/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-lg-12">
                                        <label>软文内容</label>
       		 	                        <!-- 加载编辑器的容器 
        		<script id="container" name="content" type="text/plain">
           
        		</script>
-->
				<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
                <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
                <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
                <script id="ueditor"   name="ueditor" type="text/plain" style="height:500px;"></script>
                <script type="text/javascript">
                //实例化编辑器
                //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                 var ue = UE.getEditor('ueditor');
                 </script>
                                        <br/>
                                        <p class="pull-right">
                                            
                                            <input type="submit" class="btn btn-outline btn-info" value="存入草稿箱" onclick="buttonsave()"/>
				<input type="submit" class="btn btn-default btn-success" value="提交" onclick="buttonsubmit()"/>
                                        </p>
                                    </div>
                                </div>  
                            </form>
                        </div>  
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row" id="preview_div" style="display:none">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            预览
                            <div class="pull-right">
                                <button type="button" class="btn btn-default btn-xs" onclick="BacktoEdit()">
                                   <i class="fa fa-edit fa-fw"></i>返回编辑
                                </button>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="row">  
                                <div class="col-lg-12">
					               <h2 id="ptitle" align="center">${Advertorial.title}</h2>
				                </div>
                            </div>
                            
                            <div class="row" style="margin: 10px 100px 10px 100px;">  
                                <div class="col-lg-3">
					               <p id="pauthor" align="center" style="font-size:14px">作者：${Advertorial.author}</p>
				                </div>
                                <div class="col-lg-3">
					               <p align="center" id="ptype" style="font-size:14px">类型：${Advertorial.type}</p>
				                </div>
                                <div class="col-lg-3">
					               <p align="center" small id="pcol" style="font-size:14px">栏目: ${Advertorial.col}</p>
				                </div>
                                <div class="col-lg-3">
					               <p align="center" style="font-size:14px" id="ptime">时间: ${Advertorial.submitTime}</p>
				                </div>
                            </div>
			                <div class="row">  
                                <div class="col-lg-12">
					               <p  align="center"><img id="pimg" src="" width="380px"/></p>
				                </div>
                            </div>
				            <div class="row">
                                <div class="col-lg-1">
					               
				                </div>
                                <div class="col-lg-10">
                                    <br/>
					               <label style="font-size:16px;">摘要:</label>
					               <p  id="pdis" style="text-indent: 2em; font-size:16px;">${Advertorial.dis}</p>
				                </div>
                                <div class="col-lg-1">
					               
				                </div>
				            </div>
                            <div class="row">
                                <div class="col-lg-1">
					               
				                </div>
                                <div class="col-lg-10">
                                    <br/>
					               <label style="font-size:16px;">正文:</label>
					               <p id="pcontext" style="font-size:16px;">${Advertorial.context}</p>
				                </div>
                                <div class="col-lg-1">
					               
				                </div>
				            </div>
                        </div>  
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="style/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="style/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="style/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="style/dist/js/admin.js"></script>

</body>

<script type="text/javascript">
		function Preview(){
            
            document.getElementById("edit_div").style.display="none";
      		document.getElementById("preview_div").style.display="";
              
            var title = document.getElementById("title").value;
            document.getElementById("ptitle").innerHTML = title;
            
            document.getElementById("pauthor").innerHTML = "作者：Username";
            if(document.getElementsByName("Advertorialtype")[0].checked){
      			document.getElementById("ptype").innerHTML = "类型：广告";
   			}else{
     		  	document.getElementById("ptype").innerHTML = "类型：资讯";
    		}
            var art_options = document.getElementById("article_type").options;
			for (i=0; i<art_options.length; i++){
		        if (art_options[i].selected) 
					var t=art_options[i].value;
            }
            document.getElementById("pcol").innerHTML = "栏目："+t;
            var today=new Date(); 
            var strDate=(today.getFullYear()+"/"+(today.getMonth()+1)+"/"+today.getDate()); 
            document.getElementById("ptime").innerHTML = "时间："+strDate;
            
            var imgObjPreview=document.getElementById("preview");
            document.getElementById("pimg").src = imgObjPreview.src;
            
            var d = document.getElementById("adv_dis").value;
            document.getElementById("pdis").innerHTML = d;
            
            var c = document.getElementById("container").innerHTML.body;
            document.getElementById("pcontext").innerHTML = c;
            
		}
        function BacktoEdit(){
      		document.getElementById("preview_div").style.display="none";
      		document.getElementById("edit_div").style.display="";
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

        function timelessthan(y,m,d,sy,sm,sd)
        {
            sy = parseInt(sy);
            sm = parseInt(sm);
            sd = parseInt(sd);
            y = parseInt(y);
            m = parseInt(m);
            d = parseInt(d);
            if(sy<y) {return false;}
            else if(sy==y){
               if(sm<m){return false;}
               else if(sm==m){
                   if(sd<d){return false;}
                   else{return true;}
               }
               else{return true;}
            }
            else{return true;}
        }
        
        function validate_time()
        {
            var y = new Date().getFullYear();
            var m = new Date().getMonth() + 1;
            var d = new Date().getDate();
            var sy = document.getElementById("SYYYY").value;
		    var ey = document.getElementById("EYYYY").value;
            var sm = document.getElementById("SMM").value;
		    var em = document.getElementById("EMM").value;
            var sd = document.getElementById("SDD").value;
		    var ed = document.getElementById("EDD").value;   
            if(sy=="请选择 年"||ey=="请选择 年"||sm=="选择 月"||em=="选择 月"||sd=="选择 日"||ed=="选择 日")
            {return false;}
           
            if(timelessthan(y,m,d,sy,sm,sd)&&timelessthan(sy,sm,sd,ey,em,ed))
            {return true;}
            else{return false;}
        }
        
		function validate_form(thisform)
		{
			with (thisform)
  			{
  				if (validate_required(article_pos,"有非法输入!")==false)
    				{article_pos.focus();return false}
                if (validate_time()==false)
                    {alert("上下线时间有误！");EYYYY.focus();return false}
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
