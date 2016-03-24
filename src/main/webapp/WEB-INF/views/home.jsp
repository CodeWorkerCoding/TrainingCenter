<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="明星参演作品收集网站">
    <meta name="author" content="">
    <title>Home</title>
    <!-- Custom styles for this template -->
    <link href="<%=root%>/css/dashboard.css" rel="stylesheet">
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">明星作品收集网站</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/home"><i class="gylphicon gylphicon-home"> </i>主页</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="#">联系我们</a></li>
            <%-- <li><a href="#">${pageContext.request.userPrincipal.name}</a></li> --%>
            <li><a href="javascript:$('#logoutForm').submit();">登出</a></li>
          </ul>
          <c:url value="/j_spring_security_logout" var="logoutUrl" />
		  <!-- csrt for log out-->
		  <form action="${logoutUrl}" method="post" id="logoutForm">
		     <input type="hidden" 
			   	name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		  </form>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
	<!-- <span class="sr-only">xxxxx</span> 前台也页面不可见 -->
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="star active">
           		<a href="javascript:void(0);" onclick="loadByClass('/star/allbypage','.star')">
           			<i class="glyphicon glyphicon-user"> </i>
           			<span>明星</span>
           			</a>
           	</li>
            <li class="adds">
           		<a href="javascript:void(0);" onclick="loadByClass('/star/add','.adds')">
           			<i class="glyphicon glyphicon-plus"> </i>
           			<span>添加一个明星</span>
           		</a>
           	</li>
            <li class="alls">
           		<a href="javascript:void(0);" onclick="loadByClass('/star/allbypage','.alls')">
           			<i class="glyphicon glyphicon-text-color"> </i>
           			<span>所有明星</span>
           		</a>
           	</li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="ed2k">
           		<a href="javascript:void(0);" onclick="loadByClass('/ed2k/allbypage','.ed2k')">
           			<i class="glyphicon glyphicon-film"> </i>
           			<span>作品地址</span>
           		</a>
           	</li>
            <li class="adde">
           		<a href="javascript:void(0);" onclick="loadByClass('/ed2k/add','.adde')">
           			<i class="glyphicon glyphicon-plus"> </i>
           			<span>添加一个作品种子</span>
           		</a>
           	</li>
            <li class="alle">
           		<a href="javascript:void(0);" onclick="loadByClass('/ed2k/allbypage','.alle')">
           			<i class="glyphicon glyphicon-text-color"> </i>
           			<span>所有的种子</span>
           		</a>
           	</li>
          </ul>
          
          <ul class="nav nav-sidebar">
          	<li class="item">
          		<a href="javascript:void(0);" onclick="loadByClass('/item/all','.item')">
          			<i class="glyphicon glyphicon-cog"> </i>
           			<span>菜单列表</span>
          		</a>
          	</li>
          	<li class="addi">
          		<a href="javascript:void(0);" onclick="loadByClass('/item/add','.addi')">
          			<i class="glyphicon glyphicon-plus"> </i>
           			<span>添加菜单</span>
          		</a>
          	</li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">欢迎使用明星作品收集系统</h1>
          <div class="table-responsive">
          		<iframe class="myiframe" src="/star/allbypage" scrolling="yes" frameborder="0" >
          		</iframe>          		
          </div>
          <footer>
	    		<p>&copy; (c) Copyright 2016 123. All Rights Reserved.</p>
	      </footer>
        </div>
      </div>
    </div>
  </body>
</html>
