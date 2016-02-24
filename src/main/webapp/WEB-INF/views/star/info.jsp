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
	<div class="panel panel-default">
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
		<div class="panel-heading info-heading"><h2><strong>${star.name}</strong> 个人信息</h2></div>
		<div class="panel-body">
			<div class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-1">姓名:</label>
					<div class="col-sm-4"><span class="form-control">${star.name}</span></div>
					<label class="control-label col-sm-1">别名:</label>
					<div class="col-sm-4"><span class="form-control">${star.nickname}</span></div>
				</div><hr/>
				<div class="form-group">
					<label class="control-label col-sm-1">明星描述:</label>
					<div class="col-sm-9"><span class="form-control">${star.mensurations}</span></div>
				</div><hr/>
				<div class="form-group">
					<label class="control-label col-sm-2">明星相关图展示</label>
				</div><hr/>
				<div class="form-group">
					<div class="col-sm-offset-1">
						<div class="col-sm-6">
							<a href="#" class="thumbnail">
								<img alt="${star.name}-${star.name}" src="${star.lately}">
								<span class="caption"><p style="text-align: center; font-size: 8pt;"><strong>头像图片</strong></p></span>
							</a>
						</div>
						<c:if test="${fn:length(images)>1}">
							<c:forEach items="${images}" var="img">
								<div class="col-sm-3">
									<a href="#" class="thumbnail">
										<img alt="${star.name}-${img.name}" src="${fn:substring(img.url,42,fn:length(img.url))}">
									</a>
								</div>
							</c:forEach>
						</c:if>
						<!-- <div class="col-sm-3">
							<a href="#" class="thumbnail">
								<img alt="杨颖" src="/upload/杨颖/Lighthouse.jpg">
							</a>
						</div> -->
					</div>
				</div><hr/>
				<div class="form-group">
					<div class="col-sm-offset-4">
						<!-- 返回上一页 javascript:history.go(-1)  -->
						<!-- 返回上一页并刷新 javascript:self.location=document.referrer;  -->
						<!-- 刷新当前页 javascript:location.reload() -->
						<a class="col-sm-2 btn btn-default" href="javascript:location.reload()">
							<span>重新载入</span>
						</a>
						<a class="col-sm-offset-1 col-sm-3 btn btn-primary" href="javascript:history.back();">
							<span>返回</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>