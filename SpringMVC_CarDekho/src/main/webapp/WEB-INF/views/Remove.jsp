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
<title>REMOVE PAGE</title>
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
			<legend>REMOVE CAR DETAILS</legend>
			<form action="./remove" method="post">
				<table>
					<tr>
						<td>Enter CarID</td>
						<td><input type="text" name="carId"></td>
					</tr>
				</table>
				<input type="submit" value="REMOVE">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3>
			<%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (cars != null) {
		%>
		<table id="data">
			<tr>
				<th>CARID</th>
				<th>CARNAME</th>
				<th>CARBRAND</th>
				<th>FUELTYPE</th>
				<th>PRICE</th>
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
</body>
</html>