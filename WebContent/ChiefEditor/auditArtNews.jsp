<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>主编 - 审核软文</title>

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
                <a class="navbar-brand" href="chiefEditorIndex">艺术品订制网站后台管理系统</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="chiefEditorIndex"><i class="fa fa-user fa-fw"></i>${user.userName}</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="userLogout"><i class="fa fa-sign-out fa-fw"></i>登出</a>
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
                            <a href="chiefEditorIndex"><i class="fa fa-user fa-fw"></i> 个人中心</a>
                        </li>
                        <li>
                            <a href="getCheckPendingList"><i class="fa fa-th-list fa-fw"></i> 待审核软文</a>
                        </li>
                        <li>
                            <a href="getArtNewsByChiefEditor"><i class="fa fa-list-alt fa-fw"></i> 我的审核记录</a>
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
                    <h2 class="page-header">审核软文</h2>
                </div>
            </div>
          
            <div class="row" id="edit_div" style="display:none">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            编辑软文
                            <div class="pull-right">
                                <button type="button" class="btn btn-default btn-xs" onclick="">
                                   <i class="fa fa-file-o fa-fw"></i>
                                </button>
                            </div>
                        </div>
                        <div class="panel-body">
                            
<form name="newArticle" id="draftform"  onsubmit="return validate_form(this)" method="post"  >
			<div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label>文章类型</label><br/>
                                            <c:if test="${artNews.type!='article' }">
                                            <label class="radio-inline">

					
					<input type="radio" name="Advertorialtype" id="Advertorialtype" checked="checked" value="ads"/>
					广告</label>
                                            <label class="radio-inline">

					<input type="radio" name="Advertorialtype" id="Advertorialtype" value="article" />资讯</label></c:if>
					                                            <c:if test="${artNews.type=='article' }">
                                            <label class="radio-inline">

					<input type="radio" name="Advertorialtype" id="Advertorialtype"  value="ads"/>
					广告</label>
                                            <label class="radio-inline">

					<input type="radio" name="Advertorialtype" id="Advertorialtype" value="article" checked="checked"/>资讯</label></c:if>
				</div>
                                    </div>
                                </div>
                                <div class="row">
                                <div class="col-lg-3">
                                       <div class="form-group" name="startdate">
                                            <label>上线时间</label>
  				<input type="date" name="startDate" value="${dateAndPositionList[0].publishDate }"/>
				 </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="form-group" name="enddate">
                                            <label>下线时间</label>
  				<input type="date" name="endDate" value="${dateAndPositionList[fn:length(dateAndPositionList)-1].publishDate }"/>
				</div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="form-group" name="article_div1" id="article_div1">
                                            <label>所在栏目</label>
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
				</div>
                </div>
                <div class="col-lg-3">
			<div class="form-group">
<label>资讯/广告顺序</label>
				<input type="text" id="article_pos" name="article_pos" value="${dateAndPositionList[0].priority }" oninput="checkAticle_pos()" style="width:140px">
				<lable><small id="err" style="color:red">&nbsp;</small></lable>
				</div>
                                    </div>
                                </div>
                                    
                                <div class="row">    
                                    <div class="col-lg-8">
                                        <br/><br/>
                                        <div class="form-group">
                                            <label>软文标题</label>
<input type="text" name="title" id="title" class="form-control" value="${artNews.title }"></input>
                                        </div>
         
                                        <div class="form-group">
                                            <label>文章简介</label>
                                            <textarea name="adv_desc" id="adv_desc" class="form-control" rows="4" >${artNews.summary }</textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-4">
                                        <br/><br/>
                                        <div class="form-group">
                                            <!--提交图片时提交preview的src-->
                                            <label>标题图片</label>
                                            <asp:Image ID="img_name" runat="server" />
    			                            <input type="file" onchange="javascript:setImagePreview();" id="doc" name="thefile"/>
                                        </div>
                                        <div class="form-group">
                                            <img id="preview" name="preview" src="${artNews.imageURL }"/>
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
                                        <br/>
                                        <br/>
                                        <p class="pull-right">
                                            <input type="button" class="btn btn-outline btn-info" value="审核通过" onclick="buttonapprove()"/>
			                                <input type="submit" class="btn btn-default btn-success" value="退回修改" onclick="buttondisapprove()"/>
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
            
            
            
            <div class="row" id="preview_div">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            待审核软文
                            <div class="pull-right">
                                <button type="button" class="btn btn-default btn-xs" onclick="BacktoEdit()">
                                   <i class="fa fa-edit fa-fw"></i>编辑
                                </button>
                                <button type="button" class="btn btn-default btn-xs" onclick="approveArtNews?artNewsId=${artNews.id}">
                                   <i class="fa fa-check fa-fw"></i>通过
                                </button>
                                <button type="button" class="btn btn-default btn-xs" onclick="if(window.confirm('确定放弃该软文吗？')) this.href='disapproveArtNews?artNewsId=${artNews.id}'">
                                   <i class="fa fa-times fa-fw"></i>不通过
                                </button>
                            </div>
                        </div>
                        <div class="panel-body">
                            
                            <form role="form" name="previewform" id="previewform" action="" method="post">
                                
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    属性
                                </div>
                                <div class="panel-body"> 
                                    <div class="row">  
                                        <div class="col-lg-12">
					                       <p>文章类型：<span id="advType">${artNews.type}</span></p>
                                        </div>
                                        <div class="col-lg-3">
                                            <p>上线时间：<span id="advSY"><input type="date" value="${dateAndPositionList[0].publishDate}"></</input></span></p>
				                        </div>
                                        <div class="col-lg-3">
                                            <p>下线时间：<span id="advEY"><input type="date" value="${dateAndPositionList[fn:length(dateAndPositionList)-1].publishDate }"></</input></span></p>
				                        </div>
                                        <div class="col-lg-3">
                                            <p>所在栏目：<span id="advColumn">${dateAndPositionList[0].columnID}</span></p>
				                        </div>
                                        <div class="col-lg-3">
                                            <p>在栏目中的排位：<span id="advPosition">${dateAndPositionList[0].priority}</span></p>
				                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    软文预览
                                </div>
                                <div class="panel-body">
                                    <div class="row">  
                                        <div class="col-lg-12">
					                       <h3 id="ptitle" align="center">${artNews.title}</h3>
				                        </div>
                                    </div>
                            
                                    <div class="row" style="margin: 10px 90px 10px 90px;">  
                                        <div class="col-lg-3">
					                       <p align="center" style="font-size:14px">作者：<span id="pauthor">${artNews.editor.userName}</span></p>
				                        </div>
                                        <div class="col-lg-3">
					                       <p align="center" style="font-size:14px">类型：<span id="ptype">${artNews.type}</span></p>
				                        </div>
                                        <div class="col-lg-3">
					                       <p align="center" style="font-size:14px">栏目: <span id="pcol">${dateAndPositionList[0].columnID}</span></p>
				                        </div>
                                        <div class="col-lg-3">
					                       <p align="center" style="font-size:14px">时间: <span id="ptime">${artNews.editTime}</span></p>
				                        </div>
                                    </div>
			                        <div class="row">  
                                        <div class="col-lg-12">
					                       <p  align="center"><img id="pimg" src="${artNews.imageURL}" width="380px"/></p>
				                        </div>
                                    </div>
				                    <div class="row">
                                        <div class="col-lg-1">
					               
				                        </div>
                                        <div class="col-lg-10">
                                           <br/>
					                       <label style="font-size:16px;">摘要:</label>
					                       <p  id="pdesc" style="text-indent: 2em; font-size:16px;">${artNews.summary}</p>
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
					                       <p id="pcontext" style="font-size:16px;">${artNewsContent.content}</p>
				                        </div>
                                        <div class="col-lg-1">
					               
				                        </div>
				                    </div>
                                </div>
                            </div>
                            </form>  
                        </div>
                    </div>
                </div>
            </div>
            
            
            <!--测测测测测试用-->
            <!--
            <div class="row" id="preview_div">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            待审核软文
                            <div class="pull-right">
                                <button type="button" class="btn btn-default btn-xs" onclick="BacktoEdit()">
                                   <i class="fa fa-edit fa-fw"></i>编辑
                                </button>
                                <button type="button" class="btn btn-default btn-xs" onclick="">
                                   <i class="fa fa-check fa-fw"></i>通过
                                </button>
                                <button type="button" class="btn btn-default btn-xs" onclick="if(window.confirm('确定放弃该软文吗？')) this.href=''">
                                   <i class="fa fa-times fa-fw"></i>不通过
                                </button>
                            </div>
                        </div>
                        <div class="panel-body">
                            
                            <form role="form" name="previewform" id="previewform" action="" method="post">
                                
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    属性
                                </div>
                                <div class="panel-body"> 
                                    <div class="row">  
                                        <div class="col-lg-12">
					                       <p>文章类型：<span id="advType">资讯</span></p>
                                        </div>
                                        <div class="col-lg-3">
                                            <p>上线时间：<span id="advSY">2015</span>/<span id="advSM">12</span>/<span id="advSD">28</span></p>
				                        </div>
                                        <div class="col-lg-3">
                                            <p>下线时间：<span id="advEY">2016</span>/<span id="advEM">1</span>/<span id="advED">8</span></p>
				                        </div>
                                        <div class="col-lg-3">
                                            <p>所在栏目：<span id="advColumn">其他资讯/广告</span></p>
				                        </div>
                                        <div class="col-lg-3">
                                            <p>在栏目中的排位：<span id="advPosition">3</span></p>
				                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    软文预览
                                </div>
                                <div class="panel-body">
                                    <div class="row">  
                                        <div class="col-lg-12">
					                       <h3 id="ptitle" align="center">王老菊教你喜加一</h3>
				                        </div>
                                    </div>
                            
                                    <div class="row" style="margin: 10px 90px 10px 90px;">  
                                        <div class="col-lg-3">
					                       <p align="center" style="font-size:14px">作者：<span id="pauthor">王老菊</span></p>
				                        </div>
                                        <div class="col-lg-3">
					                       <p align="center" style="font-size:14px">类型：<span id="ptype">资讯</span></p>
				                        </div>
                                        <div class="col-lg-3">
					                       <p align="center" style="font-size:14px">栏目: <span id="pcol">其他资讯/广告</span></p>
				                        </div>
                                        <div class="col-lg-3">
					                       <p align="center" style="font-size:14px">时间: <span id="ptime">2015/12/26</span></p>
				                        </div>
                                    </div>
			                        <div class="row">  
                                        <div class="col-lg-12">
					                       <p  align="center"><img id="pimg" src="../images/admin/index_background2.gif" width="380px"/></p>
				                        </div>
                                    </div>
				                    <div class="row">
                                        <div class="col-lg-1">
					               
				                        </div>
                                        <div class="col-lg-10">
                                           <br/>
					                       <label style="font-size:16px;">摘要:</label>
					                       <p  id="pdesc" style="text-indent: 2em; font-size:16px;">两个黄鹂鸣翠柳，你还没有女朋友。雌雄双兔傍地走，你还没有女朋友。一江春水向东流，你还没有女朋友。问君能有几多愁，你还没有女朋友。</p>
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
                            </form>  
                        </div>
                    </div>
                </div>
            </div>
            -->
            
            
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../style/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../style/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../style/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../style/dist/js/admin.js"></script>

</body>
<script type="text/javascript">
		function Preview(){
            
            var f = document.getElementById("editform");
            if(validate_form(f)==false)
                return false;
            
            //{
            document.getElementById("edit_div").style.display="none";
      		document.getElementById("preview_div").style.display="";
            
            //上下线时间
            var sy = document.getElementById("SYYYY").value;
		    var ey = document.getElementById("EYYYY").value;
            var sm = document.getElementById("SMM").value;
		    var em = document.getElementById("EMM").value;
            var sd = document.getElementById("SDD").value;
		    var ed = document.getElementById("EDD").value;
            sy = parseInt(sy);
            sm = parseInt(sm);
            sd = parseInt(sd);
            ey = parseInt(ey);
            em = parseInt(em);
            ed = parseInt(ed);
            document.getElementById("advSY").innerHTML = sy;
            document.getElementById("advSM").innerHTML = sm;
            document.getElementById("advSD").innerHTML = sd;
            document.getElementById("advEY").innerHTML = ey;
            document.getElementById("advEM").innerHTML = em;
            document.getElementById("advED").innerHTML = ed;
            
            
            //标题
            var title = document.getElementById("title").value;
            document.getElementById("ptitle").innerHTML = title;
            
            //document.getElementById("pauthor").innerHTML = "Username";
            //文章类型
            if(document.getElementsByName("Advertorialtype")[0].checked){
      			document.getElementById("ptype").innerHTML = "广告";
                document.getElementById("advType").innerHTML = "广告";
   			}else{
     		  	document.getElementById("ptype").innerHTML = "资讯";
                document.getElementById("advType").innerHTML = "资讯";
    		}
            
            //栏目
            var art_options = document.getElementById("article_type").options;
			for (i=0; i<art_options.length; i++){
		        if (art_options[i].selected) 
					var t=art_options[i].value;
            }
            document.getElementById("pcol").innerHTML = t;
            document.getElementById("advColumn").innerHTML = t;
            
            //在栏目中的排位
            var p = document.getElementById("article_pos").value;
            document.getElementById("advPosition").innerHTML = p;
            
            //标题图
            var imgObjPreview=document.getElementById("preview");
            document.getElementById("pimg").src = imgObjPreview.src;
            
            //简介
            var d = document.getElementById("adv_desc").value;
            document.getElementById("pdesc").innerHTML = d;
            
            //正文
            //var c = document.getElementById("container").innerHTML.body;
            //document.getElementById("pcontext").innerHTML = c;
           // }
           
		}
        
        function BacktoEdit(){
      		document.getElementById("preview_div").style.display="none";
      		document.getElementById("edit_div").style.display="";
            
            //类型
            var t = document.getElementById("advType").innerText;
            var t1;
            if(t=="广告")
            {   t1 = "ads";     }
            else
            {   t1 = "article"; }
            var selects = document.getElementsByName("Advertorialtype");  
   				 for (var i=0; i<selects.length; i++){  
       				 if (selects[i].value==t1) {  
            			selects[i].checked= true;  
            			break;  
        			}  
    			}
		    
            //上下线时间
            var starty = document.getElementById("advSY").innerText;
            var startm = document.getElementById("advSM").innerText;
            var startd = document.getElementById("advSD").innerText;
            var endy = document.getElementById("advEY").innerText;
            var endm = document.getElementById("advEM").innerText;
            var endd = document.getElementById("advED").innerText;
            
            var startY = document.getElementById("SYYYY");
		    var endY = document.getElementById("EYYYY");
            var startM = document.getElementById("SMM");
		    var endM = document.getElementById("EMM");
            var startD = document.getElementById("SDD");
		    var endD = document.getElementById("EDD");
            
            startY.value = starty;
            endY.value = endy;
            startM.value = startm;
            endM.value = endm;
            startD.value = startd;
            endD.value = endd;
        
            //栏目                                        
            var c = document.getElementById("advColumn").innerText;
            var c1;
            switch(c) {
                case "艺术家资讯/广告":
                    c1 = "1";
                    break;
                case "艺术品资讯/广告":
                    c1 = "2";
                    break;
                case "展出资讯/广告":
                    c1 = "3";
                    break;
                case "其他资讯/广告":
                    c1 = "4";
                    break;
            }
		    var art_options = document.getElementById("article_type").options;
			for (i=0; i<art_options.length; i++){
				if (art_options[i].id == c1) // 根据option标签的ID来进行判断
					art_options[i].selected = true;
			}
            
            //位置
            var p = document.getElementById("advPosition").innerText;
			document.getElementById("article_pos").value = ""+p;
			//article_pos.value = p;
            
            //标题
            var ti = document.getElementById("ptitle").innerText;
            document.getElementById("title").value = ti;
            
            //简介
            var d = document.getElementById("pdesc").innerText;
            document.getElementById("adv_desc").innerHTML = d;
            
            //标题图片
            var s = document.getElementById("pimg").src;
            document.getElementById("preview").src = s;
            
            //正文
            //var con = document.getElementById("pcontext").innerHTML;
            //document.getElementById("container").
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
		      
           var n = MonHead[new Date().getMonth()];  
           if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;   
                writeSDD(n); writeEDD(n);//赋日期下拉框Author:meizz   
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

</html>
