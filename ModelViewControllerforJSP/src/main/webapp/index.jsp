<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ControllerServlet" method="post">
		Name:<input type="text" name="name"><br> <br>
		Password:<input	type="password" name="password"><br><br>
		<input type="submit" value="login">
	</form>
</body>
</html>