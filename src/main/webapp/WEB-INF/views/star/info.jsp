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
		<div class="form-group">
			<label class="col-md-3 control-laber" for="">姓名：</label>
			<div class="col-md-3" id="starname">${star.name}</div>
			<label class="col-md-3 control-laber" for="">描述：</label>
			<div class="col-md-3" id="starname">${star.mensurations}</div>
			<!-- http://localhost:12508/star/fcf39cb1510d4cee911cf9b7617d018a/look		 -->
		</div>
		<hr/>
		<%-- <div class="form-group">
			<c:forEach items="${star.images}" var="image">
				<img alt="" src="" class="col-md-3 img-circle">
			</c:forEach>
		</div>
		<hr/>
		<div class=form-group">
			<label class="address col-md-12">明星作品地址：</label>
			<div class="jumbotron">
				<c:forEach items="${star.ed2ks}" var="ed2k">
					<p>${ed2k.ed2k}</p>
				</c:forEach>
			</div>
		</div> --%>
</body>
</html>