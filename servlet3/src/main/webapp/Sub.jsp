<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!int num1, num2, sub;%>

	<%
	num1 = Integer.parseInt(request.getParameter("num1"));
	num2 = Integer.parseInt(request.getParameter("num2"));
	sub = num1 - num2;
	%>

	<h1>
		Difference Between
		<%=num1%>
		and
		<%=num2%>
		=
		<%=sub%>
	</h1>

</body>
</html>