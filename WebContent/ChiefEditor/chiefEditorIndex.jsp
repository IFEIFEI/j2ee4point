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

    <title>主编 - 个人中心</title>

    <!-- Bootstrap Core CSS -->
    <link href="style/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="style/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Timeline CSS -->
    <link href="style/dist/css/timeline.css" rel="stylesheet">
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
                        <li><a href="chiefEditorIndex"><i class="fa fa-user fa-fw"></i> ${user.userName }</a>
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
                    <h2 class="page-header">欢迎，${user.userName }</h2>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
             <div class="col-lg-6"><h4>
                    <script language="JavaScript" type="text/javascript"> 
                        var today=new Date(); 
                        var strDate=("今天是 "+today.getFullYear()+"年"+(today.getMonth()+1)+"月"+today.getDate()+"日"); 
                        var n_day=today.getDay(); 
                        switch(n_day){ 
                            case 0: 
                            {strDate=strDate+" 星期日 "}break; 
                            case 1: 
                            {strDate=strDate+" 星期一 "}break; 
                            case 2: 
                            {strDate=strDate+" 星期二 "}break; 
                            case 3: 
                            {strDate=strDate+" 星期三 "}break; 
                            case 4: 
                            {strDate=strDate+" 星期四 "}break; 
                            case 5: 
                            {strDate=strDate+" 星期五 "}break; 
                            case 6: 
                            {strDate=strDate+" 星期六 "}break; 
                            case 7: 
                            {strDate=strDate+" 星期日 "}break; 
                        } 
                        document.write(strDate); 
                    </script> 
                    </h4>
                </div>
            </div>
            <br/>
            <!-- /.row -->
            <div class="row">
                
                <div class="col-lg-6 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-th-list fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">待审核列表</div>
                                    <div>UncheckedArtNews</div>
                                </div>
                            </div>
                        </div>
                        <a href="getCheckPendingList">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-6 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-list-alt fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">我的审核记录</div>
                                    <div>CheckedNumber篇已审核软文</div>
                                </div>
                            </div>
                        </div>
                        <a href="getArtNewsByChiefEditor">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-user fa-fw"></i> 用户个人信息
                            <div class="pull-right">
                                <button type="button" class="btn btn-default btn-xs">
                                   <i class="fa fa-edit fa-fw"></i>编辑
                                </button>
                            </div>
                        </div>
                        <div class="panel-body">
                        
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bell fa-fw"></i> 新消息
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group">
                                <a href="getCheckPendingList" class="list-group-item">
                                    <i class="fa fa-envelope fa-fw"></i> 3 篇待审核软文
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-upload fa-fw"></i> 2 篇软文被发布
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-tasks fa-fw"></i> 3 篇软文下线
                                </a>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                
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
