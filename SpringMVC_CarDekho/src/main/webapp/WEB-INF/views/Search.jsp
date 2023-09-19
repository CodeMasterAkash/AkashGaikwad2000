<%@page import="com.jspiders.SpringMVC_CarDekho.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
@SuppressWarnings("unchecked")
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
%>
<%
CarPOJO car = (CarPOJO) request.getAttribute("car");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEARCH PAGE</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Search Car Details</legend>
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Enter CarID</td>
						<td><input type="text" name="carId"></td>
					</tr>
				</table>
				<input type="submit" value="SEARCH">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (car != null) {
		%>
		<table id="data">
			<tr>
				<th>CARID</th>
				<th>CARNAME</th>
				<th>CARBRAND</th>
				<th>FUELTYPE</th>
				<th>PRICE</th>
			</tr>
			<tr>
				<td><%=car.getCarId()%></td>
				<td><%=car.getCarName()%></td>
				<td><%=car.getCarBrand()%></td>
				<td><%=car.getFuelType()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>
