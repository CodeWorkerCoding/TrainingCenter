<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加一个新的Ed2k</title>
</head>
<body>

		<form class="form-horizontal form" action="/ed2k/save" method="post">
			<div class="form-group">
				<label for="designation" class="col-sm-2 control-label">作品名称</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="designation" name="designation" autocomplete="on" placeholder="请输入番号...">
				</div>
			</div>
			<div class="form-group">
				<label for="selstar" class="col-sm-2 control-label">请选择参演主演</label>
				<div class="col-sm-8">
					<select class="form-control" id="selstar" name="star">
						<option>--请选择--</option>
						<c:forEach var="star" items="${stars}">
							<option value="${star._id}">${star.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="areaed2k" class="col-sm-2 control-label">Ed2ks</label>
				<div class="col-sm-8">
					<textarea id="areaed2k" rows="15" class="form-control" placeholder="请输入Ed2k地址...." name="ed2k" aria-describedby="areahelp" onchange="javascript:checkEd2k();"></textarea>
					<span id="areahelp" class="help-block">
						请入Ed2k地址，如果由多个地址请用回车加以区分.
					</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<button type="submit" class="btn btn-primary" id="submit" disabled="disabled">提交</button>
					<button type="reset" class="btn btn-default">重新提交</button>
				</div>
			</div>
		</form>
</body>
</html>