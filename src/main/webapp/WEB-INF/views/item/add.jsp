<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加系统菜单</title>
<style type="text/css">
.error{
	color:red; font-size: 6pt;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="panel panel-default" style="height:100%;">
			<div class="panel-heading">
				<h2 class="panel-title">&nbsp;&nbsp;添加一个系统菜单</h2>
			</div>
			<div class="panel-body">
				<form:form action="/item/add" method="post" modelAttribute="item" class="form form-horizontal">
					<div class="form-group">
						<form:label path="title" class="col-sm-2 control-label">菜单名称</form:label>
						<div class="col-sm-8">
							<form:input path="title" class="form-control" autocomplete="on" placeholder="例如：系统菜单清单" />
							<form:errors path="title" class="help-block error"/>
						</div>
					</div>
					<div class="form-group">
						<form:label path="itemId" class="col-sm-2 control-label">菜单编号</form:label>
						<div class="col-sm-3">
							<form:input path="itemId" type="number" class="form-control" autocomplete="on" placeholder="例如：1" />
							<form:errors path="itemId" class="help-block error"/>
						</div>
						<form:label path="pItemId" class="col-sm-2 control-label">父菜单编号</form:label>
						<div class="col-sm-3">
							<form:input path="pItemId" class="form-control" type="number" autocomplete="on" placeholder="没有父菜单可不填，例如：'' 、 2" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="icon" class="col-sm-2 control-label">菜单图标</form:label>
						<div class="col-sm-5">
							<form:input path="icon" class="form-control" autocomplete="on" placeholder="例如： 'glyphicon glyphicon-plus'" />
						</div>
						<form:label path="orderNo" class="col-sm-2 control-label">菜单序号</form:label>
						<div class="col-sm-1">
							<form:input path="orderNo" type="number" class="form-control" autocomplete="on" placeholder="例如：4" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="url" class="col-sm-2 control-label">响应路径</form:label>
						<div class="col-sm-8">
							<form:input path="url" class="form-control" autocomplete="on" placeholder="例如：/item/update" />
							<form:errors path="url" class="help-block"/>
						</div>
					</div>
					<div class="form-group">
						<input type="hidden" 
						   	name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="col-sm-offset-2 col-sm-8">
							<button type="submit" class="btn btn-primary" id="submit">提交</button>
							<button type="reset" class="btn btn-default">重新填写</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>