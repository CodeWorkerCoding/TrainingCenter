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
						<th>头像</th>
						<th>姓名</th>
						<th>别名</th>
						<th>描述</th>
						<th>状态</th>
						<th>添加时间</th>
						<th>最近修改时间</th>
						<th>操作</th>
					</tr>
				</thead>			
				<c:forEach var="star" items="${stars}" >
					<tr>
						<td>
							<a href="/star/${star._id}/look">
								<img alt="" src="${star.lately}" class="img-rounded">
							</a>
						</td>
						<%-- <td>${star._id}</td> --%>
						<td>
							<a href="/star/${star._id}/look">${star.name}</a>
						</td>	
						<td>${star.nickname}</td>
						<td>${star.mensurations}</td>
						<td>${star.recordStatus.desc}</td>
						<td>
							<fmt:formatDate value="${star.createTime}" pattern="yyyy-MM-dd"/>
						</td>
						<td>
							<fmt:formatDate value="${star.updateTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
						<td>
							<a href="/star/${star._id}/modify"><span><i class="glyphicon glyphicon-pencil"> </i>修改</span></a>
							<a href="/star/${star._id}/del"><span><i class="glyphicon glyphicon-trash"> </i>删除</span></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>总页数：${pages.totalPages} &nbsp;&nbsp;&nbsp;总条数：${pages.totalElements}</div>
		<!-- bootstrap的分页插件 -->
		<div class="nav-page">
			<ul class="pagination">
				<li><a href="/star/allbypage?page=1">首页</a></li>
				<c:if test="${pages.number>0}">
					<li><a href="/star/allbypage?page=${pages.number}">&laquo;</a></li>
				</c:if>
				<c:if test="${pages.totalPages > 5 && pages.number + 6 <= pages.totalPages}">
					<c:forEach begin="${pages.number + 1}" end="${pages.number + 5}" var="currpage">
						<li><a href="/star/allbypage?page=${currpage}">${currpage}</a></li>
					</c:forEach>
				</c:if>
				<c:if test="${page.number + 1 < pages.totalPages}">
					<li><a href="/star/allbypage?page=${pages.number+2}">&raquo;</a></li>
				</c:if>
				<li><a href="/star/allbypage?page=1">尾页</a></li>
			</ul>
		</div>
</body>
</html>