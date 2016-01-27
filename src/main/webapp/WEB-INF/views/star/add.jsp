<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加star</title>
</head>
<body>
	<form action="/star/save" method="post" class="form-horizontal form">
		<div class="form-group">
			<label for="starname" class="col-sm-3 control-label">明星姓名</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="starname" name="name" placeholder="请输入明星的姓名" autocomplete="on">
			</div>
		</div>
		<div class="form-group">
			<label for="nickname" class="col-sm-3 control-label">明星别名</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="nickname" name="nickname">
			</div>
		</div>
		<div class="form-group">
			<label for="mensurations" class="col-sm-3 control-label">明星描述</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="mensurations" name="mensurations" placeholder="请输入三围数据,使用','分割...">
			</div>
		</div>
		<div class="form-group">
			<label for="starimage" class="col-sm-3 control-label">请上传明星图片</label>
			<div class="col-sm-6">
				<input type="file" class="form-control" id="starimage" name="image">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-6">
				<button type="submit" class="btn btn-primary">提交</button>
				<button type="reset" class="btn btn-default">重新填写</button>
			</div>
		</div>
		<!-- <div class="form-group">
			<label for="" class="col-sm-2 control-label"></label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="">
			</div>
		</div> -->
	</form>
</body>
</html>