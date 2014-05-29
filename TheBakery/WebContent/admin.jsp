<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery::admin</title>
</head>
<body>
	<h1>Admin page</h1>
	<h2>Order components</h2>

	<table class="components-table">
		<tr>
			<td><b>Components</b></td>
			<td><b>Amount</b></td>
			<td><b>Order new</b></td>
		</tr>

		<c:forEach items="${stock.components}" var="o">
			<tr>
				<td><a href="http://www.google.se/#q=${o.name}">${o.name}</a></td>
				<td>${o.amount}</td>
				<td>
					<form action="admin" method="post">
						<input type="hidden" name="id" value="${o.id}">
						<input type="text" name="amount" value="" /> 
						<input type="submit"name="order" value="Order" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

    <form action="product" method="post">
	<table class="admin-table">
		<tr>
			<td><b>Add product</b></td>
		</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="product"></td>
			</tr>
			<tr>
                <td>Description:</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price"></td>
            </tr>
			<tr>
				<td><input type="submit" value="Create"></td>
			</tr>
		</table>
	</form>
    <form action="product" method="post">
	<table>		
		<tr>
			<td><p><b>Add ingredient to product:</b></p></td>
		</tr>
			<tr>
				<td><select name="product">
						<c:forEach items="${stock.stock}" var="o">
							<option value="${o.id}">${o.name}</option>
						</c:forEach>
				</select></td>
				<td><select name="component">
						<c:forEach items="${stock.components}" var="o">
							<option value="${o.id}">${o.name}</option>
						</c:forEach>
				</select></td>
				<td><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>
</body>
</html>