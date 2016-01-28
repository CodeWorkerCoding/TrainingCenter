<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有的Ed2k</title>
</head>
<body>
	<table class="mytable table table-hover">
		<caption>所有的Ed2k地址</caption>
		<tbody>
			<thead>
				<tr>
					<th>作品名称</th>
					<th>主演明星</th>
					<th>Ed2k地址</th>
					<th>添加时间</th>
					<th>最近修改时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="ed2k" items="${ed2ks}">
				<tr>
					<td><a href="/ed2k/${ed2k._id}/look">${ed2k.designation}</a></td>
					<td><a href="/star/${ed2k.star._id}/look">${ed2k.star.name}</a></td>
					<td><a href="${ed2k.ed2k}">${ed2k.ed2k}</a></td>
					<td>${ed2k.createTime}</td>
					<td>${ed2k.updateTime}</td>
					<td>
						<a href="/ed2k/${ed2k._id}/modify"><span>修改</span></a>
						<a href="/ed2k/${ed2k._id}/del"><span>删除</span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav class="col-sm-offset-4 col-sm-8">
		<ul class="pagination">
		    <li><a href="#">上一页</a></li>
		    <li class="active"><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">下一页</a></li>
		 </ul>
	</nav>
</body>
</html>