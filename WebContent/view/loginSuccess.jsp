<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success Page</title>
</head>
<body>
	<%--     request에 저장되어 있는 bean객체 조회 하여 customer의 이름 출력          --%>
	<h1>${customer.name} logged in successfully.</h1>
	<p>
		<a href="/helloMVC/index.jsp">go to home page</a>
	</p>
</body>
</html>