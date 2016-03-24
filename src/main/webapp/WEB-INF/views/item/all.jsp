<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有菜单项</title>
</head>
<body>

	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">&nbsp;&nbsp;系统菜单清单</h2>
			</div>
			<div class="panel-body">
				<table class="mytable table table-hover">
					<thead>	
						<tr>
							<th>编号</th>
							<th>父菜单编号</th>
							<th>图标</th>
							<th>标题</th>
							<th>状态</th>
							<th>序号</th>
							<th>路径</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${items}" var="item">
							<tr>
								<td>${item.itemId }</td>
								<td>${item.pItemId}</td>
								<td>${item.title }</td>
								<td>${item.icon}</td>
								<td>${item.status}</td>
								<td>${item.orderNo}</td>
								<td>${item.url}</td>
								<td>
									<a href="/item/${item.id}/del"><span class="glyphicon glyphicon-trash"></span></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>