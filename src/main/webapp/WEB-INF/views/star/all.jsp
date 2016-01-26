<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部明星</title>
</head>
<style type="text/css">
	.container{width:80%; heigth:100% ; margin: 200px auto; border: 2px solid green}
	.container .stars{padding: 20px auto; border: 2px solid red;}
</style>
<body>
	全部明星列表
	<div class="container">
		<table class="stars">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>别名</th>
				<th>描述</th>
				<th>添加时间</th>
				<th>最近修改时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="star" items="${stars}" >
				<tr>
					<td>${star._id}</td>
					<td>${star.name}</td>
					<td>${star.nickname}</td>
					<td>${star.mensurations}</td>
					<td>${star.createTime}</td>
					<td>${star.updateTime}</td>
					<td><a href="#">修改</a> <a href="#">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>