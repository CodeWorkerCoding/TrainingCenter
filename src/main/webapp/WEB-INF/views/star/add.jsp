<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
</head>
<body>
	<p>添加主演明星信息</p>
	<br>
	<form action="./save" method="post">
		<input type="text" placeholder="please enter the star name" name="name"><br/><br/>
		<input type="text" placeholder="please enter the star nicename" name="nickname"><br/><br/>
		<input type="text" placeholder="please enter the mensurations data and use ',' spilt" name="mensurations"><br/><br/>
		<input type="submit" value="submit_data">		
	</form>
	
</body>
</html>