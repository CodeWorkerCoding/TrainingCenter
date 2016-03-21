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
					<td><a href="${ed2k.ed2k}" title="${ed2k.ed2k}"><span class="ed2k">
						<c:when test="${fn:length(ed2k.ed2k) > 10 }">
							<c:out value="${fn:substring(ed2k.ed2k,0,10)}..."/>
						</c:when>
						<c:otherwise>
							<c:out value="${ed2k.ed2k}"/>
						</c:otherwise>
					</span></a></td>
					<td>
						<fmt:formatDate value="${ed2k.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
					</td>
					<td>
						<fmt:formatDate value="${ed2k.updateTime}" pattern="yyyy-MM-dd"></fmt:formatDate>
					</td>
					<td>
						<a href="/ed2k/${ed2k._id}/modify"><span><i class="glyphicon glyphicon-pencil"> </i>修改</span></a>
						<a href="/ed2k/${ed2k._id}/del"><span><i class="glyphicon glyphicon-trash"></i>删除</span></a>
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