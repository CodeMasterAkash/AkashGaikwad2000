<%@page import="com.jspiders.SpringMVC_CarDekho.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
@SuppressWarnings("unchecked")
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
%>
<%
CarPOJO car = (CarPOJO) request.getAttribute("car");
%>

<jsp:include page="NavBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD PAGE</title>
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
</style>
</head>

<body>
<body>
	<div align="center">
		<fieldset>
			<legend>ADD CAR DETAILS</legend>
			<form action="./add" method="post">
				<table>
					<tr>
						<td>CarName</td>
						<td><input type="text" name="carName"></td>
					</tr>
					<tr>
						<td>CarBrand</td>
						<td><input type="text" name="carBrand"></td>
					</tr>
					<tr>
						<td>FuelType</td>
						<td><input type="text" name="fuelType"></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="number" name="price"></td>
					</tr>
				</table>
				<input type="submit" value="ADD">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
		<%
		if (cars != null) {
		%>
		<table id="data">
			<tr>
				<th>CarId</th>
				<th>CarName</th>
				<th>CarBrand</th>
				<th>FuelType</th>
				<th>Price</th>
			</tr>
			<%
			for (CarPOJO pojo : cars) {
			%>
			<tr>
				<td><%=pojo.getCarId()%></td>
				<td><%=pojo.getCarName()%></td>
				<td><%=pojo.getCarBrand()%></td>
				<td><%=pojo.getFuelType()%></td>
				<td><%=pojo.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
</html>