<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.java.model.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>You are successfully logged in!</p>
	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
		out.print("Welcome, " + bean.getName());
	%>
	
	
</body>
</html>