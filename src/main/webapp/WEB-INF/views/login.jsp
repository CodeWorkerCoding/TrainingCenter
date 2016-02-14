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
		<c:url value="/login" var="loginUrl"/>
		<form action="${loginUrl}" method="post" class="form-horizontal">
			<div class="form-group">
				<h2 class="col-sm-offset-4 col-sm-6">请登入...</h2>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="useraccount">账户:</label>
				<div class="col-sm-7">
					<input type="text" name="username" id="useraccount" class="form-control" placeholder="邮箱" required="required" autofocus="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="password">密码:</label>
				<div class="col-sm-7">
					<input type="password" name="password" id="password" class="form-control" placeholder="密码" required="required" />
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${csrf.token}"/>
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
					<a href="#" class="btn btn-default"><span>没有账号，去注册 &raquo;</span></a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>