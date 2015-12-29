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

    <title>采编 - 查看软文</title>

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
                        <li><a href="editorIndex"><i class="fa fa-user fa-fw"></i>${user.userName }</a>
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
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">  
                                <div class="col-lg-12">
					               <h2 align="center">${artNews.title }</h2>
				                </div>
                            </div>
                            
                            <div class="row" style="margin: 10px 30px 10px 30px;">  
                                <div class="col-lg-3">
					               <p  align="center"><small>作者：${user.userName }</small></p>
				                </div>
                                <div class="col-lg-3">
					               <p  align="center"><small>类型：${artNews.type}</small></p>
				                </div>
                                <div class="col-lg-3">
					               <p  align="center"><small>栏目: ${dateAndPositionList[0].columnID}</small></p>
				                </div>
                                <div class="col-lg-3">
					               <p  align="center"><small>时间: ${artNews.editTime}</small></p>
				                </div>
                            </div>
			                <div class="row">  
                                <div class="col-lg-12">
					               <p  align="center"><img src="${artNews.imageURL}" width="320px"/></p>
				                </div>
                            </div>
				            <div class="row">
                                <div class="col-lg-1">
					               
				                </div>
                                <div class="col-lg-10">
                                    <br/>
					               <label>摘要:</label>
					               <p style="text-indent: 2em; font-size:14px;">${artNews.summary}</p>
				                </div>
                                <div class="col-lg-1">
					               
				                </div>
				            </div>
                            <div class="row">
                                <div class="col-lg-1">
					               
				                </div>
                                <div class="col-lg-10">
                                    <br/>
					               <label>正文:</label>
					               <p style="font-size:14px;">${artNewsContent.content}</p>
				                </div>
                                <div class="col-lg-1">
					               
				                </div>
				            </div>
				
                           
                        </div>  
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
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

</html>
