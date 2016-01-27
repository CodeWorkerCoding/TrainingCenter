<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部明星</title>
</head>
<body>
		<table class="mytable table table-hover">
			<caption>全部的明星列表</caption>
			<tbody>
				<thead>
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>别名</th>
						<th>描述</th>
						<th>添加时间</th>
						<th>最近修改时间</th>
						<th>操作</th>
					</tr>
				</thead>			
				<c:forEach var="star" items="${stars}" >
					<tr>
						<td>${star._id}</td>
						<td>${star.name}</td>
						<td>${star.nickname}</td>
						<td>${star.mensurations}</td>
						<td>${star.createTime}</td>
						<td>${star.updateTime}</td>
						<td>
							<a href="/star/${star._id}/modify"><span>修改</span></a>
							<a href="/star/${star._id}/del"><span>删除</span></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>