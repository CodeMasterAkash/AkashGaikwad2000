<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int num1, num2, sum;%>
	<%
	num1 = Integer.parseInt(request.getParameter("num1"));
	num2 = Integer.parseInt(request.getParameter("num2"));
	sum = num1 + num2;
	%>
	<h1>
		Sum Of
		<%=num1%>
		and
		<%=num2%>
		=
		<%=sum%>
	</h1>
</body>
</html>
<jsp:forward page="Sub.jsp"></jsp:forward>
