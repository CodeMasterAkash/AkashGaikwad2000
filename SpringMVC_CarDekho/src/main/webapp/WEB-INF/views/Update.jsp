<%@page import="com.jspiders.SpringMVC_CarDekho.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
@SuppressWarnings("unchecked")
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
CarPOJO pojo = (CarPOJO) request.getAttribute("car");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE PAGE</title>
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
	<div align="center">
		<%
		if (pojo == null) {
		%>
		<fieldset>
			<legend>Select Car</legend>
			<form action="./update" method="post">
				<table>
					<tr>
						<td>Enter CarID</td>
						<td><input type="text" name="carId"></td>
					</tr>
				</table>
				<input type="submit" value="SELECT">
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
			for (CarPOJO car : cars) {
			%>
			<tr>
				<td><%=car.getCarId()%></td>
				<td><%=car.getCarName()%></td>
				<td><%=car.getCarBrand()%></td>
				<td><%=car.getFuelType()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		} else {
		%>
		<fieldset>
			<legend>Update Car Records</legend>
			<form action="./updateCar" method="post">
				<table>
					<tr>
						<td>CarID</td>
						<td><%=pojo.getCarId()%></td>
						<td><input type="text" name="carId"
							value="<%=pojo.getCarId()%>" hidden="true"></td>
					</tr>
					<tr>
						<td>CarName</td>
						<td><input type="text" name="carName"
							value="<%=pojo.getCarName()%>"></td>
					</tr>
					<tr>
						<td>CarBrand</td>
						<td><input type="text" name="carBrand"
							value="<%=pojo.getCarBrand()%>"></td>
					</tr>
					<tr>
						<td>FuelType</td>
						<td><input type="text" name="fuelType"
							value="<%=pojo.getFuelType()%>"></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="number" name="price"
							value="<%=pojo.getPrice()%>"></td>
					</tr>
				</table>
				<input type="submit" value="UPDATE">
			</form>
		</fieldset>
		<%
		}
		%>
	</div>
</body>
</html>
