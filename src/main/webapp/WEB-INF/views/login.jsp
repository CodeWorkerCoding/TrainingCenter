<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入...</title>
</head>
<body>
	<div class="mylogin panel panel-default">
		<form action="<c:url value='j_spring_security_check' />" method="POST" class="form-horizontal">
			<div class="form-group">
				<h2 class="col-sm-offset-4 col-sm-6">请登入...</h2>
			</div>
			<c:if test="${not empty error}">
				<div class="for-group error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="for-group msg">${msg}</div>
			</c:if>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="useraccount">用户名:</label>
				<div class="col-sm-7">
					<input type="text" name="username" id="useraccount" class="form-control" placeholder="用户名" required="required" autofocus="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="password">密码:</label>
				<div class="col-sm-7">
					<input type="password" name="password" id="password" class="form-control" placeholder="密码" required="required" />
				</div>
			</div>
			<div class="form-group">
				<div class="checkbox col-lg-offset-3 col-lg-6">
					<label>
						<input type="checkbox" name="remember" value="1"> 记住我
					</label>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-3 ">
					<input type="submit" value="登 入" class="btn btn-primary btn-block"/>
				</div>
				<div class="col-sm-4">
					<a href="/sec/user/add" class="btn btn-default"><span>没有账号，去注册 &raquo;</span></a>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		</form>
	</div>
</body>
</html>