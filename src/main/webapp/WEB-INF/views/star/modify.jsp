<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${star.name}</title>
</head>
<body>
	<form action="/star/${star._id}/update"
		method="POST" name="star" class="form-horizontal">
		<div class="my-panel">
			<div class="form-group ">
				<h2 class="info-heading col-sm-3 col-sm-offset-5"><strong>${star.name}</strong> 信息更改</h2>
			</div>
			<div class="form-group">
				<label for="starname" class="col-sm-2 control-label col-sm-offset-2">姓名:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="starname" name="name" value="${star.name}">
				</div>
			</div>
			<div class="form-group">
				<label for="nickname" class="col-sm-2 control-label col-sm-offset-2">别名:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="nickname" name="nickname" value="${star.nickname}">
				</div>
			</div>
			<div class="form-group">
				<label for="mensurations" class="col-sm-2 control-label col-sm-offset-2">描述信息:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="mensurations" name="mensurations" value="${star.mensurations}">
				</div>
			</div>
			<div class="form-group">
				<label for="lately" class="col-sm-2 control-label col-sm-offset-2">头像图片路径:</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="lately" name="lately"
						 value="${star.lately}" readonly="readonly">
					<span class="help-block">
						这里显示该明星头像在服务器端存储的路径信息，只读的。
					</span>
				</div>
			</div>
			<div class="form-group">
					<div class="col-sm-offset-4">
						<div class="col-sm-6">
							<a href="#" class="thumbnail">
								<img alt="${star.name}" src="${star.lately}">
							</a>
						</div>
					</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-6">
					<button type="submit" class="btn btn-primary" id="submit">提交</button>
					<a class="btn btn-default" href="javascript:history.back();"><span>取消</span></a>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</div>
	</form>
</body>
</html>